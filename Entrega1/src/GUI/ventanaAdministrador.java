package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.SubPaneles.PanelCargarArchivoHabitaciones;
import GUI.SubPaneles.PanelCargarPreciosHabitaciones;
import GUI.SubPaneles.PanelConsultarHabitaciones;
import procesamiento.Hotel;


import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ventanaAdministrador extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Hotel hotel;
	private JFrame panelCargarPreciosHabitaciones;
	private JPanel panelCrearHabitaciones= new JPanel();
	private PanelConsultarHabitaciones panelConsultarH;
	
	
	private JPanel contentPane;
	private JPanel panelConsultarHabitaciones= new JPanel();
	
	private JPanel panelCargarArchivoHabitaciones= new JPanel();
	
	private JPanel panelconsultarHabitaciones= new JPanel();
	private JPanel panelCargarMenu= new JPanel();
	private JPanel panelEditarMenu= new JPanel();
	private JPanel panelAsignarPreciosMenu= new JPanel();




	/**
	 * Create the frame.
	 */
	public ventanaAdministrador(Hotel hotel) {
		
		setVisible(true);
	//PENDIENTE
		this.hotel= hotel;
		

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 956, 705);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Bienvenido administrador ");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		JLabel lblNewLabel_1_1 = new JLabel("MenÃº habitaciones");
		lblNewLabel_1_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		JButton btnConsultarHabitaciones = new JButton("Consultar habitaciones");
		btnConsultarHabitaciones.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		btnConsultarHabitaciones.addActionListener(this);
		btnConsultarHabitaciones.setActionCommand("ConsultarH");
		
		JButton btnCrearHabitaciones = new JButton("Crear habitaciones");
		btnCrearHabitaciones.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		JButton btnCargarArchivoDe = new JButton("Cargar archivo de habitaciones");
		btnCargarArchivoDe.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		btnCargarArchivoDe.addActionListener(this);
		btnCargarArchivoDe.setActionCommand("cargarAH");
		JButton btnCargarPreciosDe = new JButton("Cargar precios de Habitaciones ");
		btnCargarPreciosDe.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		btnCargarPreciosDe.addActionListener(this);
		btnCargarPreciosDe.setActionCommand("cargarPH");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("       Opciones menÃº");
		lblNewLabel_1_1_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		JButton btnCargarMen = new JButton("Cargar menÃº");
		btnCargarMen.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		JButton btnEditarMen = new JButton("Editar menÃº");
		btnEditarMen.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		
		JButton btnAsignarPreciosAl = new JButton("Asignar precios al menÃº");
		btnAsignarPreciosAl.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(428)
									.addComponent(lblNewLabel))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(195)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnConsultarHabitaciones, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnCrearHabitaciones, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnCargarArchivoDe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnCargarPreciosDe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(219)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnAsignarPreciosAl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnEditarMen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnCargarMen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
					.addGap(84))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel)
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCargarMen, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConsultarHabitaciones, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditarMen, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCrearHabitaciones, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAsignarPreciosAl, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCargarArchivoDe, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCargarPreciosDe, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(376, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
	}
	
	//CREACIÃ“N DE SUBPANELES
	//PANEL CARGAR PRECIOS HABITACIONES

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String grito = e.getActionCommand();
			
		if(grito.equals("cargarPH")) {
			new PanelCargarPreciosHabitaciones(hotel);
		}
			
		else if(grito.equals("ConsultarH")) {
			new PanelConsultarHabitaciones(hotel, "admin");
		}
			
		else if(grito.equals("cargarAH")) {
			new PanelCargarArchivoHabitaciones(hotel);
		}
		dispose();
		
	}
}