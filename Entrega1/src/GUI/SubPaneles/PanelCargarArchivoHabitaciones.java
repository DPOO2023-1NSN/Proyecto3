package GUI.SubPaneles;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import GUI.ventanaAdministrador;
import GUI.ventanaEmpleado;
import procesamiento.Hotel;

public class PanelCargarArchivoHabitaciones extends JFrame {
	
	private Hotel hotel;
	
    public PanelCargarArchivoHabitaciones(Hotel hotel) {
    	this.hotel = hotel;
    	
    	setVisible(true);
        setTitle("PanelCargarArchivoHabitaciones");
        setSize(800, 200);
        setLocationRelativeTo(null);
        
        // Creamos los componentes
        JLabel labelRuta = new JLabel("Ingrese la ruta del archivo:");
        JTextField textFieldRuta = new JTextField();
        textFieldRuta.setPreferredSize(new Dimension (600,50));
        JButton botonCargar = new JButton("Cargar archivo");
        botonCargar.setPreferredSize(new Dimension (400,50));
        JLabel labelArchivoCargado = new JLabel();
        
        // Configuracion del layout de la ventana y del panel de la ruta
        setLayout(new BorderLayout());
        JPanel panelRuta = new JPanel();
        panelRuta.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelRuta.add(labelRuta);
        panelRuta.add(textFieldRuta);
        add(panelRuta, BorderLayout.NORTH);
        
    
        JPanel panelBoton= new JPanel();
        panelBoton.setLayout(new FlowLayout());
        panelBoton.add(botonCargar);
        add(panelBoton);
        add(labelArchivoCargado, BorderLayout.SOUTH);

        botonCargar.addActionListener(e -> {
            labelArchivoCargado.setText("Archivo de habitaciones cargado con éxito");
        });
        
     // Evento de cierre
     addWindowListener(new WindowAdapter() {
     @Override
     public void windowClosing(WindowEvent e) {
    	 new ventanaAdministrador(hotel);
    	 dispose();
     }
     });
    }

}
