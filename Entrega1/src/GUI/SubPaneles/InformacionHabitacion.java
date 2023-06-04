package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InformacionHabitacion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionHabitacion frame = new InformacionHabitacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InformacionHabitacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Habitacion doble");
		
		JLabel lblNewLabel_1 = new JLabel("Tamanio:");
		
		JLabel lblNewLabel_2 = new JLabel("35 m^2");
		
		JLabel lblNewLabel_3 = new JLabel("Aire acondicionado:");
		
		JLabel lblNewLabel_4 = new JLabel("Si ");
		
		JLabel lblNewLabel_3_1 = new JLabel("Calefaccion:");
		
		JLabel lblNewLabel_5 = new JLabel("Si");
		
		JLabel lblNewLabel_6 = new JLabel("Tamanio de la cama:");
		
		JLabel lblNewLabel_7 = new JLabel("Cama doble");
		
		JLabel lblNewLabel_8 = new JLabel("Tv:");
		
		JLabel lblNewLabel_9 = new JLabel("Si");
		
		JLabel lblNewLabel_10 = new JLabel("Cafetera: ");
		
		JLabel lblNewLabel_11 = new JLabel("Si");
		
		JLabel lblNewLabel_12 = new JLabel("Ropa de cama y tapete hipoalergenico:");
		
		JLabel lblNewLabel_13 = new JLabel("Si");
		
		JLabel lblNewLabel_14 = new JLabel("Plancha:");
		
		JLabel lblNewLabel_15 = new JLabel("SI");
		
		JLabel lblNewLabel_16 = new JLabel("Secador:");
		
		JLabel lblNewLabel_17 = new JLabel("Si");
		
		JLabel lblNewLabel_18 = new JLabel("Voltaje AC");
		
		JLabel lblNewLabel_19 = new JLabel("SI");
		
		JLabel lblNewLabel_20 = new JLabel("USB-A");
		
		JLabel lblNewLabel_19_1 = new JLabel("SI");
		
		JLabel lblNewLabel_20_1 = new JLabel("USB-C");
		
		JLabel lblNewLabel_19_1_1 = new JLabel("SI");
		
		JLabel lblNewLabel_21 = new JLabel("Desayuno:");
		
		JLabel lblNewLabel_19_1_1_1 = new JLabel("SI");
		
		JLabel lblNewLabel_22 = new JLabel("Parqueadero pago:");
		
		JLabel lblNewLabel_23 = new JLabel("No");
		
		JLabel lblNewLabel_22_1 = new JLabel("Parqueadero gratis:");
		
		JLabel lblNewLabel_13_1 = new JLabel("Si");
		
		JLabel lblNewLabel_24 = new JLabel("Piscina:");
		
		JLabel lblNewLabel_13_1_1 = new JLabel("Si");
		
		JLabel lblNewLabel_25 = new JLabel("Zonas Humedas:");
		
		JLabel lblNewLabel_13_1_1_1 = new JLabel("Si");
		
		JLabel lblNewLabel_26 = new JLabel("BBQ");
		
		JLabel lblNewLabel_13_1_1_1_1 = new JLabel("Si");
		
		JLabel lblNewLabel_27 = new JLabel("Wifi gratis:");
		
		JLabel lblNewLabel_13_1_1_1_2 = new JLabel("Si");
		
		JLabel lblNewLabel_28 = new JLabel("Recepcion 24 horas:");
		
		JLabel lblNewLabel_29 = new JLabel("Si");
		
		JLabel lblNewLabel_30 = new JLabel("Permite mascotas:");
		
		JLabel lblNewLabel_29_1 = new JLabel("Si");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(36)
							.addComponent(lblNewLabel_4))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addGap(18)
							.addComponent(lblNewLabel_7))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_8)
							.addGap(18)
							.addComponent(lblNewLabel_9))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_12)
							.addGap(18)
							.addComponent(lblNewLabel_13))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_18)
								.addComponent(lblNewLabel_16)
								.addComponent(lblNewLabel_14))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_19)
								.addComponent(lblNewLabel_17)
								.addComponent(lblNewLabel_15)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_20)
							.addGap(18)
							.addComponent(lblNewLabel_19_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_20_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_19_1_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_21)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_19_1_1_1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_10)
							.addGap(18)
							.addComponent(lblNewLabel_11)))
					.addPreferredGap(ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_22)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_23))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_22_1)
							.addGap(18)
							.addComponent(lblNewLabel_13_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_24)
							.addGap(18)
							.addComponent(lblNewLabel_13_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_25)
							.addGap(18)
							.addComponent(lblNewLabel_13_1_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_26)
							.addGap(18)
							.addComponent(lblNewLabel_13_1_1_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_27)
							.addGap(18)
							.addComponent(lblNewLabel_13_1_1_1_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_28)
							.addGap(18)
							.addComponent(lblNewLabel_29))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_30)
							.addGap(18)
							.addComponent(lblNewLabel_29_1, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(204, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(390)
					.addComponent(lblNewLabel)
					.addContainerGap(396, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_22)
						.addComponent(lblNewLabel_23))
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_22_1)
						.addComponent(lblNewLabel_13_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_24)
						.addComponent(lblNewLabel_13_1_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_7)
						.addComponent(lblNewLabel_25)
						.addComponent(lblNewLabel_13_1_1_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_9)
						.addComponent(lblNewLabel_26)
						.addComponent(lblNewLabel_13_1_1_1_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_10)
						.addComponent(lblNewLabel_11)
						.addComponent(lblNewLabel_27)
						.addComponent(lblNewLabel_13_1_1_1_2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_12)
						.addComponent(lblNewLabel_13)
						.addComponent(lblNewLabel_28)
						.addComponent(lblNewLabel_29))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_15)
						.addComponent(lblNewLabel_14)
						.addComponent(lblNewLabel_30)
						.addComponent(lblNewLabel_29_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_17)
						.addComponent(lblNewLabel_16))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_18)
						.addComponent(lblNewLabel_19))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_20)
						.addComponent(lblNewLabel_19_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_20_1)
						.addComponent(lblNewLabel_19_1_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_21)
						.addComponent(lblNewLabel_19_1_1_1))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
