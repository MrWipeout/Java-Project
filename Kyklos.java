/*
 * Exizoglou Athanasios
 * 321/2015050
 */


import java.awt.Color;
import java.awt.Graphics;

public class Kyklos extends Sxhma { //klash gia th dhmiourgia tou sxhmatos kyklos h opoia klhronomei apo th klash sxhma

    public Kyklos(String id, boolean selected, Color color) { // klassh gia ton kuklou costructor
        super(id, selected, color);
    }

    public void paint(Graphics g) {//h methodos auth einai ypeuthini gia thn dimiourgia tou sximatos pou xreiazomaste
        g.setColor(color); //dinoume xrwma
        g.drawOval(10, 10, 20, 20); //dinoume diastaseis
    }

}
