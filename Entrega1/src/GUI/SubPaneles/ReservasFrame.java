package GUI.SubPaneles;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

import GUI.ventanaEmpleado;
import modelo.Grupo;
import modelo.Habitacion;
import modelo.Huesped;
import modelo.Reserva;
import procesamiento.Hotel;



public class ReservasFrame extends JFrame  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private int intUsuarios=0;
	private int intHabitaciones=0;
	private ArrayList<Huesped> huespedes;
	private ArrayList<Habitacion> habitaciones;
	private Hotel hotel;

	private JLabel labelAgregadosUsuarioCount;


	private JTextField textFieldDia;
	private JTextField textFieldMes;
	private JTextField textFieldAnio;

	private JTextField textFieldDia2;
	private JTextField textFieldMes2;
	private JTextField textFieldAnio2;

	private JTextField textFieldNombreUsuario;
	private JTextField textFieldContraseña;
	private JTextField textFieldNombre;
	private JTextField textFieldDocumento;
	private JTextField textFieldEdad;
	private JTextField textFieldCorreo;
	private JTextField textFieldTelefono;

	private JTextField textFieldHabitacion;
	private JLabel labelAgregadosHabitacionCount;

	public ReservasFrame(Hotel hotel) {
		// Inicializamos los atributos
		this.hotel = hotel;
		this.huespedes = new ArrayList<Huesped>();
		this.habitaciones = new ArrayList<Habitacion>();

		// Configuracion del panel
		setVisible(true);
		setTitle("Reservas");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setBounds(100, 100, 700, 500);
		setLayout(new BorderLayout());

		// Creamos los componentes de panelCheckIn
		JLabel labelCheckIn = new JLabel("Check in");
		JLabel labelDia = new JLabel("Dia");
		JLabel labelMes = new JLabel("Mes");
		JLabel labelAnio = new JLabel("Año");
		textFieldDia = new JTextField();
		textFieldMes = new JTextField();
		textFieldAnio = new JTextField();
		JPanel panelCheckIn = new JPanel(new GridLayout(1, 7));

		// Creamos los componentes de panelCheckOut
		JLabel labelCheckIn2 = new JLabel("Check Out");
		JLabel labelDia2 = new JLabel("Dia");
		JLabel labelMes2= new JLabel("Mes");
		JLabel labelAnio2 = new JLabel("Año");
		textFieldDia2 = new JTextField();
		textFieldMes2 = new JTextField();
		textFieldAnio2 = new JTextField();
		JPanel panelCheckOut = new JPanel(new GridLayout(1, 7));

		// Se crea panelNorte
		JPanel panelNorte= new JPanel ();
		panelNorte.setLayout(new GridLayout(3,1));

		// Se crea panelAddUsuario
		JPanel panelAddUsuario = new JPanel();
		panelAddUsuario.setLayout(new GridLayout(8,2));

		// Se crean componentes del panel de usuario
		textFieldNombreUsuario = new JTextField();
		textFieldContraseña = new JTextField();
		textFieldNombre = new JTextField();
		textFieldDocumento = new JTextField();
		textFieldEdad = new JTextField();
		textFieldCorreo = new JTextField();
		textFieldTelefono = new JTextField();

		JButton botonAddUsuario = new JButton("Añadir usuario");
		botonAddUsuario.addActionListener(this);
		botonAddUsuario.setActionCommand("agregarUsuario");

		// Se crea panel Habitacion
		JPanel panelAddHabitacion = new JPanel(new FlowLayout());

		// Se crean componentes de panel Habitacion
		JLabel labelHabitacion = new JLabel("ID");

		textFieldHabitacion = new JTextField();
		textFieldHabitacion.setPreferredSize(new Dimension (100,25));

		JButton botonAddHabitacion = new JButton("Añadir habitación");
		botonAddHabitacion.addActionListener(this);
		botonAddHabitacion.setActionCommand("agregarHabitacion");

		// Se crea panel reservar
		JPanel panelReservar = new JPanel(new FlowLayout(FlowLayout.CENTER));

		// Se crean componentes del panel reservar
		JButton botonReservar = new JButton("Reservar");
		botonReservar.addActionListener(this);
		botonReservar.setActionCommand("reservar");

		JLabel labelReservaExitosa = new JLabel();

		// Creacion de panelCentro
		JPanel panelCentro= new JPanel();
		panelCentro.setLayout(new GridLayout(2,1));

		// Se crea el panelEste
		JPanel panelEste= new JPanel();
		panelEste.setLayout(new FlowLayout(FlowLayout.CENTER)); // new GridLayout(4,1)
		panelEste.setPreferredSize(new Dimension (200,200));

		// Creacion de componentes del panelEste
		JLabel labelAgregadosUsuario = new JLabel("Usuarios añadidos:");
		labelAgregadosUsuarioCount = new JLabel("0");
		JLabel labelAgregadosHabitacion = new JLabel("Habitaciones añadidas:");
		labelAgregadosHabitacionCount = new JLabel("0");

		// Agregacion de componentes a panelCheckIn
		panelCheckIn.add(labelCheckIn);
		panelCheckIn.add(labelDia);
		panelCheckIn.add(textFieldDia);
		panelCheckIn.add(labelMes);
		panelCheckIn.add(textFieldMes);
		panelCheckIn.add(labelAnio);
		panelCheckIn.add(textFieldAnio);

		// Agregacion de componentes a panelCheckOut
		panelCheckOut.add(labelCheckIn2);
		panelCheckOut.add(labelDia2);
		panelCheckOut.add(textFieldDia2);
		panelCheckOut.add(labelMes2);
		panelCheckOut.add(textFieldMes2);
		panelCheckOut.add(labelAnio2);
		panelCheckOut.add(textFieldAnio2);

		// Se agregan paneles de checkIn y checkOut al panel norte
		panelNorte.add(panelCheckIn);
		panelNorte.add(panelCheckOut);

		// Se agrega componentes al panel Habitacion
		panelAddHabitacion.add(labelHabitacion);
		panelAddHabitacion.add(textFieldHabitacion);
		panelAddHabitacion.add(botonAddHabitacion);

		// Se agregan componentes al panelReservar
		panelReservar.add(labelAgregadosUsuario);
		panelReservar.add(labelAgregadosUsuarioCount);
		panelReservar.add(labelAgregadosHabitacion);
		panelReservar.add(labelAgregadosHabitacionCount);
		panelReservar.add(botonReservar);
		panelReservar.add(labelReservaExitosa);

		// Se agregan componentes al panelCentro
		panelCentro.add(panelAddUsuario);
		panelCentro.add(panelAddHabitacion);

		// Se agregan los componentes de panel usuario
		panelAddUsuario.setLayout(new GridLayout(8,2));
		panelAddUsuario.add(new JLabel("Nombre Usuario"));
		panelAddUsuario.add(textFieldNombreUsuario);
		panelAddUsuario.add(new JLabel("Contraseña"));
		panelAddUsuario.add(textFieldContraseña);
		panelAddUsuario.add(new JLabel("Nombre"));
		panelAddUsuario.add(textFieldNombre);
		panelAddUsuario.add(new JLabel("Documento"));
		panelAddUsuario.add(textFieldDocumento);
		panelAddUsuario.add(new JLabel("Edad"));
		panelAddUsuario.add(textFieldEdad);
		panelAddUsuario.add(new JLabel("Correo"));
		panelAddUsuario.add(textFieldCorreo);
		panelAddUsuario.add(new JLabel("Teléfono"));
		panelAddUsuario.add(textFieldTelefono);
		panelAddUsuario.add(new JLabel("El primer huesped agregado es el responsable"));
		panelAddUsuario.add(botonAddUsuario);

		// Se agregan los paneles al Frame
		add(panelNorte, BorderLayout.NORTH);
		add(panelCentro, BorderLayout.CENTER);
		add(panelReservar, BorderLayout.SOUTH);

		// Evento de cierre
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new ventanaEmpleado(hotel);
				dispose();
			}
		});
	}

	private void agregarUsuario() {
		String nombreUsuario = textFieldNombreUsuario.getText();
		String contraseña = textFieldContraseña.getText();
		String nombre = textFieldNombre.getText();
		String documento = textFieldDocumento.getText();
		String correo = textFieldCorreo.getText();
		String telefono = textFieldTelefono.getText();

		if (!nombreUsuario.isEmpty() && !contraseña.isEmpty() && !nombre.isEmpty()
				&& !documento.isEmpty() && !correo.isEmpty() && !telefono.isEmpty()) {
			huespedes.add(new Huesped(nombreUsuario, contraseña, nombre, documento, intHabitaciones, correo, telefono));
			// Agrega 1 al contador
			int contadorUsuarios = Integer.parseInt(labelAgregadosUsuarioCount.getText()) + 1;
			labelAgregadosUsuarioCount.setText(Integer.toString(contadorUsuarios));
			
			// Limpia los campos
			textFieldNombreUsuario.setText("");
			textFieldContraseña.setText("");
			textFieldNombre.setText("");
			textFieldDocumento.setText("");
			textFieldCorreo.setText("");
			textFieldTelefono.setText("");
			textFieldEdad.setText("");

		} else {
			reservaDialog("Llene todos los campos del huesped");
		}
	}

	private void agregarHabitacion() {
		ArrayList<Habitacion> habs = hotel.getUsuarioActual().getinfo().getHabitaciones();
		int idNuevo = 0;
		
		try {
			idNuevo = Integer.parseInt(textFieldHabitacion.getText());
		}catch (Exception e) {
			reservaDialog("Error al intentar encontrar el ID");
		}
		
		for (Habitacion habitacion: habs) {
			if (habitacion.getId() == idNuevo) {
				// Si encuentra la habitacion
				habitaciones.add(habitacion);

				int contadorHabs = Integer.parseInt(labelAgregadosHabitacionCount.getText()) + 1;
				labelAgregadosHabitacionCount.setText(Integer.toString(contadorHabs));
				break;
			}
		}

	}

	private void crearReserva() {

		Huesped huespedR = huespedes.remove(0);
		LocalDate fechaI = LocalDate.parse(textFieldAnio.getText() + "-" + textFieldMes.getText() + "-" + textFieldDia.getText());
		LocalDate fechaF = LocalDate.parse(textFieldAnio2.getText() + "-" + textFieldMes2.getText() + "-" + textFieldDia2.getText());

		Grupo grupo = new Grupo(huespedes, huespedR, fechaI, fechaF);
		Reserva reserva = new Reserva(grupo, fechaI, fechaF);

		// Se agrega la reserva al los datos
		hotel.getUsuarioActual().getinfo().addReserva(reserva);

		// Se crea la ventana anterior
		new ventanaEmpleado(hotel);
		// Se crea el dialogo con el id de reserva 
		reservaDialog("Su ID de reserva es " + reserva.getId());
		// Cierra la ventana actual
		dispose();
	}

	private void reservaDialog(String texto) {
		// Creacion del dialogo
		JDialog dialogo = new JDialog();
		
		dialogo.setTitle("Reserva");
		dialogo.setBounds(100, 100, 250, 100);

		// Agregacion de componentes al dialog
		dialogo.add(new JLabel(texto));

		dialogo.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();

		if (accion.equals("agregarUsuario"))
			agregarUsuario();
		else if (accion.equals("agregarHabitacion"))
			agregarHabitacion();
		else if (accion.equals("reservar"))
			crearReserva();

	}




}
