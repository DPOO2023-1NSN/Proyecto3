package GUI.SubPaneles;

import javax.swing.*;

import Exceptions.FechasException;
import procesamiento.Hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PanelConsultarDisponibilidad extends JFrame implements ActionListener{
	private JTextField idTextField;
	private JTextField fechaInicioTextField;
	private JTextField fechaFinTextField;

	private Hotel hotel;

	public PanelConsultarDisponibilidad(Hotel hotel) {
		this.hotel = hotel;
		setTitle("Consultar Habitación");
		setPreferredSize(new Dimension(400, 200));

		// Crear los componentes
		JLabel idLabel = new JLabel("ID de la habitación:");
		idTextField = new JTextField(10);
		JLabel fechaInicioLabel = new JLabel("Fecha de inicio (YYYY-MM-DD):");
		fechaInicioTextField = new JTextField(10);
		JLabel fechaFinLabel = new JLabel("Fecha de fin (YYYY-MM-DD):");
		fechaFinTextField = new JTextField(10);

		JButton enviarButton = new JButton("Consultar");
		enviarButton.addActionListener(this);
		enviarButton.setActionCommand("consultar");

		// Configurar el diseño del frame
		setLayout(new GridLayout(4, 2));
		add(idLabel);
		add(idTextField);
		add(fechaInicioLabel);
		add(fechaInicioTextField);
		add(fechaFinLabel);
		add(fechaFinTextField);
		add(new JLabel()); // Espacio en blanco
		add(enviarButton);


		pack();
		setVisible(true);
	}


	private void crearDialog(String texto) {
		// Creacion del dialogo
		JDialog dialogo = new JDialog();

		dialogo.setTitle("Reserva");
		dialogo.setBounds(100, 100, 350, 100);

		// Agregacion de componentes al dialog
		dialogo.add(new JLabel(texto));

		dialogo.setVisible(true);

	}

	private void consultarHabitacion() throws FechasException {
		LocalDate fechaI;
		LocalDate fechaF;
		int id = 0;
		
		// Excepcion si las fechas estan en formato incorrecto
		try {
			fechaI = LocalDate.parse(fechaInicioTextField.getText());
			fechaF = LocalDate.parse(fechaFinTextField.getText());
		}catch (DateTimeParseException e) {
			throw new FechasException("Las fechas no estan en el formato correcto");
		}

		// Excepcion si el id no es un numero
		try {
			id = Integer.parseInt(idTextField.getText());
		}catch (Exception e) {
			crearDialog("Error al intentar encontrar el ID");
		}

		if (id != 0) {
			Boolean habitacionVacia = hotel.verificarHabitacionVacia(id, fechaI, fechaF);
			
			if(habitacionVacia)
				crearDialog("La habitacion se encuentra vacia para estas fechas");
			else
				crearDialog("La habitacion se encuentra llena para estas fechas");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("consultar")) {
			try {
				consultarHabitacion();
			} catch (FechasException e1) {
				crearDialog(e1.getMessage());
			}
		}

	}
}
