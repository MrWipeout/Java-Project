/*
 * 
 * Exizoglou Athanasios
 * 321/2015050
 *  
 */


import javax.swing.JButton;

public class Button extends JButton { // i klassh Button anaferetai stis kartes pou tha exei to tamplo mas pairnontas ws orisma id kai sxhma

    String id;//gia na ksexwrizoume to koumpi

    public Button(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
