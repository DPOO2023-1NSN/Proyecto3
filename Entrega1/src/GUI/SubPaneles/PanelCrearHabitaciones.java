package GUI.SubPaneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import GUI.ventanaAdministrador;
import GUI.ventanaEmpleado;
import modelo.Habitacion;
import procesamiento.Hotel;

public class PanelCrearHabitaciones extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hotel hotel;
	
	private JPanel panelSuperior;
	private JPanel panelIzq;
	private JPanel panelDerecha;
	private JPanel panelInferior;
	
	private JLabel lblTitle;
	
	private JTextField txtId;
	private JTextField txtCapA;
	private JTextField txtCapN;
	private JTextField txtTamanio;
	private JTextField txtTamanioCama;

	private JComboBox<String> comboBoxBalcon;
	private JComboBox<String> comboBoxTipo;
	private JComboBox<String> comboBoxVista;
	private JComboBox<String> comboBoxCocina;
	private JComboBox<String> comboBoxAire;
	private JComboBox<String> comboBoxCalefaccion;
	private JComboBox<String> comboBoxTv;
	private JComboBox<String> comboBoxCafetera;
	private JComboBox<String> comboBoxRopaCama;
	private JComboBox<String> comboBoxPlancha;
	private JComboBox<String> comboBoxSecador;
	private JComboBox<String> comboBoxVoltaje;
	private JComboBox<String> comboBoxTomasA;
	private JComboBox<String> comboBoxTomasC;
	private JComboBox<String> comboBoxDesayuno;

	
	
	
	public PanelCrearHabitaciones(Hotel hotel) {
		this.hotel = hotel;
		
		// Configuracion del panel
		setBounds(100, 100, 956, 705);
		setLayout(new BorderLayout());
		setVisible(true);
		
		// Creacion de componentes
		crearPanelSuperior();
		add(panelSuperior, BorderLayout.NORTH);
		
		crearPanelIzq();
		add(panelIzq, BorderLayout.CENTER);
		
		crearPanelDerecha();
		//add(panelDerecha, BorderLayout.EAST);
		
		crearPanelInferior();
		add(panelInferior, BorderLayout.SOUTH);
		
		// Evento de cierre
	     addWindowListener(new WindowAdapter() {
	     @Override
	     public void windowClosing(WindowEvent e) {
	    	 new ventanaAdministrador(hotel);
	    	 dispose();
	     }
	     });
		
	}
	
	private void crearPanelSuperior() {
		panelSuperior = new JPanel();
		panelSuperior.setPreferredSize(new Dimension(900, 50));
		
		// Creacion componentes
		lblTitle = new JLabel("Crear habitacion");
		lblTitle.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblTitle.setPreferredSize(new Dimension(180,20));
		
		// Agregacion de componentes
		panelSuperior.add(lblTitle);
		
		
	}
	
	private void crearPanelIzq() {
		panelIzq = new JPanel();
		panelIzq.setPreferredSize(new Dimension(450, 550));
		panelIzq.setLayout(new GridLayout(20,2,20,1));
		
		// Creacion de componentes
		JLabel lblId = new JLabel("Id: ");
		txtId = new JTextField();

		JLabel lblTipo = new JLabel("Tipo: ");
		comboBoxTipo = new JComboBox<>();
		comboBoxTipo.addItem("Estandar");
		comboBoxTipo.addItem("Suit");
		comboBoxTipo.addItem("Suit doble");

		JLabel lblCapA = new JLabel("Capacidad Adultos: ");
		txtCapA = new JTextField();

		JLabel lblCapN = new JLabel("Capacidad niños: ");
		txtCapN = new JTextField();

		JLabel lblBalcon = new JLabel("Balcon: ");
		comboBoxBalcon = new JComboBox<>();
		comboBoxBalcon.addItem("Incluye");
		comboBoxBalcon.addItem("No incluye");

		JLabel lblVista = new JLabel("Vista:");
		comboBoxVista = new JComboBox<>();
		comboBoxVista.addItem("Incluye");
		comboBoxVista.addItem("No incluye");

		JLabel lblCocina = new JLabel("Cocina: ");
		comboBoxCocina = new JComboBox<>();
		comboBoxCocina.addItem("Incluye");
		comboBoxCocina.addItem("No incluye");

		JLabel lblTamano = new JLabel("Tamaño: ");
		txtTamanio = new JTextField();

		JLabel lblAire = new JLabel("Aire: ");
		comboBoxAire = new JComboBox<>();
		comboBoxAire.addItem("Incluye");
		comboBoxAire.addItem("No incluye");

		JLabel lblCalefaccion = new JLabel("Calefacción: ");
		comboBoxCalefaccion = new JComboBox<>();
		comboBoxCalefaccion.addItem("Incluye");
		comboBoxCalefaccion.addItem("No incluye");

		JLabel lblTamanoCama = new JLabel("Tamaño Cama: ");
		txtTamanioCama = new JTextField();

		JLabel lblTv = new JLabel("TV: ");
		comboBoxTv = new JComboBox<>();
		comboBoxTv.addItem("Incluye");
		comboBoxTv.addItem("No incluye");

		JLabel lblCafetera = new JLabel("Cafetera: ");
		comboBoxCafetera = new JComboBox<>();
		comboBoxCafetera.addItem("Incluye");
		comboBoxCafetera.addItem("No incluye");

		JLabel lblRopaCama = new JLabel("Ropa de Cama: ");
		comboBoxRopaCama = new JComboBox<>();
		comboBoxRopaCama.addItem("Incluye");
		comboBoxRopaCama.addItem("No incluye");

		JLabel lblPlancha = new JLabel("Plancha: ");
		comboBoxPlancha = new JComboBox<>();
		comboBoxPlancha.addItem("Incluye");
		comboBoxPlancha.addItem("No incluye");

		JLabel lblSecador = new JLabel("Secador: ");
		comboBoxSecador = new JComboBox<>();
		comboBoxSecador.addItem("Incluye");
		comboBoxSecador.addItem("No incluye");

		JLabel lblVoltaje = new JLabel("Voltaje: ");
		comboBoxVoltaje = new JComboBox<>();
		comboBoxVoltaje.addItem("Incluye");
		comboBoxVoltaje.addItem("No incluye");

		JLabel lblTomasA = new JLabel("Tomas A: ");
		comboBoxTomasA = new JComboBox<>();
		comboBoxTomasA.addItem("Incluye");
		comboBoxTomasA.addItem("No incluye");

		JLabel lblTomasC = new JLabel("Tomas C: ");
		comboBoxTomasC = new JComboBox<>();
		comboBoxTomasC.addItem("Incluye");
		comboBoxTomasC.addItem("No incluye");

		JLabel lblDesayuno = new JLabel("Desayuno: ");
		comboBoxDesayuno = new JComboBox<>();
		comboBoxDesayuno.addItem("Incluye");
		comboBoxDesayuno.addItem("No incluye");

		
		// Agregacion de componentes
		panelIzq.add(lblId);
		panelIzq.add(txtId);
		panelIzq.add(lblTipo);
		panelIzq.add(comboBoxTipo);
		panelIzq.add(lblCapA);
		panelIzq.add(txtCapA);
		panelIzq.add(lblCapN);
		panelIzq.add(txtCapN);
		panelIzq.add(lblBalcon);
		panelIzq.add(comboBoxBalcon);
		panelIzq.add(lblVista);
		panelIzq.add(comboBoxVista);
		panelIzq.add(lblCocina);
		panelIzq.add(comboBoxCocina);
		panelIzq.add(lblTamano);
		panelIzq.add(txtTamanio);
		panelIzq.add(lblAire);
		panelIzq.add(comboBoxAire);
		panelIzq.add(lblCalefaccion);
		panelIzq.add(comboBoxCalefaccion);
		panelIzq.add(lblTamanoCama);
		panelIzq.add(txtTamanioCama);
		panelIzq.add(lblTv);
		panelIzq.add(comboBoxTv);
		panelIzq.add(lblCafetera);
		panelIzq.add(comboBoxCafetera);
		panelIzq.add(lblRopaCama);
		panelIzq.add(comboBoxRopaCama);
		panelIzq.add(lblPlancha);
		panelIzq.add(comboBoxPlancha);
		panelIzq.add(lblSecador);
		panelIzq.add(comboBoxSecador);
		panelIzq.add(lblVoltaje);
		panelIzq.add(comboBoxVoltaje);
		panelIzq.add(lblTomasA);
		panelIzq.add(comboBoxTomasA);
		panelIzq.add(lblTomasC);
		panelIzq.add(comboBoxTomasC);
		panelIzq.add(lblDesayuno);
		panelIzq.add(comboBoxDesayuno);
		

		
	}
	
	private void crearPanelDerecha() {
		panelDerecha = new JPanel();
		panelDerecha.setPreferredSize(new Dimension(450, 550));
		panelDerecha.setBorder(new TitledBorder("der"));
	}
	
	private void crearPanelInferior() {
		panelInferior = new JPanel();
		panelInferior.setPreferredSize(new Dimension(900, 100));
		
		JButton btnVolver = new JButton("Crear");
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("crear");
		
		// Agregacion de componentes
		panelInferior.add(btnVolver);
	}
	
	private void crearHabitacion() {
	    int id = Integer.parseInt(txtId.getText());
	    int tipo = comboBoxTipo.getSelectedIndex();
	    int capacidadAdultos = Integer.parseInt(txtCapA.getText());
	    int capacidadNinios = Integer.parseInt(txtCapN.getText());
	    boolean balcon = comboBoxBalcon.getSelectedIndex() == 0;
	    boolean vista = comboBoxVista.getSelectedIndex() == 0;
	    boolean cocina = comboBoxCocina.getSelectedIndex() == 0;
	    int tamaño = Integer.parseInt(txtTamanio.getText());
	    boolean aire = comboBoxAire.getSelectedIndex() == 0;
	    boolean calefaccion = comboBoxCalefaccion.getSelectedIndex() == 0;
	    int tamañoCama = Integer.parseInt(txtTamanioCama.getText());
	    boolean tv = comboBoxTv.getSelectedIndex() == 0;
	    boolean cafetera = comboBoxCafetera.getSelectedIndex() == 0;
	    boolean ropaCama = comboBoxRopaCama.getSelectedIndex() == 0;
	    boolean plancha = comboBoxPlancha.getSelectedIndex() == 0;
	    boolean secador = comboBoxSecador.getSelectedIndex() == 0;
	    boolean voltaje = comboBoxVoltaje.getSelectedIndex() == 0;
	    boolean tomasA = comboBoxTomasA.getSelectedIndex() == 0;
	    boolean tomasC = comboBoxTomasC.getSelectedIndex() == 0;
	    boolean desayuno = comboBoxDesayuno.getSelectedIndex() == 0;
	    
	    hotel.getUsuarioActual().getinfo().addHabitacion(new Habitacion(id, tipo, capacidadAdultos, capacidadNinios, balcon, vista, cocina, tamaño, aire, calefaccion, tamañoCama, tv, cafetera, ropaCama, plancha, secador, voltaje, tomasA, tomasC, desayuno));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		
		if (accion.equals("crear")) {
			crearHabitacion();
			new ventanaAdministrador(hotel);
			dispose();
		}
		
		else if(accion.equals("volver")) {
			new ventanaAdministrador(hotel);
			dispose();
		}
			
	}

}
