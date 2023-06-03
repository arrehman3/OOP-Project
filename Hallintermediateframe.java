import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hallintermediateframe extends JFrame {

    
    public JFrame frame;
   
    public JButton b1,b2;

    Hallintermediateframe()
    {
        setTitle("Hall Management System");
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new GridLayout(2,2));
        
        b1 = new JButton("Wedding Hall");
        b2 = new JButton("Conference Hall");

        
        add(b1);
        add(b2);

            
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        
    }

    public class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equals("Wedding Hall"))
            {
                // WeddingHallFrame WHF = new WeddingHallFrame();
                // JOptionPane.showMessageDialog(frame,"321fdsa");
                dispose();
                WeddingHallFrame WHF = new WeddingHallFrame();
            }
            else if(ae.getActionCommand().equals("Conference Hall"))
            {
                dispose();
                ConferenceHallFrame CHF = new ConferenceHallFrame();
            }
            else{
                JOptionPane.showMessageDialog(frame,"Nothing Happened");
            }
        }    
    }
}

