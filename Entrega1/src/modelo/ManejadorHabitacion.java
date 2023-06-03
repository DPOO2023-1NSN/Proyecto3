package modelo;

import java.io.File;
import java.io.IOException;
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


public class ManejadorHabitacion {
	private static final File XML_Habitaciones = new File("data/habitaciones.xml");
	private static final String HABITACION = "HABITACION";
	private static final String ID = "ID";
	private static final String TIPO = "TIPO";
	private static final String CAPACIDADADULTOS = "CAPACIDADADULTOS";
	private static final String CAPACIDADNINIOS = "CAPACIDADNINIOS";
	private static final String RESERVADA = "RESERVADA";
	private static final String BALCON = "BALCON";
	private static final String VISTA = "VISTA";
	private static final String COCINA = "COCINA";
	private static final String TAMANO = "TAMANIO";
	private static final String AIRE = "AIRE";
	private static final String CALEFACCION = "CALEFACCION";
	private static final String TAMANOCAMA = "TAMANIOCAMA";
	private static final String TV = "TV";
	private static final String CAFETERA = "CAFETERA";
	private static final String ROPACAMA = "ROPACAMA";
	private static final String PLANCHA = "PLANCHA";
	private static final String SECADOR = "SECADOR";
	private static final String VOLTAJE = "VOLTAJE";
	private static final String TOMASA = "TOMASA";
	private static final String TOMASC = "TOMASC";
	private static final String DESAYUNO = "DESAYUNO";
	
	
	private Document document;
	
