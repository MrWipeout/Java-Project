/*
 * Exizoglou Athanasios
 * 321/2015050
 */


import java.awt.*;
import java.awt.Graphics;

public class Romvos extends Sxhma{  // klassh gia ton romvo klhronomei apo to sxhma

    public Romvos(String id, boolean selected, Color color) { //costructor
        super(id, selected, color);
    }

    public void paint(Graphics g) { //h methodos auth einai ypeuthini gia thn dimiourgia tou sximatos pou xreiazomaste
        g.setColor(color);

        int [] x = { 25, 40, 25, 10 }; //x syntetagmenes twn koryfwn
        int [] y = { 5, 20, 35, 20 }; //y syntetagmenes twn koryfwn
        g.drawPolygon( x, y, 4 ); //epeidh theloume romvo vazoyme 4 ston arithmo twn koryfwn

    }

}
