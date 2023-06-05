package GUI.SubPaneles;

import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.awt.geom.Path2D;

import javax.swing.JPanel;

import modelo.Reserva;
import procesamiento.Hotel;



public class GraficaFacturas extends JFrame {
	
	private ArrayList<Reserva> listReservas;
		
		public GraficaFacturas(Hotel hotel) {
			setSize(new Dimension(1200,700));
			setVisible(true);
			listReservas= hotel.getInfo().getReservas();
			setTitle("Gráfico de los precios de las facturaas vs tiempo");
		
		}
		
			public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.BLACK);
			
			g2d.drawLine(100, 650, 100, 100);
			g2d.drawLine(100, 650, 1000, 650);
			g2d.setColor(Color.blue);
			ArrayList<Rectangle2D.Double> listRectangulos= new ArrayList<Rectangle2D.Double>();
			
			for (int i=0; i<listReservas.size(); i++) {
			
				Rectangle2D.Double rectangle= new Rectangle2D.Double((i*30)+110, 650-(listReservas.get(i).getPrecio()/1000),
												20, listReservas.get(i).getPrecio()/1000);
				listRectangulos.add(rectangle);
			}
			for (int j=0;j<listRectangulos.size(); j++) {
				g2d.fill (listRectangulos.get(j));
			}
}
}
