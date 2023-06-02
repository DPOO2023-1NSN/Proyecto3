package GUI.SubPaneles;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import GUI.ventanaEmpleado;
import procesamiento.Hotel;

public class PanelRegistrarCobros extends JFrame implements ActionListener{
	private Hotel hotel;
	private JPanel panelPrincipal;
	private JLabel lblTitle;
	private JLabel lblId;
	private JLabel lblServicioId;
	
	private JTextArea txtId;
	private JTextArea txtServicioId;
	
	private JButton btbAgregar;

	
	public PanelRegistrarCobros(Hotel hotel) {
		this.hotel = hotel;
		
		// Configuracion frame
		setVisible(true);
		setBounds(200, 200, 400, 200);
		setResizable(false);
				
		//Creacion de componentes
		panelPrincipal = new JPanel();
		setPreferredSize(new Dimension(400,200));
				
		lblTitle = new JLabel("Registrar cobro");
		lblTitle.setPreferredSize(new Dimension(370,40));
		lblTitle.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
				
		lblId = new JLabel("ID de reserva");
		lblId.setPreferredSize(new Dimension(120,20));
				
		txtId = new JTextArea();
		txtId.setPreferredSize(new Dimension(230,20));
		
		lblServicioId = new JLabel("ID del servicio");
		lblServicioId.setPreferredSize(new Dimension(120,20));
				
		txtServicioId = new JTextArea();
		txtServicioId.setPreferredSize(new Dimension(230,20));
				
		btbAgregar = new JButton("Agregar");
		btbAgregar.addActionListener(this);
		btbAgregar.setActionCommand("agregar");
				
		// Agregacion componentes
		panelPrincipal.add(lblTitle);
		panelPrincipal.add(lblId);
		panelPrincipal.add(txtId);
		panelPrincipal.add(lblServicioId);
		panelPrincipal.add(txtServicioId);
		panelPrincipal.add(btbAgregar);
				
		add(panelPrincipal);
				
		// Evento de cierre
		addWindowListener(new WindowAdapter() {
		@Override
		 public void windowClosing(WindowEvent e) {
			new ventanaEmpleado(hotel);
		    dispose();
		 }
		 });
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		if (accion.equals("agregar")) {
			new ventanaEmpleado(hotel);
			dispose();
		}
		
	}

}
