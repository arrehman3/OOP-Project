import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class COptionFrame3 extends JFrame {

    
    public JFrame frame;
   
    public JButton b1,b2,b3;

    COptionFrame3()
    {
        setTitle("Available Time Slot");
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new GridLayout(3,3));
        
        b1 = new JButton("1:00PM - 3:00PM");
        b2 = new JButton("4:00PM - 6:00PM");
        b3 = new JButton("7:00PM - 10:00PM");

        
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
            if(ae.getActionCommand().equals("1:00PM - 3:00PM"))
            {
                // WeddingHallFrame WHF = new WeddingHallFrame();
                //JOptionPane.showMessageDialog(frame,"321fdsa");
                dispose();
                //Woption1Frame w = new Woption1Frame();
            }
            else if(ae.getActionCommand().equals("4:00PM - 6:00PM0"))
            {
                dispose();
                //WOption2frame w = new WOption2frame();
            }
            else if (ae.getActionCommand().equals("7:00PM - 10:00PM"))
            {
                dispose();
                //WOptionframe3 w = new WOptionframe3();
            }
            else{
                JOptionPane.showMessageDialog(frame,"Nothing Happened");
            }
        }    
    }
}


