package uniandes.dpoo.taller2.pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.taller2.modelo.ProductoMenu;

public class ProductoMenuTest {
	
	private ProductoMenu productoPrueba;
	
	@BeforeEach
	public void setUp() {
		productoPrueba = new ProductoMenu("Pizza", 10000); 
	}
	
	@Test
    public void testGetPrecio() {
        assertEquals(10000, productoPrueba.getPrecio());
    }

    @Test
    public void testGetNombre() {
        assertEquals("Pizza", productoPrueba.getNombre());
    }

    @Test
    public void testGenerarTextoFactura() {
        assertEquals("$10000 Pizza", productoPrueba.generarTextoFactura());
    }

    @Test
    public void testToString() {
        assertEquals("Nombre: PizzaPrecio base: 10000", productoPrueba.toString());
    }

    @Test
    public void testEquals() {
        ProductoMenu producto2 = new ProductoMenu("Pizza", 10000);
        assertTrue(productoPrueba.equals(producto2));
    }
    
    @Test
    public void testEquals2() {
    	ProductoMenu producto2 = new ProductoMenu("Pizza", 100000);
    	assertFalse(productoPrueba.equals(producto2));
    }
    
    @Test
    public void testEquals3() {
    	ProductoMenu producto2 = new ProductoMenu("Pizzza", 10000);
    	assertFalse(productoPrueba.equals(producto2));
    }
}
