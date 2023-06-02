package GUI.SubPaneles;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import GUI.ventanaEmpleado;
import procesamiento.Hotel;



public class ReservasFrame extends JFrame {
    
	private static final long serialVersionUID = 1L;
	private int intUsuarios=0;
	private int intHabitaciones=0;
	private Hotel hotel;
	
	public ReservasFrame(Hotel hotel) {
		this.hotel = hotel;
		setVisible(true);
        setTitle("Reservas");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setBounds(100, 100, 700, 500);
        setLayout(new BorderLayout());
        // Creamos los componentes
        JLabel labelCheckIn = new JLabel("Check in");
        JLabel labelDia = new JLabel("Dia");
        JLabel labelMes = new JLabel("Mes");
        JLabel labelAnio = new JLabel("Año");
        JTextField textFieldDia = new JTextField();
        JTextField textFieldMes = new JTextField();
        JTextField textFieldAnio = new JTextField();
        JPanel panelCheckIn = new JPanel(new GridLayout(1, 7));
        panelCheckIn.add(labelCheckIn);
        panelCheckIn.add(labelDia);
        panelCheckIn.add(textFieldDia);
        panelCheckIn.add(labelMes);
        panelCheckIn.add(textFieldMes);
        panelCheckIn.add(labelAnio);
        panelCheckIn.add(textFieldAnio);
        
        JLabel labelCheckIn2 = new JLabel("Check Out");
        JLabel labelDia2 = new JLabel("Dia");
        JLabel labelMes2= new JLabel("Mes");
        JLabel labelAnio2 = new JLabel("Año");
        JTextField textFieldDia2 = new JTextField();
        JTextField textFieldMes2 = new JTextField();
        JTextField textFieldAnio2 = new JTextField();
        JPanel panelCheckIn2 = new JPanel(new GridLayout(1, 7));
        panelCheckIn2.add(labelCheckIn2);
        panelCheckIn2.add(labelDia2);
        panelCheckIn2.add(textFieldDia2);
        panelCheckIn2.add(labelMes2);
        panelCheckIn2.add(textFieldMes2);
        panelCheckIn2.add(labelAnio2);
        panelCheckIn2.add(textFieldAnio2);
      
        JPanel panelNorte= new JPanel ();
        panelNorte.setLayout(new GridLayout(3,1));
        panelNorte.add(panelCheckIn);
        panelNorte.add(panelCheckIn2);
        
        JPanel panelAddUsuario = new JPanel();
        panelAddUsuario.setLayout(new GridLayout(8,2));
        JButton botonAddUsuario = new JButton("Añadir usuario");
     
        panelAddUsuario.setLayout(new GridLayout(8,2));
        panelAddUsuario.add(new JLabel("Nombre Usuario"));
        panelAddUsuario.add(new JTextField());
        panelAddUsuario.add(new JLabel("Contraseña"));
        panelAddUsuario.add(new JTextField());
        panelAddUsuario.add(new JLabel("Nombre"));
        panelAddUsuario.add(new JTextField());
        panelAddUsuario.add(new JLabel("Documento"));
        panelAddUsuario.add(new JTextField());
        panelAddUsuario.add(new JLabel("Edad"));
        panelAddUsuario.add(new JTextField());
        panelAddUsuario.add(new JLabel("Correo"));
        panelAddUsuario.add(new JTextField());
        panelAddUsuario.add(new JLabel("Teléfono"));
        panelAddUsuario.add(new JTextField());
        panelAddUsuario.add(botonAddUsuario);
        
 
       
        JPanel panelAddHabitacion = new JPanel(new FlowLayout());
        JLabel labelHabitacion = new JLabel("ID");
        JTextField textFieldHabitacion = new JTextField();
        textFieldHabitacion.setPreferredSize(new Dimension (100,50));
        JButton botonAddHabitacion = new JButton("Añadir habitación");
        panelAddHabitacion.add(labelHabitacion);
        panelAddHabitacion.add(textFieldHabitacion);
        panelAddHabitacion.add(botonAddHabitacion);
      
        
        
        JPanel panelReservar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton botonReservar = new JButton("Reservar");
        JLabel labelReservaExitosa = new JLabel();
        panelReservar.add(botonReservar);
        panelReservar.add(labelReservaExitosa);
        botonReservar.addActionListener(e -> {
            labelReservaExitosa.setText("Reserva realizada con éxito");
        });
        
        JPanel panelCentro= new JPanel();
        panelCentro.setLayout(new GridLayout(2,1));
        panelCentro.add(panelAddUsuario);
        panelCentro.add(panelAddHabitacion);
        
        JPanel panelEste= new JPanel();
        panelEste.setLayout(new GridLayout(4,1));
        panelEste.setPreferredSize(new Dimension (200,200));
        JLabel labelAgregadosUsuario = new JLabel("Usuarios añadidos:");
        JLabel labelAgregadosUsuarioCount = new JLabel("0");
        JLabel labelAgregadosHabitacion = new JLabel("Habitaciones añadidas:");
        JLabel labelAgregadosHabitacionCount = new JLabel("0");
        panelEste.add(labelAgregadosUsuario);
        panelEste.add(labelAgregadosUsuarioCount);
        panelEste.add(labelAgregadosHabitacion);
        panelEste.add(labelAgregadosHabitacionCount);
        
        add(panelNorte, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
        add(panelReservar, BorderLayout.SOUTH);
        add(panelEste, BorderLayout.EAST);
        
        botonAddUsuario.addActionListener(e -> {
        	intUsuarios+=1;
        	labelAgregadosUsuarioCount.setText(intUsuarios + "");
        });
        
        botonAddHabitacion.addActionListener(e -> {
        	intHabitaciones+=1;
        	labelAgregadosHabitacionCount.setText(intHabitaciones + "");
        });
        
     // Evento de cierre
     		addWindowListener(new WindowAdapter() {
                 @Override
                 public void windowClosing(WindowEvent e) {
                 	new ventanaEmpleado(hotel);
         			dispose();
                 }
             });
}

	


}
