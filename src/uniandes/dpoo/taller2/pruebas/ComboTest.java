package uniandes.dpoo.taller2.pruebas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.taller2.modelo.Combo;
import uniandes.dpoo.taller2.modelo.ProductoMenu;

public class ComboTest {

	private Combo combo;
    private ProductoMenu producto1;
    private ProductoMenu producto2;

    @BeforeEach
    public void setUp() {
        combo = new Combo(10.0, "Combo Pizza");
        producto1 = new ProductoMenu("Pizza", 10000);
        producto2 = new ProductoMenu("Gaseosa", 3000);
    }

    @Test
    public void testAgregarItemACombo() {
        combo.agregarItemACombo(producto1);
        combo.agregarItemACombo(producto2);
        assertEquals(11700, combo.getPrecio());
    }

    @Test
    public void testGetPrecio() {
        combo.agregarItemACombo(producto1);
        combo.agregarItemACombo(producto2);
        assertEquals(11700, combo.getPrecio());
    }

    @Test
    public void testGetNombre() {
        assertEquals("Combo Pizza", combo.getNombre());
    }

    @Test
    public void testGenerarTextoFactura() {
        combo.agregarItemACombo(producto1);
        combo.agregarItemACombo(producto2);
        assertEquals("$11700 Combo Pizza", combo.generarTextoFactura());
    }

    @Test
    public void testToString() {
        combo.agregarItemACombo(producto1);
        combo.agregarItemACombo(producto2);
        assertEquals("Nombre: Combo Pizza Precio: 11700 Productos: [Nombre: PizzaPrecio base: 10000, Nombre: GaseosaPrecio base: 3000]", combo.toString());
    }
    
}
