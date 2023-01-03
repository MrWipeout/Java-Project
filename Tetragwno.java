/*
 * Exizoglou Athanasios
 * 321/2015050
 */
import java.awt.Color;
import java.awt.Graphics;

public class Tetragwno extends Sxhma { // klassh gia ton sxediasmo tou tetragwnou klhronomei apo thn klash sxhma


	public Tetragwno(String id, boolean selected, Color color) { //costructor
		super(id, selected, color);
	}

	public void paint(Graphics g) {//h methodos auth einai ypeuthini gia thn dimiourgia tou sximatos pou xreiazomaste
		g.setColor(color);//vazoume xrwma
		g.drawRect(15,15,15,15);//sxediazei to tetragwno to kathe 15 einai h kathe tou pleyra
	}

}
