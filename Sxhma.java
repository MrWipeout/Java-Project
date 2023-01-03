/*
 * Exizoglou Athanasios
 * 321/2015050
 */

import javax.swing.JLabel;
import java.awt.*;

public class Sxhma extends JLabel{ // i klassh Sxhma perilamavanei to gewmetriko sxhma kai klironomei to JLabel gia thn dimiourgia Label wste na ta baloume panw sto JFrame
	// einai i  klassh 'pateras' opou klironomeitai apo tis alles klaseis-sximata
	
	String id;
	boolean selected ;
	Color color;

	public Sxhma(String id, boolean selected, Color color) { //costructor
		super();
		this.id = id;
		this.selected=selected;
		this.color = color;
	}

	public String getId() { //getter
		return id;
	}

	public void setId(String id) { //setter
		this.id = id;
	}

	

}
