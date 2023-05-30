package uniandes.dpoo.taller2.modelo;

public class ProductoRepetidoException extends HamburguesaException{

	public ProductoRepetidoException(Producto pRepetido) {
		super(pRepetido, "Producto");
	}

}
