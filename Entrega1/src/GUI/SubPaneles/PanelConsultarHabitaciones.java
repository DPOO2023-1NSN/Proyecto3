package GUI.SubPaneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import GUI.ventanaAdministrador;
import GUI.ventanaEmpleado;
import modelo.Habitacion;
import procesamiento.Hotel;

public class PanelConsultarHabitaciones extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hotel hotel;
	private String panelActual;
	
	private JPanel panelSuperior;
	private JPanel panelIzq;
	private JPanel panelDerecha;
	private JPanel panelInferior;
	
	private JLabel lblTitle;
	private JTextField txtHab;
	private JButton btnConsultar;
	
	private JTextField txtId;
	private JTextField txtTipo;
	private JTextField txtCapA;
	private JTextField txtCapN;
	private JTextField txtBalcon;
	private JTextField txtVista;
	private JTextField txtCocina;
	
	public PanelConsultarHabitaciones(Hotel hotel, String panelActual) {
		this.hotel = hotel;
		this.panelActual = panelActual;
		
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
		
	}
	
	private void crearPanelSuperior() {
		panelSuperior = new JPanel();
		panelSuperior.setPreferredSize(new Dimension(900, 50));
		
		// Creacion componentes
		lblTitle = new JLabel("Colsultar habitacion: ");
		lblTitle.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblTitle.setPreferredSize(new Dimension(180,20));
		
		txtHab = new JTextField();
		txtHab.setPreferredSize(new Dimension(50,20));
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setPreferredSize(new Dimension(120,20));
		btnConsultar.addActionListener(this);
		btnConsultar.setActionCommand("consultar");
		
		// Agregacion de componentes
		panelSuperior.add(lblTitle);
		panelSuperior.add(txtHab);
		panelSuperior.add(btnConsultar);
		
		
	}
	
	private void crearPanelIzq() {
		panelIzq = new JPanel();
		panelIzq.setPreferredSize(new Dimension(450, 550));
		panelIzq.setLayout(new GridLayout(7,2,20,50));
		
		// Creacion de componentes
		JLabel lblId = new JLabel("Id: ");
		txtId = new JTextField();
		txtId.setEditable(false);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		
		JLabel lblCapA = new JLabel("Capacidad Adultos: ");
		txtCapA = new JTextField();
		txtCapA.setEditable(false);
		
		JLabel lblCapN = new JLabel("Capacidad niños: ");
		txtCapN = new JTextField();
		txtCapN.setEditable(false);
		
		JLabel lblBalcon = new JLabel("Balcon: ");
		txtBalcon = new JTextField();
		txtBalcon.setEditable(false);
		
		JLabel lblVista = new JLabel("Vista:");
		txtVista = new JTextField();
		txtVista.setEditable(false);
		
		JLabel lblCocina = new JLabel("Cocina: ");
		txtCocina = new JTextField();
		txtCocina.setEditable(false);
		
		//Agregacion de componentes
		panelIzq.add(lblId);
		panelIzq.add(txtId);
		panelIzq.add(lblTipo);
		panelIzq.add(txtTipo);
		panelIzq.add(lblCapA);
		panelIzq.add(txtCapA);
		panelIzq.add(lblCapN);
		panelIzq.add(txtCapN);
		panelIzq.add(lblBalcon);
		panelIzq.add(txtBalcon);
		panelIzq.add(lblVista);
		panelIzq.add(txtVista);
		panelIzq.add(lblCocina);
		panelIzq.add(txtCocina);
		
	}
	
	private void crearPanelDerecha() {
		panelDerecha = new JPanel();
		panelDerecha.setPreferredSize(new Dimension(450, 550));
		panelDerecha.setBorder(new TitledBorder("der"));
	}
	
	private void crearPanelInferior() {
		panelInferior = new JPanel();
		panelInferior.setPreferredSize(new Dimension(900, 100));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("volver");
		
		// Agregacion de componentes
		panelInferior.add(btnVolver);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		
		if (accion.equals("consultar")) {
			Habitacion hab = hotel.obtenerHabitacion(Integer.parseInt(txtHab.getText()));
			
			if (hab != null) {
				txtId.setText(Integer.toString(hab.getId()));
				if (hab.getTipo() == 0)
					txtTipo.setText("Estandar");
				else if (hab.getTipo() == 1)
					txtTipo.setText("Suit");
				else if (hab.getTipo() == 1)
					txtTipo.setText("Suit doble");
				txtCapA.setText(Integer.toString(hab.getCapacidadAdultos()));
				txtCapN.setText(Integer.toString(hab.getCapacidadNinios()));
				txtBalcon.setText(Boolean.toString(hab.getBalcon()));
				txtVista.setText(Boolean.toString(hab.getVista()));
				txtCocina.setText(Boolean.toString(hab.getCocina()));
			}
		}
		
		else if(accion.equals("volver")) {
			if (panelActual.equals("admin"))
				new ventanaAdministrador(hotel);
			else if (panelActual.equals("empleado"))
				new ventanaEmpleado(hotel);
			dispose();
		}
			
	}

}
