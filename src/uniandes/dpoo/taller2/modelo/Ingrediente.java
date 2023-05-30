package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;

public class Ingrediente {
	
	private String nombre;
	
	private int costoAdicional;
	
	public Ingrediente(String idnombre, int idcosto) {
		
		nombre = idnombre;
		
		costoAdicional = idcosto;
		
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public int getCostoAdicional() {
		
		return costoAdicional;
	}
	
	public boolean equals(Ingrediente ingrediente) {
		
		boolean rta = true;
		
		if(!(ingrediente.getNombre().equals(this.getNombre()))) {
			rta = false;
		}
		
		if(!(ingrediente.getCostoAdicional()==(this.getCostoAdicional()))){
			rta = false;
		}
		
		return rta;
	}

}
