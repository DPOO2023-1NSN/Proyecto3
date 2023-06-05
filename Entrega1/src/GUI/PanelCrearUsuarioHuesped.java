package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import procesamiento.Hotel;

public class PanelCrearUsuarioHuesped extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private Hotel hotel;
	private GUI.inicio inicio;

	private JPanel panelSuperior;
	private JPanel panelInferior;
	
	private JLabel lblTitle;
	private JButton btnConfirmacion;
	
	private JLabel lblNombreDeUsuario;
	private JLabel lblContraseña;
	private JLabel lblNombre;
	private JLabel lblDocumento;
	private JLabel lblCorreoElectrnico;
	private JLabel lblTelfono;
	private JLabel lblEdad;
	private JLabel lblConfirmacion;
	
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JTextField txtNombre;
	private JTextField txtDocumento;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtEdad;
	


	public PanelCrearUsuarioHuesped(Hotel hotel, GUI.inicio inicio) {
		this.hotel = hotel;
		this.inicio = inicio;
		
		// Configuracion panel
		setLayout(new BorderLayout());
		setBounds(60, 10, 600, 480);
		
		// Creacion de paneles hijos
		crearPanelSuperior();
		add(panelSuperior, BorderLayout.NORTH);
		
		
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
	

	
	private void crearPanelInferior() {
		// Configuracion panel
		panelInferior = new JPanel();
		panelInferior.setPreferredSize(new Dimension(600,340));
		panelInferior.setLayout(new GridLayout(8,2,10,10));
		
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
		
		
		//Agregacion de componentes
		panelInferior.add(lblNombreDeUsuario);
		panelInferior.add(txtUsuario);
		panelInferior.add(lblContraseña);
		panelInferior.add(txtContraseña);
		panelInferior.add(lblNombre);
		panelInferior.add(txtNombre);
		panelInferior.add(lblDocumento);
		panelInferior.add(txtDocumento);
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
		
		
		if(accion.equals("crear")) {
			hotel.registrarHuesped(txtUsuario.getText(), txtContraseña.getText(), txtNombre.getText(), txtDocumento.getText(), Integer.parseInt(txtEdad.getText()), txtCorreo.getText(), txtTelefono.getText());
			}
			inicio.volverLogin(2);
		}
		
	}

