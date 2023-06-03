import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentintermediateFrame extends JFrame {

    
    public JFrame frame;
    public JLabel l1,l2,l3,l0,L0;
    public JButton b1,b2,b3;
    public JPanel panel;
    public JTextField t1,t2,t3;

    PaymentintermediateFrame()
    {
        setTitle("Payment System");
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new GridLayout(2,2));
        
        b1 = new JButton("VISA Payment");
        b2 = new JButton("Cash Payment");

        
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
            if(ae.getActionCommand().equals("Visa Payment"))
            {
                // WeddingHallFrame WHF = new WeddingHallFrame();
                JOptionPane.showMessageDialog(frame,"321fdsa");
                dispose();
                CardPaymentFrame VPF = new CardPaymentFrame();
            }
            else if(ae.getActionCommand().equals("Cash Payment"))
            {
                dispose();
                CashPaymentFrame CPF = new CashPaymentFrame();
            }
            else{
                JOptionPane.showMessageDialog(frame,"Nothing Happened");
            }
        }    
    }
}


