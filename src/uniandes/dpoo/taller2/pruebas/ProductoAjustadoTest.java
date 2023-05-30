package uniandes.dpoo.taller2.pruebas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.taller2.modelo.Ingrediente;
import uniandes.dpoo.taller2.modelo.ProductoAjustado;
import uniandes.dpoo.taller2.modelo.ProductoMenu;

public class ProductoAjustadoTest {

	private ProductoAjustado productoAjustado;
    private Ingrediente ingrediente1;
    private Ingrediente ingrediente2;

    @BeforeEach
    public void setUp() {
        ProductoMenu productoBase = new ProductoMenu("Pizza", 10000);
        productoAjustado = new ProductoAjustado(productoBase);
        ingrediente1 = new Ingrediente("Queso", 2000);
        ingrediente2 = new Ingrediente("Pepperoni", 3000);
    }

    @Test
    public void testAgregarIngrediente() {
        productoAjustado.agregarIngrediente(ingrediente1);
        assertEquals(12000, productoAjustado.getPrecio());
    }

    @Test
    public void testEliminarIngrediente() {
        productoAjustado.eliminarIngrediente(ingrediente1);
        assertEquals(10000, productoAjustado.getPrecio());
    }

    @Test
    public void testEliminarAgregarIngrediente() {
    	productoAjustado.eliminarIngrediente(ingrediente1);
    	productoAjustado.agregarIngrediente(ingrediente1);
    	assertEquals(10000, productoAjustado.getPrecio());
    }
    
    @Test
    public void testAgregarEliminarIngrediente() {
    	productoAjustado.agregarIngrediente(ingrediente2);
    	productoAjustado.eliminarIngrediente(ingrediente2);
    	assertEquals(10000, productoAjustado.getPrecio());
    }
    
    @Test
    public void testGetPrecio() {
        productoAjustado.agregarIngrediente(ingrediente1);
        productoAjustado.agregarIngrediente(ingrediente2);
        assertEquals(15000, productoAjustado.getPrecio());
    }

    @Test
    public void testGetNombre() {
        assertEquals("Pizza modificado ", productoAjustado.getNombre());
    }

    @Test
    public void testGenerarTextoFactura() {
        productoAjustado.agregarIngrediente(ingrediente1);
        productoAjustado.eliminarIngrediente(ingrediente2);
        assertEquals("$12000 Pizza modificado (Adicion de Queso/Sin Pepperoni)", productoAjustado.generarTextoFactura());
    }
    
    @Test
    public void testGeneraTextoFactura2() {
    	productoAjustado.agregarIngrediente(ingrediente1);
    	productoAjustado.agregarIngrediente(ingrediente2);
    	assertEquals("$15000 Pizza modificado (Adicion de Queso, Pepperoni)",productoAjustado.generarTextoFactura());
    }
    
    @Test
    public void testGeneraTextoFactura3() {
    	productoAjustado.eliminarIngrediente(ingrediente1);
    	productoAjustado.eliminarIngrediente(ingrediente2);
    	assertEquals("$10000 Pizza modificado (Sin Queso, Pepperoni)",productoAjustado.generarTextoFactura());
    }
}
