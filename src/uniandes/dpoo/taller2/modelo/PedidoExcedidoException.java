package uniandes.dpoo.taller2.modelo;

public class PedidoExcedidoException extends Exception {
	
	int costo;
	
	public PedidoExcedidoException(int valor) {
		super("Ha excedido el limite por pedido de 150.000 pesos");
		costo = valor;
	}
	
	public int costo() {
		return this.costo;
	}

}
