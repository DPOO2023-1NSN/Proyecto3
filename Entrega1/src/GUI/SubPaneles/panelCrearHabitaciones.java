package GUI.SubPaneles;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class panelCrearHabitaciones extends JFrame implements ActionListener{
	
	public panelCrearHabitaciones() {
		setBounds(100, 100, 800, 600);
		setTitle("Crear Habitaciones");
		setResizable(true);
		setVisible(true);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension (800,600));
		setLayout(new GridLayout(4,1));
		
		
		
		JPanel panelNorte= new JPanel();
		panelNorte.setLayout(new FlowLayout());
		panelNorte.setPreferredSize(new Dimension (800,300));
		JPanel panelMedio1= new JPanel();
		panelMedio1.setLayout(new FlowLayout());
		JPanel panelMedio2= new JPanel();
		panelMedio2.setLayout(new FlowLayout());
		JPanel panelSur= new JPanel();
		panelSur.setLayout(new FlowLayout());
		panelSur.setPreferredSize(new Dimension (700,200));
		
		JLabel LTipoHab= new JLabel("Tipo de habitación:");
		LTipoHab.setPreferredSize(new Dimension (200,50));
		
		JComboBox<String> cTipoHab= new JComboBox();
		cTipoHab.addItem("Sencilla");
		cTipoHab.addItem("Suit");
		cTipoHab.addItem("Suit Doble");
		cTipoHab.setPreferredSize(new Dimension (200,50));
		
		JLabel jid= new JLabel("ID:");
		jid.setPreferredSize(new Dimension (100,50));
		JTextField tfjid= new JTextField();
		tfjid.setPreferredSize(new Dimension (100,50));
		
		JLabel capacidadNiños= new JLabel("Capacidad niños:");
		capacidadNiños.setPreferredSize(new Dimension (100,50));
		JTextField tfcapacidadNiños= new JTextField();
		tfcapacidadNiños.setPreferredSize(new Dimension (100,50));
		
		JLabel capacidadAdultos= new JLabel("Capacidad niños:");
		capacidadAdultos.setPreferredSize(new Dimension (100,50));
		JTextField tfcapacidadAdultos= new JTextField();
		tfcapacidadAdultos.setPreferredSize(new Dimension (100,50));
		
		JLabel adicionales= new JLabel ("Extras de la habitación: ");
		JRadioButton balcon= new JRadioButton("Balcón");
		balcon.setPreferredSize(new Dimension(150,50));
		JRadioButton ventana= new JRadioButton("Ventana");
		ventana.setPreferredSize(new Dimension(150,50));
		JRadioButton cocina= new JRadioButton("Cocina");
		cocina.setPreferredSize(new Dimension(150,50));
		
		JButton crearHabitacion = new JButton ("Crear Habitación");
		crearHabitacion.setPreferredSize(new Dimension (200,200));
		JLabel avisos= new JLabel ("                        ");
		avisos.setPreferredSize(new Dimension (200,200));
		
		panelNorte.add(LTipoHab);
		panelNorte.add(cTipoHab);
		panelNorte.add(jid);
		panelNorte.add(tfjid);
		
		panelMedio1.add(capacidadNiños);
		panelMedio1.add(tfcapacidadNiños);
		panelMedio1.add(capacidadAdultos);
		panelMedio1.add(tfcapacidadAdultos);
		
		panelMedio2.add(adicionales);
		panelMedio2.add(balcon);
		panelMedio2.add(ventana);
		panelMedio2.add(cocina);
		panelMedio2.add(avisos);
		
		panelSur.add(crearHabitacion);
		panelSur.add(avisos);

		add(panelNorte);
		add(panelMedio1);
		add(panelMedio2);
		add(panelSur);
	
	}
	
	
	public static void main(String[] args) {
		panelCrearHabitaciones vc = new panelCrearHabitaciones();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
