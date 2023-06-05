package modelo.pasarelas;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import GUI.SubPaneles.FramePayU;
import procesamiento.Hotel;
public class PayU extends PasarelaGeneral{
	
    private String numeroTarjeta;
    private int mesCaducidad;
    private int anoCaducidad;
    private String nombreTitular;
    private int codigoSeguridad;
    private String rutaArchivo= ("data/Registros de cobro/PayU.txt");
    private int numeroCuenta;
    private int numeroTransaccion;

    public PayU() {

    }
	
	public void setAtributos(String numeroTarjeta, int mesCaducidad, int anoCaducidad, 
			String nombreTitular, int codigoSeguridad,  
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
		
		FramePayU frame= new FramePayU( this);
		frame.setVisible(true);
		
	}



	@Override
	public void registrarTransaccion()  {
		PrintWriter writer;
		// Abre el archivo en modo de agregar
		FileWriter fw = null;
		try {
			fw = new FileWriter(rutaArchivo, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		// Crea un PrintWriter usando FileWriter
		writer = new PrintWriter(fw);
       
		
         
		writer.println("---------------------------" );
		writer.println("Id de la reserva: "+ this.idReserva );
		writer.println("Nombre del titular: " + this.nombreTitular);
		writer.println("Número de cuenta: " + this.numeroCuenta);
		writer.println("Número de Tarjeta: " + this.numeroTarjeta);
		writer.println("Número de Transaccion: " + this.numeroTransaccion);
		writer.println("Monto: " + this.monto);
		 // Cierra el PrintWriter y FileWriter
		writer.close();
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
