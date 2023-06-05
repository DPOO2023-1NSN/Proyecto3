package procesamiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modelo.Administrador;
import modelo.Empleado;
import modelo.Grupo;
import modelo.Habitacion;
import modelo.Huesped;
import modelo.Informacion;
import modelo.Reserva;
import modelo.Servicio;
import modelo.Usuario;
import modelo.Estado;

public class Hotel {
	private ArrayList <Usuario> listaUsuarios;
	private Informacion informacion;
	private Usuario usuarioActual;

	private Boolean parqueaderoFree;
	private Boolean piscina;
	private Boolean zonasHumedas;
	private Boolean bbq;
	private Boolean wifi;
	private Boolean recepcion;
	private Boolean mascotas;

	private File archivoPasarelas;


	public Hotel () throws SAXException, IOException, ParserConfigurationException{
		archivoPasarelas= new File ("data/listaPasarelas.txt");
		this.informacion = new Informacion();
		cargarConfig("data/config.txt");
		listaUsuarios= new ArrayList<Usuario>();
		listaUsuarios.add(new Usuario("Absoluto", "none", "absoluto", "none"));
	}

	//LOGIN Y REGISTRO
	public int ejecutarLogIn (String nombreUsuario, String contrasenia){
		usuarioActual= informacion.getUsuario(nombreUsuario, contrasenia);

		if (usuarioActual== null) {
			return 0;
		}
		else if (usuarioActual instanceof Administrador){
			return 1;
		}
		else if (usuarioActual instanceof Empleado){
			return 2;
		}
		else {
			return 3; //ES HUESPED
		}



	}


	public void registrarAdmin(String nombreUsuario, String contraseña, String nombre, String documento){
		Administrador admin= new Administrador(nombreUsuario, contraseña, nombre, documento);
		informacion.addUsuario(admin);
	}
	public void registrarEmpleado(String nombreUsuario, String contraseña, String nombre, String documento, String servicioEncargado){
		Empleado empleado= new Empleado (nombreUsuario, contraseña, nombre, documento, servicioEncargado);
		informacion.addUsuario(empleado);
	}
	public void registrarHuesped(String nombreUsuario, String contraseña, String nombre, String documento, int edad, String correo, String telefono ){
		Huesped huesped= new Huesped (nombreUsuario, contraseña, nombre, documento, edad, correo, telefono );
		informacion.addUsuario(huesped);
	}

	//FUNCCIONES ADMIN
	public void asignarPrecioHabitaciones(int tipo, int diaInicio, int diaFin, int mesInicio, int mesfin, int diaSemanaInicio, int diaSemanaFin,
			int precio)
	{
		//COMPLETAR-----------------------------------------------------
	}
	public void asignarMenusRestaurante( String rutaArchivo)
	{
		//COMPLETAR---------------------------------------------------------------
	}
	public void cambiarPlatoRestaurante( String nombrePlato, int nuevoPrecio)
	{
		//COMPLETAR---------------------------------------------------------------
	}
	public void crearHabitacion(int id, int tipo, int capacidadAdultos, int capacidadNiños, Boolean balcon, Boolean vista, Boolean cocina, int tamaño, Boolean aire, Boolean calefaccion, int tamañoCama, Boolean tv, Boolean cafetera, Boolean ropaCama, Boolean plancha, Boolean secador, Boolean voltaje, Boolean tomasA, Boolean tomasC, Boolean desayuno){
		if (usuarioActual instanceof Administrador) {
			((Administrador)usuarioActual).crearHabitacion(id, tipo, capacidadAdultos, capacidadNiños, balcon, vista, cocina, tamaño, aire, calefaccion, tamañoCama, tv, cafetera, ropaCama, plancha, secador, voltaje, tomasA, tomasC, desayuno);
		}
	}
	public void caragarArchivoHabitaciones(String rutaArchivo){
		//COMPLETAR______________________________________________________
	}
	public void caragarArchivoServicios(String rutaArchivo){
		//COMPLETAR______________________________________________________
	}

	public Habitacion obtenerHabitacion(int id) {
		Habitacion hab = null;
		if (usuarioActual instanceof Administrador) {
			hab = ((Administrador)usuarioActual).consultarHabitacion(informacion.getHabitaciones(), id);
		}
		else if (usuarioActual instanceof Empleado) {
			hab = ((Empleado)usuarioActual).consultarHabitacion(informacion.getHabitaciones(), id);
		}
		return hab;
	}

	//FUNCIONES EMPLEADO
	//NECESARIAS PARA CREAR RESERVA



	public void crearGrupoYReserva (ArrayList<ArrayList<String>> listaHuespedes, LocalDate fechaCheckIn, LocalDate fechaCheckOut){
		ArrayList<Huesped> listhuespedes= new ArrayList <Huesped>();
		for (int i=0; i< listaHuespedes.size();i++ ){
			Huesped huespedTemporal= new Huesped(listaHuespedes.get(i).get(0),
					listaHuespedes.get(i).get(1),
					listaHuespedes.get(i).get(2),
					listaHuespedes.get(i).get(3),
					Integer.parseInt(listaHuespedes.get(i).get(4)),
					listaHuespedes.get(i).get(5),
					listaHuespedes.get(i).get(6)
					);
			listhuespedes.add(huespedTemporal);
			listaUsuarios.get(0).getinfo().addUsuario(huespedTemporal); //ADICIONALMENTE SE REGISTRA EN EL SISTEMA
		}
		Huesped huespedResponsable= listhuespedes.get(0);
		listhuespedes.remove(0);

		Grupo nuevoGrupo = new Grupo(listhuespedes, huespedResponsable, fechaCheckIn, fechaCheckOut);
		Reserva nuevaReserva= new Reserva(nuevoGrupo, fechaCheckIn, fechaCheckOut);
		listaUsuarios.get(0).getinfo().addReserva(nuevaReserva);

	}

