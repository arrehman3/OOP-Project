import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentintermediateFrame extends JFrame {

    
    private JFrame frame;
    private JLabel l1,l2,l3,l4,L0;
    private JButton b1,b2,b3;
    private JPanel panel;
    private JTextField t1,t2,t3;

    PaymentintermediateFrame()
    {
        setTitle("Payment System");
        // setExtendedState(MAXIMIZED_BOTH);
        setSize(800, 600);
        setLayout(new GridLayout(2,2));
        setResizable(false);
        
        b1 = new JButton("Card Payment");
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
            if(ae.getActionCommand().equals("Card Payment"))
            {
                // WeddingHallFrame WHF = new WeddingHallFrame();
                //JOptionPane.showMessageDialog(frame,"321fdsa");
                dispose();
                CardPaymentFrame CPF = new CardPaymentFrame();
            }
            else if(ae.getActionCommand().equals("Cash Payment"))
            {
                dispose();
                PaymentMethod payment = new CashPayment();
                JOptionPane.showMessageDialog(frame,"successful");
            }
            else{
                JOptionPane.showMessageDialog(frame,"Nothing Happened");
            }
        }    
    }
}


