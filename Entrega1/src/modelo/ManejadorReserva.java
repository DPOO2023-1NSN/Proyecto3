package modelo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManejadorReserva {
	
	private static final File XML_Reservas = new File("data/reservas.xml");
	private static final String RESERVA = "RESERVA";
	private static final String RESERVAS = "RESERVAS";
	private static final String HABITACION = "HABITACION";
	private static final String GRUPO = "GRUPO";
	private static final String HUESPED = "HUESPED";
	private static final String HUESPEDR = "HUESPEDR";
	private static final String SERVICIO = "SERVICIO";

	private Document document;
		
	public ManejadorReserva(){
		try {
			this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(XML_Reservas);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void agregarReserva(Reserva reserva){
	        
	        // Crear el nodo de reserva con sus respectivos nodos hijos
	        Element reservaNode = document.createElement(RESERVA);
	        reservaNode.setAttribute("id", Integer.toString(reserva.getId()));
	        reservaNode.setAttribute("estado", reserva.getEstado().toString());
	        reservaNode.setAttribute("fechaInicio", reserva.getFechaInicio().toString());
	        reservaNode.setAttribute("fechaFin", reserva.getFechaFin().toString());
	        reservaNode.setAttribute("precio", Integer.toString(reserva.getPrecio()));
	        
	        // Crear el nodo de grupo y agregarlo como hijo del nodo de reserva
	        Grupo grupo = reserva.getGrupo();
	        Element grupoNode = document.createElement(GRUPO);
	        grupoNode.setAttribute("fechaCheckIn", grupo.getFechaCheckIn().toString());
	        grupoNode.setAttribute("realizoCheckIn", grupo.getRealizoCheckIn().toString());
	        grupoNode.setAttribute("fechaCheckOut", grupo.getFechaCheckOut().toString());
	        grupoNode.setAttribute("realizoCheckOut", grupo.getRealizocheckOut().toString());
	        
	        // Crea un nodo hijo de grupo para huesped responsable
	        Element huespedRNode = document.createElement(HUESPEDR);
	        huespedRNode.setAttribute("nombreUsuario", grupo.getHuespedResponsable().getNombreUsuario()); 
	        huespedRNode.setAttribute("contraseña", grupo.getHuespedResponsable().getContraseña());
	        huespedRNode.setAttribute("nombre", grupo.getHuespedResponsable().getNombre());
	        huespedRNode.setAttribute("documento", grupo.getHuespedResponsable().getDocumento());
	        huespedRNode.setAttribute("edad", Integer.toString(grupo.getHuespedResponsable().getEdad()));
	        huespedRNode.setAttribute("correoElectronico", grupo.getHuespedResponsable().getCorreoElectronico());
	        huespedRNode.setAttribute("telefono", grupo.getHuespedResponsable().getTelefono());
            grupoNode.appendChild(huespedRNode);
            
            // Crea los nodos hijos de grupo para los servicios
            ArrayList<Servicio> servicios = grupo.getServicios();
            if (servicios != null) {
            	for (Servicio servicio: servicios) {
                	Element servicioNode = document.createElement(SERVICIO);
                	servicioNode.setAttribute("id", Integer.toString(servicio.getId()));
                	servicioNode.setAttribute("nombre", servicio.getNombre());
                	servicioNode.setAttribute("pagado", Boolean.toString(servicio.getPagado()));
                	servicioNode.setAttribute("precio", Integer.toString(servicio.getPrecio()));
                	grupoNode.appendChild(servicioNode);
                }
            }
            
	        
	        // Crear nodos hijos para la lista de huespedes
	        ArrayList<Huesped> huespedes = grupo.getListaHuespedes();
	        if (huespedes != null) {
	        	for (Huesped huesped : huespedes) {
		            Element huespedNode = document.createElement(HUESPED);
		            huespedNode.setAttribute("nombreUsuario", huesped.getNombreUsuario());
		            huespedNode.setAttribute("contraseña", huesped.getContraseña());
		            huespedNode.setAttribute("nombre", huesped.getNombre());
		            huespedNode.setAttribute("documento", huesped.getDocumento());
		            huespedNode.setAttribute("edad", Integer.toString(huesped.getEdad()));
		            huespedNode.setAttribute("correoElectronico", huesped.getCorreoElectronico());
		            huespedNode.setAttribute("telefono", huesped.getTelefono());
		            grupoNode.appendChild(huespedNode);
		        }
	        }
	        
	        reservaNode.appendChild(grupoNode);
	        
	        // Crear nodos hijos para la lista de habitaciones
	        ArrayList<Habitacion> habitaciones = reserva.getListaHabitaciones();
	        for (Habitacion habitacion : habitaciones) {
	            Element habitacionNode = document.createElement(HABITACION);
	            habitacionNode.setAttribute("id", Integer.toString(habitacion.getId()));
	            habitacionNode.setAttribute("tipo", Integer.toString(habitacion.getTipo()));
	            habitacionNode.setAttribute("capacidadAdultos", Integer.toString(habitacion.getCapacidadAdultos()));
	            habitacionNode.setAttribute("capacidadNinios", Integer.toString(habitacion.getCapacidadNinios()));
	            habitacionNode.setAttribute("reservada", Boolean.toString(habitacion.getReservada()));
	            habitacionNode.setAttribute("balcon", Boolean.toString(habitacion.getBalcon()));
	            habitacionNode.setAttribute("vista", Boolean.toString(habitacion.getVista()));
	            habitacionNode.setAttribute("cocina", Boolean.toString(habitacion.getCocina()));
	            habitacionNode.setAttribute("tamanio", Integer.toString(habitacion.getTamaño()));
	            habitacionNode.setAttribute("aire", Boolean.toString(habitacion.getAire()));
	            habitacionNode.setAttribute("calefaccion", Boolean.toString(habitacion.getCalefaccion()));
	            habitacionNode.setAttribute("tamanioCama", Integer.toString(habitacion.getTamañoCama()));
	            habitacionNode.setAttribute("tv", Boolean.toString(habitacion.getTv()));
	            habitacionNode.setAttribute("cafetera", Boolean.toString(habitacion.getCafetera()));
	            habitacionNode.setAttribute("ropaCama", Boolean.toString(habitacion.getRopaCama()));
	            habitacionNode.setAttribute("plancha", Boolean.toString(habitacion.getPlancha()));
	            habitacionNode.setAttribute("secador", Boolean.toString(habitacion.getSecador()));
	            habitacionNode.setAttribute("voltaje", Boolean.toString(habitacion.getVoltaje()));
	            habitacionNode.setAttribute("tomasA", Boolean.toString(habitacion.getTomasA()));
	            habitacionNode.setAttribute("tomasC", Boolean.toString(habitacion.getTomasC()));
	            habitacionNode.setAttribute("desayuno", Boolean.toString(habitacion.getDesayuno()));
	            reservaNode.appendChild(habitacionNode);
	        }

	        reservaNode.appendChild(grupoNode);
	        
	        // Agregar el nodo de reserva al final del archivo
	        Node reservasNode = document.getElementsByTagName(RESERVAS).item(0);
	        reservasNode.appendChild(reservaNode);
	        
	        // Guarda los cambios
	        guardarCambiosEnArchivo();
	        
	    }
	

	public ArrayList<Reserva> obtenerReservas(){
		ArrayList<Reserva> reservas = new ArrayList<>();
		// Obtiene la lista de nodos de reservas
		NodeList nodosReservas = document.getElementsByTagName(RESERVA);
		
		// Recorre cada nodo de reservas
		for (int i = 0; i < nodosReservas.getLength(); i++) {
			Element elementoReserva = (Element) nodosReservas.item(i);
			
			// Encuentra los atributos de la reserva
			LocalDate fechaInicio = LocalDate.parse(elementoReserva.getAttribute("fechaInicio"));
			LocalDate fechaFin = LocalDate.parse(elementoReserva.getAttribute("fechaFin"));
			Estado estado = Estado.valueOf(elementoReserva.getAttribute("estado"));
			int id = Integer.parseInt(elementoReserva.getAttribute("id"));
			int precio = Integer.parseInt(elementoReserva.getAttribute("precio"));
			
			// Obtiene la lista de nodos de habitaciones y obtiene un ArrayList de habitaciones
			NodeList nodosHabitaciones = elementoReserva.getElementsByTagName(HABITACION);
			ArrayList<Habitacion> habitaciones = obtenerHabDeNodeList(nodosHabitaciones);
			
			// Encuentra el elemento grupo y obtiene un objeto tipo Grupo
			Element elementoGrupo = (Element) elementoReserva.getElementsByTagName(GRUPO).item(0);
			Grupo grupo = obtenerGrupoDeElemento(elementoGrupo);
			
			// Crea la reserva y le da sus atributos
			Reserva reserva = new Reserva(grupo, fechaInicio, fechaFin);
			reserva.setEstado(estado);
			reserva.setId(id);
			reserva.setPrecio(precio);
			
			// Agrega las habitaciones
			for(Habitacion habitacion: habitaciones) {
				reserva.agregarHabitacion(habitacion);
			}
			reservas.add(reserva);
			
		}
		
		return reservas;
	}
	
	public ArrayList<Habitacion> obtenerHabDeNodeList(NodeList nodosHabitaciones) {
	    ArrayList<Habitacion> habitaciones = new ArrayList<>();
	    for (int i = 0; i < nodosHabitaciones.getLength(); i++) {
	        Element elementoHabitacion = (Element) nodosHabitaciones.item(i);
	        int id = Integer.parseInt(elementoHabitacion.getAttribute("id"));
	        int tipo = Integer.parseInt(elementoHabitacion.getAttribute("tipo"));
	        int capacidadAdultos = Integer.parseInt(elementoHabitacion.getAttribute("capacidadAdultos"));
	        int capacidadNinios = Integer.parseInt(elementoHabitacion.getAttribute("capacidadNinios"));
	        boolean reservada = Boolean.parseBoolean(elementoHabitacion.getAttribute("reservada"));
	        boolean balcon = Boolean.parseBoolean(elementoHabitacion.getAttribute("balcon"));
	        boolean vista = Boolean.parseBoolean(elementoHabitacion.getAttribute("vista"));
	        boolean cocina = Boolean.parseBoolean(elementoHabitacion.getAttribute("cocina"));
	        int tamaño = Integer.parseInt(elementoHabitacion.getAttribute("tamanio"));
	        boolean aire = Boolean.parseBoolean(elementoHabitacion.getAttribute("aire"));
	        boolean calefaccion = Boolean.parseBoolean(elementoHabitacion.getAttribute("calefaccion"));
	        int tamañoCama = Integer.parseInt(elementoHabitacion.getAttribute("tamanioCama"));
	        boolean tv = Boolean.parseBoolean(elementoHabitacion.getAttribute("tv"));
	        boolean cafetera = Boolean.parseBoolean(elementoHabitacion.getAttribute("cafetera"));
	        boolean ropaCama = Boolean.parseBoolean(elementoHabitacion.getAttribute("ropaCama"));
	        boolean plancha = Boolean.parseBoolean(elementoHabitacion.getAttribute("plancha"));
	        boolean secador = Boolean.parseBoolean(elementoHabitacion.getAttribute("secador"));
	        boolean voltaje = Boolean.parseBoolean(elementoHabitacion.getAttribute("voltaje"));
	        boolean tomasA = Boolean.parseBoolean(elementoHabitacion.getAttribute("tomasA"));
	        boolean tomasC = Boolean.parseBoolean(elementoHabitacion.getAttribute("tomasC"));
	        boolean desayuno = Boolean.parseBoolean(elementoHabitacion.getAttribute("desayuno"));

	        Habitacion habitacion = new Habitacion(id, tipo, capacidadAdultos, capacidadNinios, balcon, vista, cocina, tamaño, aire, calefaccion, tamañoCama, tv, cafetera, ropaCama, plancha, secador, voltaje, tomasA, tomasC, desayuno);
	        habitacion.setReservada(reservada);
	        habitaciones.add(habitacion);
	    }

	    return habitaciones;
	}
	
	
	public Grupo obtenerGrupoDeElemento(Element elementoGrupo) {
		LocalDate fechaCheckIn = LocalDate.parse(elementoGrupo.getAttribute("fechaCheckIn"));
		LocalDate fechaCheckOut = LocalDate.parse(elementoGrupo.getAttribute("fechaCheckOut"));
		Boolean realizoCheckIn = Boolean.parseBoolean(elementoGrupo.getAttribute("realizoCheckIn"));
		Boolean realizoCheckOut = Boolean.parseBoolean(elementoGrupo.getAttribute("realizoCheckOut"));
		
		// Obtiene el huesped responsable
		Element elementoHuespedR = (Element) elementoGrupo.getElementsByTagName(HUESPEDR).item(0);
		String nombreUsuario = elementoHuespedR.getAttribute("nombre");
		String contraseña = elementoHuespedR.getAttribute("contraseña");
		String nombre = elementoHuespedR.getAttribute("nombre");
		String documento = elementoHuespedR.getAttribute("documento");
		int edad = Integer.parseInt(elementoHuespedR.getAttribute("edad"));
		String correoElectronico = elementoHuespedR.getAttribute("correoElectronico");
		String telefono = elementoHuespedR.getAttribute("telefono");
		
		Huesped huespedR = new Huesped(nombreUsuario, contraseña, nombre, documento, edad, correoElectronico, telefono);
		
		// Crea la lista de huespedes
		NodeList nodosHuespedes = elementoGrupo.getElementsByTagName(HUESPED);
		ArrayList<Huesped> listaHuespedes = new ArrayList<Huesped>();
		
		for (int i = 0; i < nodosHuespedes.getLength(); i++) {
			Element elementoHuesped = (Element) nodosHuespedes.item(i);
			
			nombreUsuario = elementoHuesped.getAttribute("nombre");
			contraseña = elementoHuesped.getAttribute("contraseña");
			nombre = elementoHuesped.getAttribute("nombre");
			documento = elementoHuesped.getAttribute("documento");
			edad = Integer.parseInt(elementoHuesped.getAttribute("edad"));
			correoElectronico = elementoHuesped.getAttribute("correoElectronico");
			telefono = elementoHuesped.getAttribute("telefono");
			
			Huesped huesped = new Huesped(nombreUsuario, contraseña, nombre, documento, edad, correoElectronico, telefono);
			listaHuespedes.add(huesped);
		}
		
		// Crea el grupo y actualiza sus datos
		Grupo grupo = new Grupo(listaHuespedes, huespedR, fechaCheckIn, fechaCheckOut);
		grupo.setRealizoCheckIn(realizoCheckIn);
		grupo.setRealizocheckOut(realizoCheckOut);
		
		// Recorre los nodos de Servicios y los añade al grupo
		NodeList nodosServicios = elementoGrupo.getElementsByTagName(SERVICIO);
		
		for (int i = 0; i < nodosServicios.getLength(); i++) {
			Element elementoServicio = (Element) nodosServicios.item(i);
			
			int idE = Integer.parseInt(elementoServicio.getAttribute("id"));
			String nombreE = elementoServicio.getAttribute("nombre");
			Boolean pagadoE = Boolean.parseBoolean(elementoServicio.getAttribute("pagado"));
			int precioE = Integer.parseInt(elementoServicio.getAttribute("precio"));
			
			Servicio servicio = new Servicio(idE, nombreE, precioE);
			servicio.setPagado(pagadoE);
			grupo.addServicio(servicio);
		}
		
		return grupo;
	}
	
	public void cambiarEstadoReserva(int idReserva, Estado nuevoEstado) {
	    NodeList nodosReservas = document.getElementsByTagName(RESERVA);

	    // Recorre cada nodo de reserva
	    for (int i = 0; i < nodosReservas.getLength(); i++) {
	        Element elementoReserva = (Element) nodosReservas.item(i);
	        int id = Integer.parseInt(elementoReserva.getAttribute("id"));

	        // Comprueba si el ID coincide
	        if (id == idReserva) {
	            elementoReserva.setAttribute("estado", nuevoEstado.toString());
	            guardarCambiosEnArchivo();
	            break;
	        }
	    }
	}

	private void guardarCambiosEnArchivo() {
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer;
	    try {
	        transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource source = new DOMSource(document);
	        StreamResult result = new StreamResult(XML_Reservas);
	        transformer.transform(source, result);
	    } catch (TransformerException e) {
	        e.printStackTrace();
	    }
	    
	    
	}
	
	}

