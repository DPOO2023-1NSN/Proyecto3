package modelo.pasarelas;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import GUI.SubPaneles.FramePayPal;
public class PayPal extends PasarelaGeneral{
	
    private String numeroTarjeta;
    private int mesCaducidad;
    private int anoCaducidad;
    private String nombreTitular;
    private int codigoSeguridad;
    private String rutaArchivo= ("data/Registros de cobro/Paypal.txt");
    private int numeroCuenta;
    private int numeroTransaccion;

	
	public void setAtributos(String numeroTarjeta, int mesCaducidad, int anoCaducidad, 
			String nombreTitular, int codigoSeguridad, int monto, 
			int numeroCuenta, int numeroTransaccion)  {
		this.anoCaducidad= anoCaducidad;
		this.codigoSeguridad=codigoSeguridad;
		this.mesCaducidad=mesCaducidad;
		this.nombreTitular=nombreTitular;
		this.numeroCuenta=numeroCuenta;
		this.numeroTarjeta=numeroTarjeta;
		this.numeroTransaccion= numeroTransaccion;
		
	}

	@Override
	public void mostrarInterfaz() {
		FramePayPal frame= new FramePayPal( this);
		
		
	}

	@Override
	public void cambiarPasarela(String nombrePasarela) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarTransaccion()  {
		PrintWriter writer;
		try {
			writer = new PrintWriter(rutaArchivo, "UTF-8");
			writer.println("---------------------------" );
			writer.println("Id de la reserva: "+ this.idReserva );
			writer.println("Nombre del titular: " + this.nombreTitular);
			writer.println("Número de cuenta: " + this.numeroCuenta);
			writer.println("Número de Tarjeta: " + this.numeroTarjeta);
			writer.println("Número de Transaccion: " + this.numeroTransaccion);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
