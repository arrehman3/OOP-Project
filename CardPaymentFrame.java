import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener.*;

public class CardPaymentFrame extends JFrame {
    private JFrame frame;
    private JLabel backgroundimage,l1,l2,l3,l4,L0,l11;
    private JButton b1,b2;
    private JTextField t2,t3,t4;
    private ImageIcon image;

    CardPaymentFrame()
    {
        //setExtendedState(MAXIMIZED_BOTH);
        setSize(612,408);
        setTitle("Card Payment Frame");
        setLayout(null);
        setResizable(false);
        try{
            System.out.println("tried");
            image = new ImageIcon("cardpayment2.jpg");
        }catch(Exception e){
            System.out.println("Card error");
        }

        Font font = new Font("Arial",Font.BOLD,40);
        L0 = new JLabel("Enter Card Details");
        L0.setFont(font);
        L0.setBounds(10,30,2000,50);
        L0.setOpaque(true);
        
        
        // l0 = new JLabel("Add Manager Details");
        l1 = new JLabel("Enter CVV:");
        l1.setBounds(100,100,140,40);
        l1.setOpaque(true);
        t4 = new JTextField();
        t4.setBounds(250,100,140,40);
        l2 = new JLabel("Card Number:");
        l2.setBounds(100,150,120,40);
        l2.setOpaque(true);
        t2 = new JTextField();
        t2.setBounds(250,150,140,40);
        l3 = new JLabel("Expiry Date:");
        l3.setBounds(100,200,140,40);
        l3.setOpaque(true);
        t3 = new JTextField();
        t3.setBounds(250,200,140,40);
        // l4 = new JLabel("Enter CVV:");
        // l4.setBounds(100,250,140,40);
        // t4 = new JTextField();
        // t4.setBounds(250,250,140,40);
        b1 = new JButton("Enter");
        b1.setBounds(100,250,140,40);
        b2 = new JButton("Clear");
        b2.setBounds(250,250,140,40);
        backgroundimage = new JLabel(image);
        backgroundimage.setBounds(0,-20,getWidth(),getHeight());
        add(L0);
        // add(l0);
        add(l1);add(t4);
        add(l2);add(t2);
        add(l3);add(t3);
        add(b1);
        add(b2);
        add(backgroundimage);
        
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
                    if( t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(frame,"Fill all Boxes");
                    }

                    else if(v.checkNumber(t2.getText()) && v.checkNumber(t3.getText()) && v.checkNumber(t4.getText()))
                    {
                        String cardNO = t2.getText() ;
                        String ExpiryDate = t3.getText();
                        String CVV = t4.getText();
                        PaymentMethod payment = new CreditCardPayment(cardNO,ExpiryDate,CVV);
                        dispose();
                        JOptionPane.showMessageDialog(frame,"Payment Successful");
                        JOptionPane.showMessageDialog(frame,"Thankyou");
                        
                        //Hallintermediateframe HIF = new Hallintermediateframe();
                    }
                    else{
                    JOptionPane.showMessageDialog(frame,"Incorrect Input");
                        
                    }
                }

                else 
                {
                    t4.setText("");
                    t2.setText("");
                    t3.setText("");
                }
            }
    }
    
}    
