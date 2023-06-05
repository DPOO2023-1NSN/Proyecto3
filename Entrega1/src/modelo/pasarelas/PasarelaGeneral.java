package modelo.pasarelas;

import javax.swing.JFrame;

public abstract class PasarelaGeneral {
   
    protected String rutaArchivo;
    protected int monto;
    protected int idReserva;
    /*Cada pasarela tiene su interfaz, esto hace más fácil la implementación de nuevas pasarelas
    ya que cada una puede requerir campos de texto distitntos*/
    protected JFrame interfaz;

    public PasarelaGeneral() {

    }
    
    public abstract void registrarTransaccion();
    //cada pasarela debería enviarse a si misma como parámetro para que la interfaz pueda llamar sus métodos según el botón
    public abstract void mostrarInterfaz();
    //para facilitar la implementación de nuevas pasarelas, cada una de ellas podrá cambiar a una de sus "hermanas"
    public abstract void cambiarPasarela(String nombrePasarela);
    public void setMonto(int monto) {this.monto= monto;}
    public int getMonto() {return this.monto;}
    public void setIdReserva(int idReserva) {this.idReserva=idReserva;}
    public int getIdReserva() {return this.idReserva;}
}