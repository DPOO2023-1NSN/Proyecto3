package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Administrador extends Usuario {
	//POR SI EL ID SE VA A LLEVAR EN UNA CUENTA
	private int contadorIdServicio= 0;
	
	public Administrador(String nombreUsuario, String contraseña, String nombre, String documento){
		super(nombreUsuario, contraseña, nombre, documento);
	}
	
	public int getContadorIdServicio() {
		return contadorIdServicio;
	}
	public void setContadorIdServicio(int contadorIdServicio) {
		this.contadorIdServicio = contadorIdServicio;
	}
	//FIN DE LO REFERENTE AL CONTADOR ID SERVICIO
	
	public void cargarInventario(File inventario) {
		//DEPENDE DE LA ESTRUCTURA XML
	}
	
	public void crearHabitacion(int id, int tipo, int capacidadAdultos, int capacidadNiños, Boolean balcon, Boolean vista, Boolean cocina, int tamaño, Boolean aire, Boolean calefaccion, int tamañoCama, Boolean tv, Boolean cafetera, Boolean ropaCama, Boolean plancha, Boolean secador, Boolean voltaje, Boolean tomasA, Boolean tomasC, Boolean desayuno) {
	    Habitacion habitacion = new Habitacion(id, tipo, capacidadAdultos, capacidadNiños, balcon, vista, cocina, tamaño, aire, calefaccion, tamañoCama, tv, cafetera, ropaCama, plancha, secador, voltaje, tomasA, tomasC, desayuno);
	    getinfo().addHabitacion(habitacion);
	}
	public void crearProductoMenu (File archivoMenu) {
		//DEPENDE DE LA ESTRUCTURA XML
	}
	public void crearServicio (String nombre, int precio) {
		//DEPENDE DE LA ESTRUCTURA XML
		Servicio servicio = new Servicio(((this.getContadorIdServicio())+1), nombre, precio); //GENERA EL ID EN UNA UNIDAD MAYOT A LA ANTERIOR
		getinfo().addServicio (servicio);
		
		this.setContadorIdServicio(this.getContadorIdServicio()*1); //SUMA 1 AL ATRIBUTO
	}
	public Boolean cargarPreciosHabitaciones (File archivoPrecios) {
		//DEPENDE DE LA ESTRUCTURA XML
		return true;
	}
	public void cambiarPrecioServicio (int id, int precio) {
		ArrayList <Servicio> listaServicios= getinfo().getServicios();
		for (int i=0; i< listaServicios.size(); i++ ) {
			if (id== listaServicios.get(i).getId()){
				listaServicios.get(i).setPrecio(precio);
			}
			
		}
		
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
