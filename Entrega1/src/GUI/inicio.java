package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import procesamiento.Hotel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class inicio extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel usuarioPanel;
	private JPanel botonesPanel;
	
	private JLabel tituloJLabel;
	private JTextField usuarioField;
	private JLabel usuarioJLabel;
	private JPasswordField contraseñaField;
	private JLabel contraseñaJLabel;
	private JButton ingresarJButton;
	private JButton crearJButton;
	private JLabel incJLabel;
	
	//Paneles secundarios que se desplegarán
	private JPanel  panelCrearUsuario;
	private ventanaUsuario vUsuario;
	//private ventanaAdministrador vAdmin;
	private ventanaEmpleado vEmpleado;
	
	//Creación del procesamiento
	private Hotel hotel;


	public static void main(String[] args) {
		
		new inicio();
		
	}

	
	public inicio(){
		try {
			hotel = new Hotel();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		panelCrearUsuario = new PanelCrearUsuario(hotel, this);
		
		
		// Configuracion JFrame
		setBounds(100, 100, 716, 526);
		setTitle("Sistema");
		setResizable(false);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creacion de componentes
		
		tituloJLabel = new JLabel("Bienvenidos");
		tituloJLabel.setFont(new Font("Stencil", Font.PLAIN, 18));
		tituloJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		usuarioJLabel = new JLabel("Usuario");
		usuarioJLabel.setPreferredSize(new Dimension(70,20));
		
		usuarioField = new JTextField();
		usuarioField.setPreferredSize(new Dimension(150,20));
		
		contraseñaJLabel = new JLabel("Contraseña");
		contraseñaJLabel.setPreferredSize(new Dimension(70,20));
		
		contraseñaField = new JPasswordField();
		contraseñaField.setPreferredSize(new Dimension(150,20));
		
		ingresarJButton = new JButton("Ingresar");
		ingresarJButton.addActionListener(this);
		ingresarJButton.setActionCommand("Ingresar");
		
		crearJButton = new JButton("Crear usuario");
		crearJButton.addActionListener(this);
		crearJButton.setActionCommand("Crear");
		
		incJLabel = new JLabel("El usuario no existe");
		incJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incJLabel.setVisible(false);
		
		// Creacion de paneles
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(4,1));
		contentPane.setBounds(200, 80, 300, 350);
		
		usuarioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
		usuarioPanel.add(usuarioJLabel);
		usuarioPanel.add(usuarioField);
		usuarioPanel.add(contraseñaJLabel);
		usuarioPanel.add(contraseñaField);
		
		botonesPanel = new JPanel();
		botonesPanel.add(ingresarJButton);
		botonesPanel.add(crearJButton);
		
		
		// Agrega componentes al JPanel
		contentPane.add(tituloJLabel);
		contentPane.add(usuarioPanel);
		contentPane.add(botonesPanel);
		contentPane.add(incJLabel);
		
		// Agrega componentes a la ventana
		add(contentPane);
		
		
		
	}
	
	public void volverLogin() {
		remove(panelCrearUsuario);
	    add(contentPane);
	    revalidate();
	    repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String accion = e.getActionCommand();
		
		if(accion.equals("Crear")) {
			remove(contentPane);
		    add(panelCrearUsuario);
		    revalidate();
		    repaint();
			
		}
		else {
			int tipoUsuario= hotel.ejecutarLogIn(usuarioField.getText(), contraseñaField.getText());
			if (tipoUsuario==0)
				incJLabel.setVisible(true);
			else if (tipoUsuario==1){
				new ventanaAdministrador(hotel);
			}
			else if (tipoUsuario==2){
				new ventanaEmpleado(hotel);
			}
			else {
				vUsuario.main(null);
			}
			
			
		}
		
	
		
	}


}