	public ManejadorHabitacion(){
		try {
			this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(XML_Habitaciones);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public NodeList getNodosHabitaciones() {
		return document.getElementsByTagName(HABITACION);
	}
	
	public void agregarHabitacion(Habitacion habitacion){
		Node nodoHabitaciones = document.getFirstChild();
		Element nuevaHabitacion = document.createElement(HABITACION);
		nuevaHabitacion.setAttribute(ID, Integer.toString(habitacion.getId()));
		nodoHabitaciones.appendChild(nuevaHabitacion);
		
		Element tipo = document.createElement(TIPO);
		tipo.appendChild(document.createTextNode(Integer.toString(habitacion.getTipo())));
		nuevaHabitacion.appendChild(tipo);
		
		Element capacidadAdultos = document.createElement(CAPACIDADADULTOS);
		capacidadAdultos.appendChild(document.createTextNode(Integer.toString(habitacion.getCapacidadAdultos())));
		nuevaHabitacion.appendChild(capacidadAdultos);
		
		Element capacidadNinios = document.createElement(CAPACIDADNINIOS);
		capacidadNinios.appendChild(document.createTextNode(Integer.toString(habitacion.getCapacidadNinios())));
		nuevaHabitacion.appendChild(capacidadNinios);
		
		Element reservada = document.createElement(RESERVADA);
		reservada.appendChild(document.createTextNode(Boolean.toString(habitacion.getReservada())));
		nuevaHabitacion.appendChild(reservada);
		
		Element balcon = document.createElement(BALCON);
		balcon.appendChild(document.createTextNode(Boolean.toString(habitacion.getBalcon())));
		nuevaHabitacion.appendChild(balcon);
		
		Element vista = document.createElement(VISTA);
		vista.appendChild(document.createTextNode(Boolean.toString(habitacion.getVista())));
		nuevaHabitacion.appendChild(vista);
		
		Element cocina = document.createElement(COCINA);
		cocina.appendChild(document.createTextNode(Boolean.toString(habitacion.getCocina())));
		nuevaHabitacion.appendChild(cocina);
		
		Element tamaño = document.createElement(TAMANO);
		tamaño.appendChild(document.createTextNode(Integer.toString(habitacion.getTamaño())));
		nuevaHabitacion.appendChild(tamaño);
		
		Element aire = document.createElement(AIRE);
		aire.appendChild(document.createTextNode(Boolean.toString(habitacion.getAire())));
		nuevaHabitacion.appendChild(aire);
		
		Element calefaccion = document.createElement(CALEFACCION);
		calefaccion.appendChild(document.createTextNode(Boolean.toString(habitacion.getCalefaccion())));
		nuevaHabitacion.appendChild(calefaccion);
		
		Element tamañoCama = document.createElement(TAMANOCAMA);
		tamañoCama.appendChild(document.createTextNode(Integer.toString(habitacion.getTamañoCama())));
		nuevaHabitacion.appendChild(tamañoCama);
		
		Element tv = document.createElement(TV);
		tv.appendChild(document.createTextNode(Boolean.toString(habitacion.getTv())));
		nuevaHabitacion.appendChild(tv);
		
		Element cafetera = document.createElement(CAFETERA);
		cafetera.appendChild(document.createTextNode(Boolean.toString(habitacion.getCafetera())));
		nuevaHabitacion.appendChild(cafetera);
		
		Element ropaCama = document.createElement(ROPACAMA);
		ropaCama.appendChild(document.createTextNode(Boolean.toString(habitacion.getRopaCama())));
		nuevaHabitacion.appendChild(ropaCama);
		
		Element plancha = document.createElement(PLANCHA);
		plancha.appendChild(document.createTextNode(Boolean.toString(habitacion.getPlancha())));
		nuevaHabitacion.appendChild(plancha);
		
		Element secador = document.createElement(SECADOR);
		secador.appendChild(document.createTextNode(Boolean.toString(habitacion.getSecador())));
		nuevaHabitacion.appendChild(secador);
		
		Element voltaje = document.createElement(VOLTAJE);
		voltaje.appendChild(document.createTextNode(Boolean.toString(habitacion.getVoltaje())));
		nuevaHabitacion.appendChild(voltaje);
		
		Element tomasA = document.createElement(TOMASA);
		tomasA.appendChild(document.createTextNode(Boolean.toString(habitacion.getTomasA())));
		nuevaHabitacion.appendChild(tomasA);
		
		Element tomasC = document.createElement(TOMASC);
		tomasC.appendChild(document.createTextNode(Boolean.toString(habitacion.getTomasC())));
		nuevaHabitacion.appendChild(tomasC);
		
		Element desayuno = document.createElement(DESAYUNO);
		desayuno.appendChild(document.createTextNode(Boolean.toString(habitacion.getDesayuno())));
		nuevaHabitacion.appendChild(desayuno);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(XML_Habitaciones);
        try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Habitacion> obtenerHabitaciones() {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        
        NodeList nodosHabitaciones = document.getElementsByTagName(HABITACION);
        
        for (int i = 0; i < nodosHabitaciones.getLength(); i++) {
            Element elementoHabitacion = (Element) nodosHabitaciones.item(i);
            int id = Integer.parseInt(elementoHabitacion.getAttribute(ID));
            int tipo = Integer.parseInt(elementoHabitacion.getElementsByTagName(TIPO).item(0).getTextContent());
            int capacidadAdultos = Integer.parseInt(elementoHabitacion.getElementsByTagName(CAPACIDADADULTOS).item(0).getTextContent());
            int capacidadNinios = Integer.parseInt(elementoHabitacion.getElementsByTagName(CAPACIDADNINIOS).item(0).getTextContent());
            boolean reservada = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(RESERVADA).item(0).getTextContent());
            boolean balcon = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(BALCON).item(0).getTextContent());
            boolean vista = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(VISTA).item(0).getTextContent());
            boolean cocina = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(COCINA).item(0).getTextContent());
            int tamaño = Integer.parseInt(elementoHabitacion.getElementsByTagName(TAMANO).item(0).getTextContent());
            boolean aire = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(AIRE).item(0).getTextContent());
            boolean calefaccion = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(CALEFACCION).item(0).getTextContent());
            int tamañoCama = Integer.parseInt(elementoHabitacion.getElementsByTagName(TAMANOCAMA).item(0).getTextContent());
            boolean tv = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(TV).item(0).getTextContent());
            boolean cafetera = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(CAFETERA).item(0).getTextContent());
            boolean ropaCama = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(ROPACAMA).item(0).getTextContent());
            boolean plancha = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(PLANCHA).item(0).getTextContent());
            boolean secador = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(SECADOR).item(0).getTextContent());
            boolean voltaje = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(VOLTAJE).item(0).getTextContent());
            boolean tomasA = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(TOMASA).item(0).getTextContent());
            boolean tomasC = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(TOMASC).item(0).getTextContent());
            boolean desayuno = Boolean.parseBoolean(elementoHabitacion.getElementsByTagName(DESAYUNO).item(0).getTextContent());
            
            Habitacion habitacion = new Habitacion(id, tipo, capacidadAdultos, capacidadNinios, balcon, vista, cocina, tamaño, aire, calefaccion, tamañoCama, tv, cafetera, ropaCama, plancha, secador, voltaje, tomasA, tomasC, desayuno);
            habitacion.setReservada(reservada);
            habitaciones.add(habitacion);
        } 
        return habitaciones;
	}
	
}
