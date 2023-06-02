package GUI.SubPaneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class PanelCargarArchivoMenu extends JFrame {
    public PanelCargarArchivoMenu() {
        setTitle("Cargar Archivo de Menú");
        setSize(800, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Creamos los componentes
        JLabel labelRuta = new JLabel("Ingrese la ruta del archivo:");
        JTextField textFieldRuta = new JTextField();
        textFieldRuta.setPreferredSize(new Dimension (600,50));
        JButton botonCargar = new JButton("Cargar archivo");
        botonCargar.setPreferredSize(new Dimension (400,50));
        JLabel labelArchivoCargado = new JLabel();
        
        // Configuracion del layout de la ventana y del panel de la ruta
        setLayout(new BorderLayout());
        JPanel panelRuta = new JPanel();
        panelRuta.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelRuta.add(labelRuta);
        panelRuta.add(textFieldRuta);
        add(panelRuta, BorderLayout.NORTH);
        
    
        JPanel panelBoton= new JPanel();
        panelBoton.setLayout(new FlowLayout());
        panelBoton.add(botonCargar);
        add(panelBoton);
        add(labelArchivoCargado, BorderLayout.SOUTH);

        botonCargar.addActionListener(e -> {
            labelArchivoCargado.setText("Archivo de menú cargado con éxito");
        });
    }

    public static void main(String[] args) {
        PanelCargarArchivoMenu panel = new PanelCargarArchivoMenu();
        panel.setVisible(true);
    }
}
