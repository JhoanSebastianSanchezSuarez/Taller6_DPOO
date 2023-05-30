package uniandes.dpoo.taller2.procesamiento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import uniandes.dpoo.taller2.modelo.Producto;
import uniandes.dpoo.taller2.modelo.ProductoMenu;
import uniandes.dpoo.taller2.modelo.ProductoRepetidoException;
import uniandes.dpoo.taller2.modelo.Combo;
import uniandes.dpoo.taller2.modelo.Ingrediente;
import uniandes.dpoo.taller2.modelo.IngredienteRepetidoException;
import uniandes.dpoo.taller2.modelo.Pedido;
import uniandes.dpoo.taller2.modelo.PedidoExcedidoException;

public class Restaurante {
	
	public static ArrayList<ProductoMenu> menu = new ArrayList<ProductoMenu>();
	
	public static ArrayList<Combo> combos = new ArrayList<Combo>();
	
	public static ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	
	public static Pedido pedidoActual = null;
	
	private void cargarMenu(File archivoMenu) throws ProductoRepetidoException{
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoMenu))) {
			String linea = br.readLine();
			
			while (linea != null) {
				
				String[] valores = linea.split(";");
				
				String nproducto = valores[0];
				
				int valorproducto = Integer.parseInt(valores[1]);
				
				ProductoMenu agregadoproducto = new ProductoMenu(nproducto, valorproducto);
				
				if(verificarDobleProducto(agregadoproducto)) {
					throw new ProductoRepetidoException(agregadoproducto);
				}
				menu.add(agregadoproducto);
				
				linea = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al cargar el archivo de menu");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void cargarCombos(File archivoCombos) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoCombos))) {
			String linea = br.readLine();
			
			while (linea != null) {
				
				String[] valores = linea.split(";");
				
				String nproducto = valores[0];
				
				String stringDescuento = valores[1].replace("%", "");
				
				double ndescuento = Double.parseDouble(stringDescuento);

				Combo comboAgregado = new Combo(ndescuento, nproducto);
				
				for(int i = 2; i<valores.length; i++) {
					ProductoMenu productoParaCombo = buscarProductoMenuNombre(menu, valores[i]);
					comboAgregado.agregarItemACombo(productoParaCombo);
				}
				
				combos.add(comboAgregado);
				
				linea = br.readLine();
			}
		}catch (IOException e) {
			System.out.println("Ha ocurrido un error al cargar el archivo de combos");
			e.printStackTrace();	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void cargarIngredientes(File archivoIngredientes) throws IngredienteRepetidoException {
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes))) {
			String linea = br.readLine();
			
			while (linea != null) {
				
				String[] valores = linea.split(";");
				
				String nproducto = valores[0];
				
				int valorproducto = Integer.parseInt(valores[1]);
				
				Ingrediente agregadoingrediente = new Ingrediente(nproducto, valorproducto);
				
				if (verificarDobleIngrediente(agregadoingrediente)) {
					throw new IngredienteRepetidoException(agregadoingrediente);
				}
				
				ingredientes.add(agregadoingrediente);
				
				linea = br.readLine();
				
			
			}
		}catch (IOException e) {
			System.out.println("Ha ocurrido un error al cargar el archivo de ingredientes");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ProductoMenu buscarProductoMenuNombre(ArrayList<ProductoMenu> menu2, String nombre) {
		
		ProductoMenu elProducto = null;
		
		
		for(int i = 0; i < menu2.size() && elProducto == null ; i ++){
			
			ProductoMenu unProducto = menu2.get(i);
			String unProductoName = unProducto.getNombre();

			if(unProductoName.equals(nombre)){
				elProducto = unProducto; 
			}
			
		}
	return elProducto;}
	
	public ArrayList<ProductoMenu> getMenuBase(){
		return Restaurante.menu;
	}
	
	public ArrayList<Combo> getCombos(){
		return Restaurante.combos;
	}
	
	public ArrayList<Ingrediente> getIngredientes(){
		return Restaurante.ingredientes;
	}
	
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws ProductoRepetidoException, IngredienteRepetidoException {
		
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) throws IOException {
		
		pedidoActual = new Pedido(nombreCliente, direccionCliente);
		
	}
	
	public void cerrarYGuardarPedido() throws PedidoExcedidoException {
		
		pedidoActual.guardarFactura();
		
	}
	
	public Pedido getPedidoEnCurso() {
		
		return Restaurante.pedidoActual;
	}
	
	public boolean verificarDobleIngrediente(Ingrediente ingrediente) {
		boolean rta = false;
		
		for (Ingrediente aComparar: ingredientes) {
			if (rta == false) {
				if (aComparar.equals(ingrediente)) {
					rta= true;
				}
			}
		}
		return rta;
	}
	
	public boolean verificarDobleProducto(ProductoMenu producto) {
		boolean rta = false;
		
		for (ProductoMenu aComparar: menu) {
			if (rta == false) {
				if (producto.equals(aComparar)) {
					rta = true;
				}
			}
		}
		return rta;
	}
	public Restaurante() {

	}
}
