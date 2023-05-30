package uniandes.dpoo.taller2.modelo;

public class IngredienteRepetidoException extends HamburguesaException{

	public IngredienteRepetidoException(Ingrediente pRepetido) {
		super(pRepetido,"Ingrediente");
	}
}
