/*
 * Exizoglou Athanasios
 * 321/2015050
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Template implements ActionListener { // i klassh auth perilamvanei tin dhmiourgia tou paixnidiou

    private Button koumpia[]; // pinakas me ta koumpia
    private JLabel labels[]; // pinakas me labels opou exoume ta sxhmata
    private int counter = 0;
    private int score = 0;
    private int previousCard = 100;
    private int tries = 0;

    private File file = new File("users.txt");

    public void graphicEasy(JFrame frame, int x, int y) {

        koumpia = new Button[x * y];
        labels = new JLabel[x * y];
        ArrayList<Sxhma> cards = new ArrayList<>(); // i lista ayth exei mesa ola ta sximata pou tha apeikonistoun sto tamplo
        GridLayout grid = new GridLayout(x, y);
        int mult=x*y;

        int fin =mult/ 10;
        // gemizoume tin lista cards me sxhmata
        
        for (int i = 0; i < 2 * fin; i++) {
            cards.add(new Tetragwno("sqrB", false, Color.BLACK));       //prosthiki antikeimenou tetragwno mesa sthn lista cards, analoga me to ti diastaseis tha epileksei o xrhsths gia na paiksei tha einai analoga kai oi epanalhpseis
        }

        for (int i = 0; i < fin; i++) {
            cards.add(new Tetragwno("sqrR", false, Color.RED));         //prosthiki antikeimenou Tetragwno mesa sthn lista cards, analoga me to ti diastaseis tha epileksei o xrhsths gia na paiksei tha einai analoga kai oi epanalhpseis
        }

        for (int i = 0; i < 2 * fin; i++) {
            cards.add(new Tetragwno("sqrG", false, Color.GREEN));       //prosthiki antikeimenou Tetragwno mesa sthn lista cards, analoga me to ti diastaseis tha epileksei o xrhsths gia na paiksei tha einai analoga kai oi epanalhpseis
        }

        for (int i = 0; i < fin; i++) {
            cards.add(new Romvos("diamB", false, Color.BLUE));          //prosthiki antikeimenou Romvos mesa sthn lista cards, analoga me to ti diastaseis tha epileksei o xrhsths gia na paiksei tha einai analoga kai oi epanalhpseis
        }

        for (int i = 0; i < 2 * fin; i++) {
            cards.add(new Trigwno("triG", false, Color.BLUE));          //prosthiki antikeimenou Trigwno mesa sthn lista cards, analoga me to ti diastaseis tha epileksei o xrhsths gia na paiksei tha einai analoga kai oi epanalhpseis
        }

        if (x * y == 25) {
            for (int i = 0; i < 4; i++) {
                cards.add(new Trigwno("triG", false, Color.RED));       //an oi diastaseis einai 5*5=25 tote na ginoun prosthiki mesa sthn lista 4 antikeimena trigwno me xrwma kokkino
            }
            for (int i = 0; i < 1; i++) {
                cards.add(new Joker("jo", false, Color.BLACK));         //an oi diastaseis einai 5*5=25 tote na ginoun prosthiki mesa sthn lista 2 antikeimena joker me xrwma mauro
            }
        } else if (x * y == 64) {
            for (int i = 0; i < 4; i++) {
                cards.add(new Trigwno("triG", false, Color.GREEN));     //an oi diastaseis einai 8*8=25 tote na ginoun prosthiki mesa sthn lista 4 antikeimena trigwno me xrwma prasino
            }
            for (int i = 0; i < 1; i++) {
                cards.add(new Joker("jo", false, Color.BLACK));         //an oi diastaseis einai 8*8=25 tote na ginoun prosthiki mesa sthn lista 2 antikeimena joker me xrwma mauro
            }
        } else {
            for (int i = 0; i < 3; i++) {
                cards.add(new Joker("jo", false, Color.BLACK));         //alliws kane prosthiki 4 joker me xrwma mauro
            }
        }

        for (int i = 0; i < fin; i++) 
        {
            cards.add(new Kyklos("ovalB", false, Color.BLACK));         //prosthiki kuklwn sthn lista me mauro kai kokkino xrwma
        }

        for (int i = 0; i < fin; i++) {
            cards.add(new Kyklos("ovalR", false, Color.RED));
        }

        Collections.shuffle(cards); // anakatevoume thn lista wste na emfanistoun me tixaia seira

        for (int i = 0; i < x * y; i++) {
            // to id tou button einai to id tou sxhmatos panw sto button/karta
            // gia na ksexwrisoume thn monadikothta twn zeugariwn.
            // ola ta zeugaria exoun tous idious kwdikous.

            Button button1 = new Button(cards.get(i).getId());//dimiourgoume to koumpi kai toy dinoume to id apo tis kartes pou ftiaksame gia na mporesoume na to kanoume match me to epomeno koumpi

            JLabel label = (cards.get(i));//emfanizoume thn karta se label
            frame.add(button1); 
            button1.addActionListener(this);    //dinoume zwh sto button
            
            button1.setBackground(Color.BLACK);     //xrwmatizoume to koumpi kai to kanoume mauro
            button1.setForeground(Color.RED);       
            koumpia[i] = button1;               //posthiki tou koumpiou ston pinaka
            labels[i] = label;          //posthiki tou label ston pinaka
            labels[i].setVisible(false);        //kruvoume ton pinaka
            frame.add(labels[i]);           //prosthiki tou pinaka sto frame
           
        }

        frame.setTitle("Game");                 //titlos tou parathurou
        //ftiaxnoume to megethos tou frame analoga me ton vathno dyskolias
        if (x * y == 25) {
            frame.setSize(500, 500);                //an oi diastaseis einai 5x5 oi diastaseis tou parathurou einai 
        } else if (x * y == 64) {
            frame.setSize(800, 800);                //an oi diastaseis einai 8x8 oi diastaseis tou parathurou einai 
        } else if (x * y == 100) {
            frame.setSize(1000, 1000);              //an oi diastaseis einai 10x10 oi diastaseis tou parathurou einai 
        }

        frame.setLocationRelativeTo(null);//vazoume to frame sto kentro
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//termatizoume to programma
        frame.setLayout(grid);

        frame.setVisible(true);             //emfanizoume to parathuro
    }

    @Override
    public void actionPerformed(ActionEvent e) { // energopoihsh koumpiwn
        User user = Menu.user;              //dhmiourgia antikeimenou user
        for (int i = 0; i < koumpia.length; i++) {
            Button b = koumpia[i];                  //prospelash tou pinaka kai eisagwgh tou koumpiou apo thn thesh tou pinaka sto b
            if (e.getSource() == b) {                           //an auto pou pathse o xrhsths einai iso me to b
                if (b.getId().equalsIgnoreCase("jo") || score == 12) {      //an to id tou koumpiou einai iso me to jo h to score einai iso me 12 
                    for (int j = 0; j < koumpia.length; j++) {
                        koumpia[j].setVisible(false);               // krupse ta koumpia 
                        labels[j].setVisible(true);                 // emfanise ta labels

                    }
                    JOptionPane.showMessageDialog(null, "Game ended! You Won!", "information", JOptionPane.INFORMATION_MESSAGE);                //emfanish mhnumatos
                    FileOutputStream f = null;                                                  
                    ObjectOutputStream o = null;

                    if ((user.getName() == null || user.getName().equals(""))) {              //an to onoma tou xrhsth einai keno  
                        String name = JOptionPane.showInputDialog("Please type your name");         //emfanish mhnumatos
                        user.setName(name); 
                    }
                    //H methodos auth voithaei na grapsoume (append) th nea pliroforia afou ksanaektelesoume to programma. Ousiastika mas ftiaxnei thn kefalida(header) tis rohs wste na mporei na ksananigei nea eggrafi diaforetika
                    // tha katastrefotan h kefalida ths rohs kai tha eixame exception otan pigainame gia eggrafi h anagnwsi neas pliroforias

                    user.setScore(score);
                    try {

                        if (file.exists()) {                        //kanoume elegxo an uparxei to arxeio
                        f = new FileOutputStream(file, true);           
                        o = new ObjectOutputStream(f) {         //dhmiourgia rohs pros to arxeio
                            @Override
                            protected void writeStreamHeader() throws IOException {
                                reset();        
                            }
                        };
                        o.writeObject(user);        
                        o.flush();                      //katharizoume to buffer

                        f.close(); // kleisimo
                        o.close();  

                    } else {
                        f = new FileOutputStream(file);     //ftiaxnei mia roh pros to arxeio
                        o = new ObjectOutputStream(f);      //filtrarisma arxeiou gia na diavasei ta antikeimena
                        o.writeObject(user);
                        o.flush();  //katharizoume to buffer

                        f.close(); //kleinoume to arxeio
                        o.close();//kleinoume to arxeio

                    }

                    } catch (FileNotFoundException ex) {            //an uparksoun exceptions tote emfanizei ta analoga mhnumata
                        System.out.println("File Not Found");
                    } catch (IOException ex) {
                        System.out.println("IOException ");
                    }
                    System.exit(0);

                }

                if (previousCard == 100) {
                    previousCard = i;
                }

                counter++;
                if (i % 2 == 0) {
                    koumpia[i].setVisible(false);           //kruvoume ta koumpia

                    labels[i].setVisible(true) ;            //emfanizoume ta labels

                } else {

                    koumpia[i].setVisible(false);          

                    labels[i].setVisible(true);

                }

                if (counter == 2) { // sta 2 anoigmata kartwn, sugkrinoume ta ids twn koumpiwn na doume ean einai zeugari
                    if (koumpia[i].getId().equalsIgnoreCase(koumpia[previousCard].getId())) { // ean nai tote ta afinoume anoikta
                        counter = 0;
                        previousCard = 100;
                        score++;
                    } else { // ean oxi, tote kleinoume tis kartes pou anoikse o paiktis
                        tries++;

                        koumpia[i].setVisible(true);
                        labels[i].setVisible(false);
                        koumpia[previousCard].setVisible(true);
                        labels[previousCard].setVisible(false);

                        counter = 0;
                        previousCard = 100;
                    }
                }
            }

            if (tries == 5) { // sthn periptwsh pou apotuxei meta apo lanthasmenes provlepseis
                JOptionPane.showMessageDialog(null, "Game ended! 5 wrong predictions!", "information", JOptionPane.INFORMATION_MESSAGE);
                FileOutputStream f = null;
                ObjectOutputStream o = null;
                String name;

                if ((user.getName() == null || user.getName().equals(""))) {//elegxoume an to string einai null i keno
                    name = JOptionPane.showInputDialog("Please type your name");

                } else {
                    name = user.getName();
                }
                User newUser = new User(name, score);           //dhmiourgia antikeimenou me duo parametrous
                try {
                    if (file.exists()) {                                
                        f = new FileOutputStream(file, true);               //ftiaxnei mia roh pros to arxeio
                        o = new ObjectOutputStream(f) {                     //filtrarisma arxeiou gia na diavasei ta antikeimena
                            @Override
                            protected void writeStreamHeader() throws IOException {
                                reset();
                            }
                        };
                        o.writeObject(newUser);         
                        o.flush();                                  //katharizoume to buffer

                        f.close();
                        o.close();

                    } else {
                        f = new FileOutputStream(file);
                        o = new ObjectOutputStream(f);
                        o.writeObject(newUser);
                        o.flush();

                        f.close();                              //kleinoume to arxeio
                        o.close();                              //kleinoume to arxeio

                    }

                } catch (FileNotFoundException ex) {                //an uparksoun exceptions tote emfanizei ta analoga mhnumata
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);

            }
        }

    }
}
