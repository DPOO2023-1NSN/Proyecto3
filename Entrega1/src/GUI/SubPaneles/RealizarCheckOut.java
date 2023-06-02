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

public class RealizarCheckOut extends JFrame {

	
	private Hotel hotel;
    public RealizarCheckOut(Hotel hotel) {
    	this.hotel = hotel;
        // Configuración del JFrame
        setTitle("Realizar Check In");
        setSize(400, 300);
        setVisible(true);

        
        // Creación del sub panel superior
        JPanel subPanel = new JPanel(new FlowLayout());
        JLabel idLabel = new JLabel("ID de la reserva:");
        JTextField idField = new JTextField(10);
        subPanel.add(idLabel);
        subPanel.add(idField);
        
        // Creación del botón para realizar el check in
        JPanel panelCentro= new JPanel(new FlowLayout());
        JButton checkInButton = new JButton("Realizar Check Out");
        
        checkInButton.setPreferredSize(new Dimension (199,50));
        panelCentro.add(checkInButton);
        
        
        // Creación del label para los anuncios
        JLabel anunciosLabel = new JLabel("    ");
        
        // Añadimos los componentes al JFrame con BorderLayout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(subPanel, BorderLayout.NORTH);
        getContentPane().add(panelCentro, BorderLayout.CENTER);
        getContentPane().add(anunciosLabel, BorderLayout.SOUTH);
        
        checkInButton.addActionListener(e -> {
        	anunciosLabel.setText("Check Out realizado con éxito");
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

