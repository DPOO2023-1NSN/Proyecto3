package GUI.SubPaneles;

import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.ventanaAdministrador;
import procesamiento.Hotel;

public class PanelCargarPreciosHabitaciones extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hotel hotel;

	public PanelCargarPreciosHabitaciones(Hotel hotel) {
		this.hotel = hotel;
		setBounds(100, 100, 800, 600);
		setTitle("Cargar Precios de habitaciones");
		setResizable(true);
		setVisible(true);
		
		
		setLayout(new GridLayout(5,1));
		
		JPanel panelNorte= new JPanel();
		
		JPanel panelMedio1= new JPanel();
		
		JPanel panelMedio2= new JPanel();

		JPanel panelSur= new JPanel();

		
		JLabel LTipoHab= new JLabel("Tipo de habitación:");
		LTipoHab.setPreferredSize(new Dimension (200,50));
		
		JComboBox<String> cTipoHab= new JComboBox();
		cTipoHab.addItem("Sencilla");
		cTipoHab.addItem("Suit");
		cTipoHab.addItem("Suit Doble");
		cTipoHab.setPreferredSize(new Dimension (200,50));
		
		JLabel diaI= new JLabel("Día inicial:");
		diaI.setPreferredSize(new Dimension (100,50));
		
		JTextField tfDiaI= new JTextField();
		tfDiaI.setPreferredSize(new Dimension (100,50));
		
		JLabel diaSemanaI= new JLabel("Día de la semana inicial:");
		diaSemanaI.setPreferredSize(new Dimension (200,50));
		
		JComboBox<String> tfDiaSemanaI= new JComboBox();
		tfDiaSemanaI.addItem("Lunes");
		tfDiaSemanaI.addItem("Martes");
		tfDiaSemanaI.addItem("Miercoles");
		tfDiaSemanaI.addItem("Jueves");
		tfDiaSemanaI.addItem("Viernes");
		tfDiaSemanaI.addItem("Sábado");
		tfDiaSemanaI.addItem("Domingo");
		tfDiaSemanaI.setPreferredSize(new Dimension (100,50));
		
		JLabel mesI= new JLabel("Mes inicial:");
		mesI.setPreferredSize(new Dimension (100,50));
		
		JTextField tfMesI= new JTextField();
		tfMesI.setPreferredSize(new Dimension (100,50));
		
		JLabel diaF= new JLabel("Día final:");
		diaF.setPreferredSize(new Dimension (100,50));
		
		JTextField tfDiaF= new JTextField();
		tfDiaF.setPreferredSize(new Dimension (100,50));
		
		JLabel diaSemanaF= new JLabel("Día de la semana final:");
		diaSemanaF.setPreferredSize(new Dimension (200,50));
		
		JComboBox<String> tfDiaSemanaF= new JComboBox();
		tfDiaSemanaF.addItem("Lunes");
		tfDiaSemanaF.addItem("Martes");
		tfDiaSemanaF.addItem("Miercoles");
		tfDiaSemanaF.addItem("Jueves");
		tfDiaSemanaF.addItem("Viernes");
		tfDiaSemanaF.addItem("Sábado");
		tfDiaSemanaF.addItem("Domingo");
		tfDiaSemanaF.setPreferredSize(new Dimension (100,50));
		
		JLabel mesF= new JLabel("Mes final:");
		mesF.setPreferredSize(new Dimension (100,50));
		
		JTextField tfMesF= new JTextField();
		tfMesF.setPreferredSize(new Dimension (100,50));
		
		JLabel precio= new JLabel("Precio:");
		precio.setPreferredSize(new Dimension (200,50));
		
		JTextField tfPrecio= new JTextField();
		tfPrecio.setPreferredSize(new Dimension (100,50));
		
		JPanel panelSur2= new JPanel();
		panelSur2.setLayout (new FlowLayout());
		
		JButton botonCambiar= new JButton("Cambiar precios");
		botonCambiar.setPreferredSize(new Dimension (200,50));
		botonCambiar.addActionListener(this);
		botonCambiar.setActionCommand("cambiar");
		
		JLabel labelAvisos= new JLabel("");
		panelSur2.add(botonCambiar);
		panelSur2.add(labelAvisos);
		
		panelNorte.add(LTipoHab);
		panelNorte.add(cTipoHab);
		
		panelMedio1.add(diaI);
		panelMedio1.add(tfDiaI);
		panelMedio1.add(diaSemanaI);
		panelMedio1.add(tfDiaSemanaI);
		panelMedio1.add(mesI);
		panelMedio1.add(tfMesI);
		
		panelMedio2.add(diaF);
		panelMedio2.add(tfDiaF);
		panelMedio2.add(diaSemanaF);
		panelMedio2.add(tfDiaSemanaF);
		panelMedio2.add(mesF);
		panelMedio2.add(tfMesF);
		
		panelSur.add(precio);
		panelSur.add(tfPrecio);
		
		add(panelNorte); 
		add(panelMedio1);
		add(panelMedio2);
		add(panelSur);
		add(panelSur2);
		
		pack();
		
		 // Evento de cierre
	     addWindowListener(new WindowAdapter() {
	     @Override
	     public void windowClosing(WindowEvent e) {
	    	 new ventanaAdministrador(hotel);
	    	 dispose();
	     }
	     });
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		int tipoHab=0;
		int sI=1;
		int sF=1;
		
		
		
		if(accion.equals("cambiar")) {
			//hotel.asignarPrecioHabitaciones(int tipo, 
					/*int diaInicio, 
					int diaFin, 
					int mesInicio, 
					int mesfin, 
					int diaSemanaInicio, 
					int diaSemanaFin,
					int precio); */
		}
		
	}

}
