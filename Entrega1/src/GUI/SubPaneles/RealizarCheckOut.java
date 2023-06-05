package GUI.SubPaneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.*;
import GUI.ventanaAdministrador;
import GUI.ventanaEmpleado;

import procesamiento.Hotel;
import modelo.Reserva;
import modelo.pasarelas.*;


public class RealizarCheckOut extends JFrame {

	
	private Hotel hotel;
	
    public RealizarCheckOut(Hotel hotel) {
    	this.hotel = hotel;
        // Configuración del JFrame
        setTitle("Realizar Check Out");
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
        	try {
				ArrayList<String> listaPasarelas= hotel.getListaPasarelas();
				
				Class clase = Class.forName(listaPasarelas.get(0));
				// 2. Le pedimos a la clase un constructor sin parámetros y luego lo usamos
				// para crear una nueva instancia de la clase
				PasarelaGeneral pasarelaActual = (PasarelaGeneral) clase.getDeclaredConstructor(null).newInstance(null);
			
				
				ArrayList<Reserva> listaReservas= hotel.getInfo().getReservas();
				for (int i=0; i<listaReservas.size(); i++) {
					
					if (listaReservas.get(i).getId() == Integer.parseInt(idField.getText())) {
						pasarelaActual.setMonto(listaReservas.get(i).getPrecio());
						pasarelaActual.setIdReserva(Integer.parseInt(idField.getText()));
						pasarelaActual.registrarTransaccion();
						
						
						hotel.checkOut((Integer.parseInt(idField.getText())));
						
						anunciosLabel.setText("Check Out realizado con éxito");
					}
				}
				
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.print("no se cargaó la lista de pasarelas de pago");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        	//
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
