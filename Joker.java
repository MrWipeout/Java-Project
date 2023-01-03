/*
 * Exizoglou Athanasios
 * 321/2015050
 */


import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Joker extends Kyklos { //klash gia ton joker
									//klhronomei apo thn klash kyklos

	public Joker(String id, boolean selected, Color color) { //constructor
		super(id, selected, color);
		
	}
	public void paint(Graphics g) { //h methodos auth einai ypeuthini gia thn dimiourgia tou sximatos pou xreiazomaste

		g.setColor(Color.BLACK);  //vazoume mauro xrwma
		g.fillOval(5,8,40,40); //gemizoume ton kyklo me to xrwma
		g.drawOval(5,8,40,40);//sxediazoume ton kyklo

		
		 FontMetrics fm = g.getFontMetrics();
         double textWidth = fm.getStringBounds("JOKER", g).getWidth();
         g.setColor(Color.RED); //thetoume kokkino xrwma sta grammata
         g.drawString("JOKER", (int) (25 - textWidth/2),  (int) (25 + fm.getMaxAscent() / 2)); //sxediaosume to string kai dinoume diastaseis gia na mpei oso pio konta sto kentro
		
	}
}
