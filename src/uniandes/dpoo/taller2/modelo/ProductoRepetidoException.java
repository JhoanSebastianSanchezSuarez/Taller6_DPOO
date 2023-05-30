package uniandes.dpoo.taller2.modelo;

public class ProductoRepetidoException extends HamburguesaException{
	
	private Producto producto;
	
	public ProductoRepetidoException(Producto pRepetido) {
		super(pRepetido, "Producto");
		producto = pRepetido;
	}
	
	public Producto retornarRepetido() {
		return producto;
	}

}
