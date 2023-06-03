import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class COptionFrame2 extends JFrame {

    
    public JFrame frame;
   
    public JButton b1,b2,b3;

    COptionFrame2()
    {
        setTitle("Available Dates Slot");
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new GridLayout(3,3));
        
        b1 = new JButton("2:00PM - 4:00PM");
        b2 = new JButton("4:00PM - 6:00PM");
        b3 = new JButton("7:00PM - 9:00PM");

        
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
            if(ae.getActionCommand().equals("2:00PM - 4:00PM"))
            {
                // WeddingHallFrame WHF = new WeddingHallFrame();
                //JOptionPane.showMessageDialog(frame,"321fdsa");
                dispose();
                //Woption1Frame w = new Woption1Frame();
            }
            else if(ae.getActionCommand().equals("4:00PM - 6:00PM"))
            {
                dispose();
                //WOption2frame w = new WOption2frame();
            }
            else if (ae.getActionCommand().equals("7:00PM - 9:00PM"))
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



