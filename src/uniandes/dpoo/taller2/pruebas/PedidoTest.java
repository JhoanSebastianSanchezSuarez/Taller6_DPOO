package uniandes.dpoo.taller2.pruebas;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.taller2.modelo.Pedido;
import uniandes.dpoo.taller2.modelo.PedidoExcedidoException;
import uniandes.dpoo.taller2.modelo.ProductoMenu;

public class PedidoTest {

	private Pedido pedido;
    private ProductoMenu producto1;
    private ProductoMenu producto2;

    @BeforeEach
    public void setUp() throws IOException {
        pedido = new Pedido("Juan", "Calle 123");
        producto1 = new ProductoMenu("Pizza", 10000);
        producto2 = new ProductoMenu("Gaseosa", 3000);
    }

    @Test
    public void testAgregarProducto() {
        pedido.agregarProducto(producto1);
        assertEquals(10000, pedido.getPrecioNetoPedido());
    }

    @Test
    public void testGetPrecioNetoPedido() {
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);
        assertEquals(13000, pedido.getPrecioNetoPedido());
    }

    @Test
    public void testGetPrecioIVAPedido() {
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);
        assertEquals(2470, pedido.getPrecioIVAPedido());
    }

    @Test
    public void testGetPrecioTotalPedido() {
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);
        assertEquals(15470, pedido.getPrecioTotalPedido());
    }

    @Test
    public void testGenerarTextoFactura() {
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);
        String expected = "[Restaurante\n, Pedido: 6\n, Cliente: Juan\n, Direccion: Calle 123\n, --------Productos--------\n, $10000 Pizza\n, $3000 Gaseosa\n, Total neto: 13000\n, IVA: 2470\n, Total: 15470\n]";
        assertEquals(expected, pedido.generarTextoFactura().toString());
    }
    
    @Test
    void testExcepcion() throws IOException {
        Pedido pedido = new Pedido("Juan", "Calle 123");
        ProductoMenu producto1 = new ProductoMenu("Pizza", 100000);
        ProductoMenu producto2 = new ProductoMenu("Gaseosa", 60000);
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        Exception exception = assertThrows(PedidoExcedidoException.class, () -> {
            pedido.guardarFactura();
        });
        }
    
    @Test
    void testGuardarFactura() throws PedidoExcedidoException, IOException {
    	pedido.agregarProducto(producto1);
    	pedido.agregarProducto(producto2);
    	pedido.guardarFactura();
    	BufferedReader br = new BufferedReader(new FileReader("./data/nPedidos.txt"));
		String linea = br.readLine();
		br.close();
		int numeroPedidos = Integer.parseInt(linea);
		assertEquals(6, numeroPedidos);
    }
    
    @Test
    void testToString() {
    	pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);

        String expected = "6 Juan Calle 123 [Nombre: PizzaPrecio base: 10000, Nombre: GaseosaPrecio base: 3000]";
        assertEquals(expected, pedido.toString());
    }
}
