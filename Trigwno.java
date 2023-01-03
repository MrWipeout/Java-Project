/*
 * Exizoglou Athanasios
 * 321/2015050
 */

import java.awt.Color;
import java.awt.Graphics;

public class Trigwno extends Sxhma{ //klhronomei apo thn klash sxhma
	
	public Trigwno(String id, boolean selected, Color color) {  //costructor
		super(id, selected, color);
	}

	public void paint(Graphics g) {//h methodos auth einai ypeuthini gia thn dimiourgia tou sximatos pou xreiazomaste
		g.setColor(color); //vazoume xrwma
		g.drawPolygon(new int[] {15,20,25}, new int[] {40,10,40}, 3); //sxediash trigwnou
		//to prwto int[] einai gia thn timh tou x to deftero dhlwsei thn timh tou y
		//kai to trito dhlwnei oti einai trigwno
	}

}
