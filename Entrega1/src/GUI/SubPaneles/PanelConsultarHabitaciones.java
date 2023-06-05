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
	private JTextField txtTamanio;
	private JTextField txtAire;
	private JTextField txtCalefaccion;
	private JTextField txtTamanioCama;
	private JTextField txtTv;
	private JTextField txtCafetera;
	private JTextField txtRopaCama;
	private JTextField txtPlancha;
	private JTextField txtSecador;
	private JTextField txtVoltaje;
	private JTextField txtTomasA;
	private JTextField txtTomasC;
	private JTextField txtDesayuno;
	
    private JTextField txtParqueaderoFree;
    private JTextField txtPiscina;
    private JTextField txtZonasHumedas;
    private JTextField txtBbq;
    private JTextField txtWifi;
    private JTextField txtRecepcion;
    private JTextField txtMascotas;
	
	
	
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
		panelIzq.setLayout(new GridLayout(27,2,20,1));
		
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

		JLabel lblTamano = new JLabel("Tamaño: ");
		txtTamanio = new JTextField();
		txtTamanio.setEditable(false);

		JLabel lblAire = new JLabel("Aire: ");
		txtAire = new JTextField();
		txtAire.setEditable(false);

		JLabel lblCalefaccion = new JLabel("Calefacción: ");
		txtCalefaccion = new JTextField();
		txtCalefaccion.setEditable(false);

		JLabel lblTamanoCama = new JLabel("Tamaño Cama: ");
		txtTamanioCama = new JTextField();
		txtTamanioCama.setEditable(false);

		JLabel lblTv = new JLabel("TV: ");
		txtTv = new JTextField();
		txtTv.setEditable(false);

		JLabel lblCafetera = new JLabel("Cafetera: ");
		txtCafetera = new JTextField();
		txtCafetera.setEditable(false);

		JLabel lblRopaCama = new JLabel("Ropa de Cama: ");
		txtRopaCama = new JTextField();
		txtRopaCama.setEditable(false);

		JLabel lblPlancha = new JLabel("Plancha: ");
		txtPlancha = new JTextField();
		txtPlancha.setEditable(false);

		JLabel lblSecador = new JLabel("Secador: ");
		txtSecador = new JTextField();
		txtSecador.setEditable(false);

		JLabel lblVoltaje = new JLabel("Voltaje: ");
		txtVoltaje = new JTextField();
		txtVoltaje.setEditable(false);

		JLabel lblTomasA = new JLabel("Tomas A: ");
		txtTomasA = new JTextField();
		txtTomasA.setEditable(false);

		JLabel lblTomasC = new JLabel("Tomas C: ");
		txtTomasC = new JTextField();
		txtTomasC.setEditable(false);

		JLabel lblDesayuno = new JLabel("Desayuno: ");
		txtDesayuno = new JTextField();
		txtDesayuno.setEditable(false);

		JLabel lblParqueaderoFree = new JLabel("Parqueadero Free: ");
		txtParqueaderoFree = new JTextField();
		txtParqueaderoFree.setEditable(false);

		JLabel lblPiscina = new JLabel("Piscina: ");
		txtPiscina = new JTextField();
		txtPiscina.setEditable(false);

		JLabel lblZonasHumedas = new JLabel("Zonas Húmedas: ");
		txtZonasHumedas = new JTextField();
		txtZonasHumedas.setEditable(false);

		JLabel lblBbq = new JLabel("BBQ: ");
		txtBbq = new JTextField();
		txtBbq.setEditable(false);

		JLabel lblWifi = new JLabel("WiFi: ");
		txtWifi = new JTextField();
		txtWifi.setEditable(false);

		JLabel lblRecepcion = new JLabel("Recepción: ");
		txtRecepcion = new JTextField();
		txtRecepcion.setEditable(false);

		JLabel lblMascotas = new JLabel("Mascotas: ");
		txtMascotas = new JTextField();
		txtMascotas.setEditable(false);
		
		// Agregacion de componentes
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
		panelIzq.add(lblTamano);
		panelIzq.add(txtTamanio);
		panelIzq.add(lblAire);
		panelIzq.add(txtAire);
		panelIzq.add(lblCalefaccion);
		panelIzq.add(txtCalefaccion);
		panelIzq.add(lblTamanoCama);
		panelIzq.add(txtTamanioCama);
		panelIzq.add(lblTv);
		panelIzq.add(txtTv);
		panelIzq.add(lblCafetera);
		panelIzq.add(txtCafetera);
		panelIzq.add(lblRopaCama);
		panelIzq.add(txtRopaCama);
		panelIzq.add(lblPlancha);
		panelIzq.add(txtPlancha);
		panelIzq.add(lblSecador);
		panelIzq.add(txtSecador);
		panelIzq.add(lblVoltaje);
		panelIzq.add(txtVoltaje);
		panelIzq.add(lblTomasA);
		panelIzq.add(txtTomasA);
		panelIzq.add(lblTomasC);
		panelIzq.add(txtTomasC);
		panelIzq.add(lblDesayuno);
		panelIzq.add(txtDesayuno);
		panelIzq.add(lblParqueaderoFree);
		panelIzq.add(txtParqueaderoFree);
		panelIzq.add(lblPiscina);
		panelIzq.add(txtPiscina);
		panelIzq.add(lblZonasHumedas);
		panelIzq.add(txtZonasHumedas);
		panelIzq.add(lblBbq);
		panelIzq.add(txtBbq);
		panelIzq.add(lblWifi);
		panelIzq.add(txtWifi);
		panelIzq.add(lblRecepcion);
		panelIzq.add(txtRecepcion);
		panelIzq.add(lblMascotas);
		panelIzq.add(txtMascotas);
		

		
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
	
	public String obtenerTextoInclusion(boolean valor) {
	    if (valor) {
	        return "Si incluye";
	    } else {
	        return "No incluye";
	    }
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
				
				//Proiedades de la habitacion
				txtCapA.setText(Integer.toString(hab.getCapacidadAdultos()));
				txtCapN.setText(Integer.toString(hab.getCapacidadNinios()));
				txtBalcon.setText(obtenerTextoInclusion(hab.getBalcon()));
				txtVista.setText(obtenerTextoInclusion(hab.getVista()));
				txtCocina.setText(obtenerTextoInclusion(hab.getCocina()));
				txtTamanio.setText(Integer.toString(hab.getTamaño()));
				txtAire.setText(obtenerTextoInclusion(hab.getAire()));
				txtCalefaccion.setText(obtenerTextoInclusion(hab.getCalefaccion()));
				txtTamanioCama.setText(Integer.toString(hab.getTamañoCama()));
				txtTv.setText(obtenerTextoInclusion(hab.getTv()));
				txtCafetera.setText(obtenerTextoInclusion(hab.getCafetera()));
				txtRopaCama.setText(obtenerTextoInclusion(hab.getRopaCama()));
				txtPlancha.setText(obtenerTextoInclusion(hab.getPlancha()));
				txtSecador.setText(obtenerTextoInclusion(hab.getSecador()));

				txtVoltaje.setText(obtenerTextoInclusion(hab.getVoltaje()));
				txtTomasA.setText(obtenerTextoInclusion(hab.getTomasA()));
				txtTomasC.setText(obtenerTextoInclusion(hab.getTomasC()));
				txtDesayuno.setText(obtenerTextoInclusion(hab.getDesayuno()));

				// Asignación de valores del hotel
				txtParqueaderoFree.setText(obtenerTextoInclusion(hotel.getParqueaderoFree()));
				txtPiscina.setText(obtenerTextoInclusion(hotel.getPiscina()));
				txtZonasHumedas.setText(obtenerTextoInclusion(hotel.getZonasHumedas()));
				txtBbq.setText(obtenerTextoInclusion(hotel.getBbq()));
				txtWifi.setText(obtenerTextoInclusion(hotel.getWifi()));
				txtRecepcion.setText(obtenerTextoInclusion(hotel.getRecepcion()));
				txtMascotas.setText(obtenerTextoInclusion(hotel.getMascotas()));
				
				
				
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
