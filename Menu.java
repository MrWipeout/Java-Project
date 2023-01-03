/*
 * Exizoglou Athanasios
 * 321/2015050
 */


import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu implements ActionListener {

    static User user = new User();

    public User getUser() {
        return user;
    }
    
    //dhmiourgia item
    private JMenuItem start = new JMenuItem("Start");
    private JMenuItem end = new JMenuItem("End");
    private JMenuItem howto = new JMenuItem("How To Play");
    private JMenuItem aboutus = new JMenuItem("About Us");

    private JMenuItem insert = new JMenuItem("Insert your credentials");
    private JMenuItem record = new JMenuItem("View older record of other users");

    public Menu() { //default costructor

    }

    public void menu() {
    	
        JFrame frame = new JFrame(); //dhmiourgia jframe

        frame.setBounds(100, 100, 450, 300); //dinoume diastaseis
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //mas emfanizetai to frame sto kentro ths othonhs
        JMenuBar menuBar = new JMenuBar(); //dhmiourgia ths baras me ta menu epilogwn
        JMenu game = new JMenu("Game Options"); //dhmiourgia tou 1ou menu
        JMenu userOp = new JMenu("User options"); //dhmiourgia 2ou
        JMenu about = new JMenu("About"); //tritou menu

        game.add(start); //ginetai prosthiki tou item start sto menu game
        game.add(end); //ginetai prosthiki tou item end sto menu game
        about.add(howto); //ginetai prosthiki tou item howto sto menu about
        about.add(aboutus);
        userOp.add(insert);//ginetai prosthiki tou item  insert sto menu userOp
        userOp.add(record);
        menuBar.add(game); //prosthetei sthn mpara to 1o menu pou periexei to start kai to game
        menuBar.add(userOp); //prosthetei sth  mpara to menu userOp
        menuBar.add(about);
        frame.setJMenuBar(menuBar); //kai kanei add oloklhro ro menu sto frame

        //dinoume zwh se ola ta parakatw
        start.addActionListener(this);
        end.addActionListener(this);
        howto.addActionListener(this);
        aboutus.addActionListener(this);
        insert.addActionListener(this);
        record.addActionListener(this);

        frame.setVisible(true); //kanoume orato to frame 
        //frame.pack(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {    
        Object source = e.getSource();              //dhmiourgia antikeimenou object sthn opoia vazoume to e to opoio einai h energeia tou user
        if (source.equals(start)) {                 //an h energeia tou user htan na pathsei to start 
            String[] options = {"8x8", "5x5", "10x10"};     //pinakas me ta analoga munhmata
            String n = (String) JOptionPane.showInputDialog(new JFrame(), "Please select a level",          //dhmiourgia tou panel level chooser
                    "Level chooser", JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
            Template t1 = new Template();                       //dhmiourgia tou antikeimenou t1

            if (n.equals("8x8")) {
                t1.graphicEasy(new JFrame("Titlos"), 8, 8);     //an h epilogh tou xrhsth einai 8x8 tote dwse sthn sunarthsh graphicEasy tis antistoixes parametrous
            } else if (n.equals("5x5")) {
                t1.graphicEasy(new JFrame("Titlos"), 5, 5);     //an h epilogh tou xrhsth einai 5x5 tote dwse sthn sunarthsh graphicEasy tis antistoixes parametrous
            } else if (n.equals("10x10")) {
                t1.graphicEasy(new JFrame("Titlos"), 10, 10);   //an h epilogh tou xrhsth einai 10x10 tote dwse sthn sunarthsh graphicEasy tis antistoixes parametrous
            }

        } else if (source.equals(end)) {            //an h epilogh tou xrhsth einai end tote to programma mas termatizetai
            System.exit(0);
        } else if (source.equals(howto)) {          // an h epilogh tou xrhsth einai to how tote dhmiourgoume ena parathuro 
            JFrame f = new JFrame("Learn to play");         //me titlo learn tou play
            f.setSize(300, 100);                        //analoges diastaseis
            f.setLayout(new GridLayout(1, 2));              
            JTextArea area = new JTextArea(20, 20);         //dhmiourgia enos munhmatos area 
            area.setText("To paixnidi paizetai epilegontas 2 kartes.\nNikhths einai autos pou vrei tis perissoteres se  \nmikrotero xrono");       //prosthiki periexomenou mesa sto area  
                               
            JButton exit = new JButton("OK");               //dhmiourgia koumpiou exit
            f.add(area);                                //prosthiki tou mhnumatos mesa sto parathuro
            f.setLocationRelativeTo(null);              //emfanish parathurou sto kentro
            f.setVisible(true);                         //emfanish tou parathurou
            exit.addActionListener(new ActionListener() {           //dinoume zwh sto exit an paththei

                @Override
                public void actionPerformed(ActionEvent e) {
                    f.setVisible(false);            //kruvoume to parathuro
                }

            });

        } else if (source.equals(aboutus)) {                    //an o xrhsths epileksei to about us
            JFrame f = new JFrame("Who we are");                //titlos tou parathurou
            f.setSize(250, 150);                        //diastaseis tou parathurou
            f.setLayout(new GridLayout(1, 2));              //prosthiki layout mesa sto parathuro
            JTextArea area = new JTextArea(20, 20);             //dhmiourgia text me analoges diastaseis
            area.setText("We are:\n Kargaki Maria  \n Exizoglou Athanasios ");      //prosthiki tou antistoixou mhnumatos mesa sto area 

            f.setLocationRelativeTo(null);              //emfanish parathurou sto kentro
            area.setEditable(false);                        
            JButton exit = new JButton("OK");           //dhmiourgia koumpiou
            f.add(area);                                //prosthiki tou mhnumatos mesa sto parathuro
            f.setVisible(true);                         //emfanish parathurou
            exit.addActionListener(new ActionListener() {       //dinoume zwh sto exit 

                @Override
                public void actionPerformed(ActionEvent e) {
                    f.setVisible(false);                    //an paththei tote kruvoume to parathuro
                }

            });
        } else if (source.equals(record)) {                 //an h epilogh tou xrhsth einai to record 

            ObjectInputStream obis = null;                  //
            try {
                JFrame f2 = new JFrame("Old scores");   //dhmiourgia parathurou me titlo old scores
                f2.setSize(300, 300);                   //diastaseis parathurou
                f2.setLayout(new GridLayout(1, 2));     //prosthiki layout mesa sto frame
                JTextArea area = new JTextArea(20, 20);         //dhmiourgia text me analoges diastaseis
                                                                
                File file = new File("users.txt");      //dhmiourgia arxeiou kai elegxos gia to an uparxei
                if (file.exists()) { 
                    FileInputStream in1 = new FileInputStream(file);    
                    obis = new ObjectInputStream(in1);              //to kanoume gia na mporesoume na filtrarooume to arxeio gia na mporesei na diavasei ta antikeimena
                    Object op;
                    while (obis != null && in1.available() != 0) {
                       
                        User us = (User) obis.readObject(); //casting
                        area.append(us.toString());
                    }
                    in1.close();    //kleisimo                                         
                    obis.close(); //kleisimo
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "There are no records", "File not found", JOptionPane.ERROR_MESSAGE);       //dhmiourgia panel me analogo mnm
                }
                f2.setLocationRelativeTo(null);
                f2.add(area);
                f2.pack();
                f2.setVisible(true);

            } catch (IOException ex) {                  //an uparksoun exceptions tote emfanizei ta analoga mhnumata
                ex.printStackTrace();
                JOptionPane.showMessageDialog(new JFrame(), "There are no records", "File not found", JOptionPane.ERROR_MESSAGE);

            } catch (ClassNotFoundException ex) {
                System.out.println("class");
            }

        } else if (source.equals(insert)) {                                             //an epileksei to insert tote emfanizei panel me analogo mnm gia thn eisagwgh twn stoixeiwn tou paixth
            String name = JOptionPane.showInputDialog("Please type your name");
            user.setName(name);

        }

    }

}
