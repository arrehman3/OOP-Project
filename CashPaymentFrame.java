import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener.*;

public class CashPaymentFrame extends JFrame {
    public JFrame frame;
    public JLabel l1,l2,l3,l4,L0,l11;
    public JButton b1,b2;
    public JTextField t2;

    CashPaymentFrame()
    {
        setState(MAXIMIZED_BOTH);
        setTitle("Cash Payment Frame");
        setLayout(null);

        Font font = new Font("Arial",Font.BOLD,40);
        L0 = new JLabel("Cash Payment");
        L0.setFont(font);
        L0.setBounds(10,30,2000,50);
        
        
        // l0 = new JLabel("Add Manager Details");
        l1 = new JLabel("Amount:");
        l1.setBounds(100,100,130,40);
        l11 = new JLabel("Amount to be paid will be entered here");
        l11.setBounds(250,100,140,40);
        l2 = new JLabel("Enter Amount:");
        l2.setBounds(100,150,120,40);
        t2 = new JTextField();
        t2.setBounds(250,150,140,40);
        // l3 = new JLabel("Expiry Date(without dashes):");
        // l3.setBounds(100,200,140,40);
        // t3 = new JTextField();
        // t3.setBounds(250,200,140,40);
        // l4 = new JLabel("Enter CVV:");
        // l4.setBounds(100,250,140,40);
        // t4 = new JTextField();
        // t4.setBounds(250,250,140,40);
        // b1 = new JButton("Enter");
        // b1.setBounds(150,400,140,40);
        // b2 = new JButton("Clear");
        // b2.setBounds(300,400,140,40);
        add(L0);
        // add(l0);
        add(l1);add(l11);
        add(l2);add(t2);
        // add(l3);add(t3);
        add(b1);
        add(b2);
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public class MyActionListener implements ActionListener
    {
            public void actionPerformed(ActionEvent ae)
            {
                validations v = new validations();
                if(ae.getActionCommand().equals("Enter"))
                {
                    double amount = Double.parseDouble( t2.getText() ) ;
                    if(t2.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(frame,"Fill all Boxes");
                    }
                    //else if to check if amount is not equal to AMOUNT
                    // else if()
                    // {
                    //     JOptionPane.showMessageDialog(frame," Incorrect Payment");
                    // }

                    else if(v.checkNumber(t2.getText()) )
                    {
                        
                        // String ExpiryDate = t3.getText();
                        // String CVV = t4.getText();
                        PaymentMethod payment = new CashPayment();
                        payment.makePayment(amount);
                        dispose();
                        JOptionPane.showMessageDialog(frame,"Payment Successful");
                    }
                    else{
                    JOptionPane.showMessageDialog(frame,"Incorrect Input");
                        
                    }
                }

                else 
                {
                    // t4.setText("");
                    t2.setText("");
                    // t3.setText("");
                }
            }
    }
    
}    

