package uniandes.dpoo.taller2.modelo;

public class IngredienteRepetidoException extends HamburguesaException{

	Ingrediente ingrediente;
	
	public IngredienteRepetidoException(Ingrediente pRepetido) {
		super(pRepetido,"Ingrediente");
		ingrediente = pRepetido;
	}
	
	public Ingrediente retornarRepetido() {
		return ingrediente;
	}
}
