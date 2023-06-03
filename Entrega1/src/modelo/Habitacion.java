package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Habitacion {

	private int id;
	private int tipo;
	private int capacidadAdultos;
	private int capacidadNinios;
	private Boolean reservada;
	private Boolean balcon;
	private Boolean vista;
	private Boolean cocina;
	private int tamaño;
	private Boolean aire;
	private Boolean calefaccion;
	private int tamañoCama;
	private Boolean tv;
	private Boolean cafetera;
	private Boolean ropaCama;
	private Boolean plancha;
	private Boolean secador;
	private Boolean voltaje;
	private Boolean tomasA;
	private Boolean tomasC;
	private Boolean desayuno;
	

	public Habitacion(int id, int tipo, int capacidadAdultos, int capacidadNiños, Boolean balcon, Boolean vista, Boolean cocina, int tamaño, Boolean aire, Boolean calefaccion, int tamañoCama, Boolean tv, Boolean cafetera, Boolean ropaCama, Boolean plancha, Boolean secador, Boolean voltaje, Boolean tomasA, Boolean tomasC, Boolean desayuno) {
		this.id = id;
		this.tipo = tipo;
		this.capacidadAdultos = capacidadAdultos;
		this.capacidadNinios = capacidadNiños;
		this.reservada = false;
		this.balcon = balcon;
		this.vista = vista;
		this.cocina = cocina;
        this.tamaño = tamaño;
        this.aire = aire;
        this.calefaccion = calefaccion;
        this.tamañoCama = tamañoCama;
        this.tv = tv;
        this.cafetera = cafetera;
        this.ropaCama = ropaCama;
        this.plancha = plancha;
        this.secador = secador;
        this.voltaje = voltaje;
        this.tomasA = tomasA;
        this.tomasC = tomasC;
        this.desayuno = desayuno;
	}
	
	public int calcularBaseporNoche(Precio precios, LocalDate fecha) {
		int precioBase = 0;
		int precioAdicionales = 0;
		int precioCapacidad = precios.getPrecioAdulto()*this.capacidadAdultos + precios.getPrecioNinio()*this.capacidadNinios;

		
		if (this.tipo == 0) {
			precioBase = precios.getPreciosEstandar().get(fecha);
		}
		else if (this.tipo == 1) {
			precioBase = precios.getPreciosSuit().get(fecha);
		}
		else if (this.tipo == 2) {
			precioBase = precios.getPreciosSuitDoble().get(fecha);
		}
		
		if (this.balcon == true) {
			precioAdicionales = precioAdicionales + precios.getPrecioBalcon();
		}
		if (this.cocina == true) {
			precioAdicionales = precioAdicionales + precios.getPrecioCocina();
		}
		if (this.vista == true) {
			precioAdicionales = precioAdicionales + precios.getPrecioVista();
		}
		
		return precioBase + precioAdicionales + precioCapacidad;
	}

	public int getCapacidadAdultos() {
		return capacidadAdultos;
	}

	public int getCapacidadNinios() {
		return capacidadNinios;
	}

	public void setReservada(Boolean reservada) {
		this.reservada = reservada;
	}

	public int getId() {
		return id;
	}

	public int getTipo() {
		return tipo;
	}

	public Boolean getReservada() {
		return reservada;
	}

	public Boolean getBalcon() {
		return balcon;
	}

	public Boolean getVista() {
		return vista;
	}

	public Boolean getCocina() {
		return cocina;
	}

	public int getTamaño() {
		return tamaño;
	}

	public Boolean getAire() {
		return aire;
	}

	public Boolean getCalefaccion() {
		return calefaccion;
	}

	public int getTamañoCama() {
		return tamañoCama;
	}

	public Boolean getTv() {
		return tv;
	}

	public Boolean getCafetera() {
		return cafetera;
	}

	public Boolean getRopaCama() {
		return ropaCama;
	}

	public Boolean getPlancha() {
		return plancha;
	}

	public Boolean getSecador() {
		return secador;
	}

	public Boolean getVoltaje() {
		return voltaje;
	}

	public Boolean getTomasA() {
		return tomasA;
	}

	public Boolean getTomasC() {
		return tomasC;
	}

	public Boolean getDesayuno() {
		return desayuno;
	}
	
	
}