	public void cancelarReserva(int id) {
		Estado nuevoEstado= Estado.TERMINADA;
		listaUsuarios.get(0).getinfo().cambiarEstadoReserva(id, nuevoEstado);
	}
	public ArrayList<Integer> consultarPagosPendientesPrecio(int id) {
		ArrayList<Integer> listPrecios= new  ArrayList<Integer>();
		ArrayList<Reserva> listReservas= listaUsuarios.get(0).getinfo().getReservas();
		Reserva reserva= null;
		for (int i=0; i<listReservas.size(); i++) {
			if (listReservas.get(i).getId()== (id)) {
				reserva= listReservas.get(i);
			}
		}
		ArrayList<Servicio> listservicios= reserva.getGrupo().getServicios();

		for (int i=0; i<listservicios.size(); i++) {
			listPrecios.add(listservicios.get(i).getPrecio());
		}
		return listPrecios;
	}
	public ArrayList<String> consultarPagosPendientesNombre(int id) {
		ArrayList<String> listPrecios= new  ArrayList<String>();
		ArrayList<Reserva> listReservas= listaUsuarios.get(0).getinfo().getReservas();
		Reserva reserva= null;
		for (int i=0; i<listReservas.size(); i++) {
			if (listReservas.get(i).getId()== (id)) {
				reserva= listReservas.get(i);
			}
		}
		ArrayList<Servicio> listservicios= reserva.getGrupo().getServicios();

		for (int i=0; i<listservicios.size(); i++) {
			if (listservicios.get(i).getPagado()== false) {
				listPrecios.add(listservicios.get(i).getNombre());
			}
		}
		return listPrecios;
	}

	public void registrarCobro (int idReserva , String nombreServicio) {
		Servicio servicioActual= null;
		ArrayList<Servicio> listaServicios= listaUsuarios.get(0).getinfo().getServicios();
		for (int i=0; i<listaServicios.size(); i++) {
			if (listaServicios.get(i).getNombre().equals(nombreServicio)) {
				servicioActual= listaServicios.get(i);
			}
		}
		listaUsuarios.get(0).getinfo().agregarServicioReserva(idReserva, servicioActual);	
	}
	public void checkIn (int idReserva) {
		listaUsuarios.get(0).getinfo().cambiarEstadoReserva(idReserva, (Estado.ENPROCESO));
	}
	public void checkOut (int idReserva) {
		listaUsuarios.get(0).getinfo().cambiarEstadoReserva(idReserva, (Estado.TERMINADA));
	}
	public Boolean añadirALaReserva(int idHabitacion, int idReserva) {
		ArrayList<Habitacion> listaHabitaciones= listaUsuarios.get(0).getinfo().getHabitaciones();
		for (int i=0; i<listaHabitaciones.size(); i++) {
			if (listaHabitaciones.get(i).getId()==idHabitacion) {
				Habitacion habitacion= listaHabitaciones.get(i);
				if (habitacion.getReservada()==false) {
					ArrayList<Reserva> listaReservas= listaUsuarios.get(0).getinfo().getReservas();
					for (int j=0; j<listaReservas.size(); j++) {
						if (listaReservas.get(i).getId()== idReserva) {
							listaReservas.get(i).agregarHabitacion(habitacion);
						}
					}
					return true;}	
			}
		}
		return false;
	}

	public void cargarConfig(String rutaArchivo) { 
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(":");
				if (partes.length == 2) {
					String propiedad = partes[0].trim();
					String valor = partes[1].trim();
					asignarValorPropiedad(propiedad, valor);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void asignarValorPropiedad(String propiedad, String valor) {
		switch (propiedad) {
		case "parqueadero_pago":
			parqueaderoFree = Boolean.parseBoolean(valor);
			break;
		case "piscina":
			piscina = Boolean.parseBoolean(valor);
			break;
		case "zonas_humedas":
			zonasHumedas = Boolean.parseBoolean(valor);
			break;
		case "bbq":
			bbq = Boolean.parseBoolean(valor);
			break;
		case "wifi":
			wifi = Boolean.parseBoolean(valor);
			break;
		case "recepcion":
			recepcion = Boolean.parseBoolean(valor);
			break;
		case "mascotas":
			mascotas = Boolean.parseBoolean(valor);
			break;
		}
	}

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public Boolean getParqueaderoFree() {
		return parqueaderoFree;
	}

	public Boolean getPiscina() {
		return piscina;
	}

	public Boolean getZonasHumedas() {
		return zonasHumedas;
	}

	public Boolean getWifi() {
		return wifi;
	}

	public Boolean getRecepcion() {
		return recepcion;
	}

	public Boolean getMascotas() {
		return mascotas;
	}
	
	public Boolean getBbq() {
		return bbq;
	}
	public ArrayList<String> getListaPasarelas() throws IOException {
	  	BufferedReader lector = new BufferedReader (new FileReader (archivoPasarelas));
  		 String linea = lector.readLine() ; 
  		 ArrayList<String> listaPasarelas= new ArrayList<String>();
  		 
  		 while (linea!= null) { 
  			listaPasarelas.add(linea);
  		 }
  			 return listaPasarelas;
	}
	public Informacion getInfo() {
		return this.informacion;
	}	
}
