package uniandes.dpoo.taller2.modelo;

public class HamburguesaException extends Exception{
	
	public HamburguesaException(Producto pRepetido, String tipo) {
		super(pRepetido.getNombre()+" se encuentra repetido ("+ tipo+")");
	}
	
	public HamburguesaException(Ingrediente pRepetido, String tipo) {
		super(pRepetido.getNombre()+" se encuentra repetido ("+ tipo+")");
	}
}
