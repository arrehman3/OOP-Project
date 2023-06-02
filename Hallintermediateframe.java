import javax.swing.*;
import java.awt.*;
// import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hallintermediateframe extends JFrame {

    
    public JFrame frame;
    public JLabel l1;
    public JButton b1,b2;
    public JPanel panel;

    Hallintermediateframe()
    {
        setTitle("Hall Management111 System");
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(null);
        l1 = new JLabel("Select Hall");
        Font font =  new Font("Arial",Font.BOLD,36);
        l1.setFont(font);
        l1.setBounds(10,30,2000,50);

        b1 = new JButton("Wedding Hall");
        b2 = new JButton("Conference Hall");

        add(l1);
        add(b1);
        add(b2);

        // panel = new JPanel();
        // frame.add(panel);
        // panel.setLayout(new GridLayout(2,2));
        // panel.add(l1);
        // panel.add(b1);
        // panel.add(b2);





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

            }
            else if(ae.getActionCommand().equals("Conference Hall"))
            {

            }
        }    
    }
}
