import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CBookingframe extends JFrame {

    
    public JFrame frame;
   
    public JButton b1,b2,b3;

    CBookingframe()
    {
        setTitle("Available Dates");
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new GridLayout(3,3));
        
        b1 = new JButton("2023-05-19");
        b2 = new JButton("2023-05-20");
        b3 = new JButton("2023-05-21");

        
        add(b1);
        add(b2);
        add(b3);

            
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        
    }

    public class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equals("2023-05-19"))
            {
                // WeddingHallFrame WHF = new WeddingHallFrame();
                // JOptionPane.showMessageDialog(frame,"321fdsa");
                dispose();
                COptionFrame1 c1 = new COptionFrame1();
            }
            else if(ae.getActionCommand().equals("2023-05-20"))
            {
                dispose();
                COptionFrame2 c2 = new COptionFrame2();
            }
            else if (ae.getActionCommand().equals("2023-05-21"))
            {
                dispose();
                COptionFrame3 c3  = new COptionFrame3();
            }
            else{
                JOptionPane.showMessageDialog(frame,"Nothing Happened");
            }
        }    
    }
}


