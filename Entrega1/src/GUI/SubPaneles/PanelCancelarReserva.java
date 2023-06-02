package GUI.SubPaneles;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import GUI.ventanaEmpleado;
import procesamiento.Hotel;

public class PanelCancelarReserva extends JFrame implements ActionListener{
	
	private Hotel hotel;
	
	private JPanel panelPrincipal;
	private JLabel lblTitle;
	private JLabel lblId;
	private JTextArea txtId;
	private JButton btnCancelar;
	
	
	public PanelCancelarReserva(Hotel hotel) {
		this.hotel = hotel;
		// Configuracion frame
		setVisible(true);
		setBounds(200, 200, 400, 200);
		setResizable(false);
		
		//Creacion de componentes
		panelPrincipal = new JPanel();
		setPreferredSize(new Dimension(400,200));
		
		lblTitle = new JLabel("Cancelar reserva");
		lblTitle.setPreferredSize(new Dimension(370,40));
		lblTitle.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblId = new JLabel("ID de reserva");
		lblId.setPreferredSize(new Dimension(120,20));
		
		txtId = new JTextArea();
		txtId.setPreferredSize(new Dimension(230,20));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("cancelar");
		
		// Agregacion componentes
		panelPrincipal.add(lblTitle);
		panelPrincipal.add(lblId);
		panelPrincipal.add(txtId);
		panelPrincipal.add(btnCancelar);
		
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
		if (accion.equals("cancelar")) {
			new ventanaEmpleado(hotel);
			dispose();
		}
		
		
	}

}
