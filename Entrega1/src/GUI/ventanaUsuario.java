package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.SubPaneles.PanelConsultarDisponibilidad;
import GUI.SubPaneles.ReservasFrame;
import procesamiento.Hotel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;

public class ventanaUsuario extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table;
	private Hotel hotel;


	/**
	 * Create the frame.
	 */
	public ventanaUsuario(Hotel hotel) {
		this.hotel = hotel;
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 543);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Hotel Cartago");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel();
		
		JButton btnNewButton = new JButton("Realizar Reserva");
		btnNewButton.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("reservar");
		
		JButton btnNewButton_1 = new JButton("Consultar habitacion en un rango de fechas");
		btnNewButton_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("consultar");
		
		table = new JTable();
		
		JButton btnNewButton_1_1 = new JButton("Consultar pagos pendientes");
		btnNewButton_1_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(298, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(219)
					.addComponent(lblNewLabel_1)
					.addGap(36))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(141)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(470, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(256)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(270, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(102)
					.addComponent(btnNewButton)
					.addGap(53)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(85))
		);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		if (accion.equals("reservar")) {
			new ReservasFrame(hotel);
		}
		else if(accion.equals("consultar")){
			new PanelConsultarDisponibilidad(hotel);
		}
		
	}
}
