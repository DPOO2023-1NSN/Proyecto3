package modelo;

import java.util.ArrayList;

public class Empleado extends Usuario{

	private String servicioEncargado;
	
	public Empleado(String nombreUsuario, String contraseña, String nombre, String documento, String servicioEncargado) {
		super(nombreUsuario, contraseña, nombre, documento);
		this.servicioEncargado = servicioEncargado;
	}

	public String getServicioEncargado() {
		return servicioEncargado;
	}
	
	public Habitacion consultarHabitacion(ArrayList<Habitacion> habitaciones, int id) {
		Habitacion habBuscada = null;
		for (Habitacion habitacion: habitaciones) {
			if (habitacion.getId() == id)
				habBuscada = habitacion;
		}
		
		return habBuscada;
	}
}
