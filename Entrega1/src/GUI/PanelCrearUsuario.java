package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import procesamiento.Hotel;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class PanelCrearUsuario extends JPanel implements ActionListener{


	private static final long serialVersionUID = 1L;
	
	private String opcSeleccionada = "huesped";
	private Hotel hotel;
	private GUI.inicio inicio;

	private JPanel panelSuperior;
	private JPanel panelMitad;
	private JPanel panelInferior;
	
	private JLabel lblTitle;
	private JLabel lblQueTipoDe;
	private JButton btnAdmin;
	private JButton btnEmpleado;
	private JButton btnHuesped;
	private JButton btnConfirmacion;
	
	private JLabel lblNombreDeUsuario;
	private JLabel lblContraseña;
	private JLabel lblNombre;
	private JLabel lblDocumento;
	private JLabel lblServicioEncargado;
	private JLabel lblCorreoElectrnico;
	private JLabel lblTelfono;
	private JLabel lblEdad;
	private JLabel lblConfirmacion;
	
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JTextField txtNombre;
	private JTextField txtDocumento;
	private JTextField txtServicio;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtEdad;
	


	public PanelCrearUsuario(Hotel hotel, GUI.inicio inicio) {
		this.hotel = hotel;
		this.inicio = inicio;
		
		// Configuracion panel
		setLayout(new BorderLayout());
		setBounds(60, 10, 600, 480);
		
		// Creacion de paneles hijos
		crearPanelSuperior();
		add(panelSuperior, BorderLayout.NORTH);
		
		crearPanelMitad();
		add(panelMitad, BorderLayout.CENTER);
		
		crearPanelInferior();
		add(panelInferior, BorderLayout.SOUTH);
		
		
		
	}
	
	private void crearPanelSuperior() {
		// Configuracion panel
		panelSuperior = new JPanel();
		panelSuperior.setPreferredSize(new Dimension(700,60));
		
		// Creacion de componentes
		lblTitle = new JLabel("Crear usuario ");
		lblTitle.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		//Agregacion de componentes
		panelSuperior.add(lblTitle);
	}
	
	private void crearPanelMitad() {
		// Configuracion panel
		panelMitad = new JPanel();
		panelMitad.setPreferredSize(new Dimension(600,20));
		
		// Creacion de componentes
		lblQueTipoDe = new JLabel("Que tipo de usuario desea crear?");
		lblQueTipoDe.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		btnAdmin = new JButton("Administrador");
		btnAdmin.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		btnAdmin.addActionListener(this);
		btnAdmin.setActionCommand("admin");

		btnEmpleado = new JButton("Empleado");
		btnEmpleado.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		btnEmpleado.addActionListener(this);
		btnEmpleado.setActionCommand("empleado");
		
		btnHuesped = new JButton("Huesped");
		btnHuesped.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		btnHuesped.addActionListener(this);
		btnHuesped.setActionCommand("huesped");
		
		//Agregacion de componentes
		panelMitad.add(lblQueTipoDe);
		panelMitad.add(btnAdmin);
		panelMitad.add(btnEmpleado);
		panelMitad.add(btnHuesped);
	}
	
	private void crearPanelInferior() {
		// Configuracion panel
		panelInferior = new JPanel();
		panelInferior.setPreferredSize(new Dimension(600,340));
		panelInferior.setLayout(new GridLayout(9,2,10,10));
		
		// Creacion de componentes
		lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		txtUsuario = new JTextField();
		
		lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		txtContraseña = new JTextField();
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		txtNombre = new JTextField();
		
		lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		txtDocumento = new JTextField();
		
		lblServicioEncargado = new JLabel("Servicio encargado:");
		lblServicioEncargado.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		txtServicio = new JTextField();
		
		lblCorreoElectrnico = new JLabel("Correo electrónico:");
		lblCorreoElectrnico.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		txtCorreo = new JTextField();
		
		lblTelfono = new JLabel("teléfono:");
		lblTelfono.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		txtTelefono = new JTextField();
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		txtEdad = new JTextField();
		
		lblConfirmacion = new JLabel("");
		lblConfirmacion.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		btnConfirmacion = new JButton("Crear");
		btnConfirmacion.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		btnConfirmacion.addActionListener(this);
		btnConfirmacion.setActionCommand("crear");
		
		//Bloquea las casillas de texto
		txtUsuario.setEditable(false);
		txtContraseña.setEditable(false);
		txtNombre.setEditable(false);
		txtDocumento.setEditable(false);
		txtServicio.setEditable(false);
		txtCorreo.setEditable(false);
		txtTelefono.setEditable(false);
		txtEdad.setEditable(false);
		btnConfirmacion.setEnabled(false);
		
		//Agregacion de componentes
		panelInferior.add(lblNombreDeUsuario);
		panelInferior.add(txtUsuario);
		panelInferior.add(lblContraseña);
		panelInferior.add(txtContraseña);
		panelInferior.add(lblNombre);
		panelInferior.add(txtNombre);
		panelInferior.add(lblDocumento);
		panelInferior.add(txtDocumento);
		panelInferior.add(lblServicioEncargado);
		panelInferior.add(txtServicio);
		panelInferior.add(lblCorreoElectrnico);
		panelInferior.add(txtCorreo);
		panelInferior.add(lblTelfono);
		panelInferior.add(txtTelefono);
		panelInferior.add(lblEdad);
		panelInferior.add(txtEdad);
		panelInferior.add(lblConfirmacion);
		panelInferior.add(btnConfirmacion);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		
		if(accion.equals("admin")) {
			lblConfirmacion.setText("¿Desea crear un administrador?");
			opcSeleccionada = accion;
			//Bloquea las casillas de texto
			txtUsuario.setEditable(true);
			txtContraseña.setEditable(true);
			txtNombre.setEditable(true);
			txtDocumento.setEditable(true);
			txtServicio.setEditable(false);
			txtCorreo.setEditable(false);
			txtTelefono.setEditable(false);
			txtEdad.setEditable(false);
			btnConfirmacion.setEnabled(true);
		}
		else if(accion.equals("empleado")) {
			lblConfirmacion.setText("¿Desea crear un empleado?");
			opcSeleccionada = accion;
			//Bloquea y desbloquea las casillas de texto
			txtUsuario.setEditable(true);
			txtContraseña.setEditable(true);
			txtNombre.setEditable(true);
			txtDocumento.setEditable(true);
			txtServicio.setEditable(true);
			txtCorreo.setEditable(false);
			txtTelefono.setEditable(false);
			txtEdad.setEditable(false);
			btnConfirmacion.setEnabled(true);
		}
		else if(accion.equals("huesped")) {
			lblConfirmacion.setText("¿Desea crear un huesped?");
			opcSeleccionada = accion;
			//Bloquea y desbloquea las casillas de texto
			txtUsuario.setEditable(true);
			txtContraseña.setEditable(true);
			txtNombre.setEditable(true);
			txtDocumento.setEditable(true);
			txtServicio.setEditable(true);
			txtCorreo.setEditable(true);
			txtTelefono.setEditable(true);
			txtEdad.setEditable(true);
			btnConfirmacion.setEnabled(true);
		}
		
		else if(accion.equals("crear")) {
			if(opcSeleccionada.equals("admin")) {
				hotel.registrarAdmin(txtUsuario.getText(), txtContraseña.getText(), txtNombre.getText(), txtDocumento.getText());
			}
			else if(opcSeleccionada.equals("empleado")) {
				hotel.registrarEmpleado(txtUsuario.getText(), txtContraseña.getText(), txtNombre.getText(), txtDocumento.getText(), txtServicio.getText());
			}
			else if(opcSeleccionada.equals("huesped")) {
				hotel.registrarHuesped(txtUsuario.getText(), txtContraseña.getText(), txtNombre.getText(), txtDocumento.getText(), Integer.parseInt(txtEdad.getText()), txtCorreo.getText(), txtTelefono.getText());
			}
			inicio.volverLogin();
		}
		
	}
}
