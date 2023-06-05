import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerframe extends JFrame   {
    
    private Manager M;
    private JTextField t1,t2,t3;
    private JFrame frame;
    private JLabel backgroundimage,l1,l2,l3,L0;
    private JButton b1,b2;
    private ImageIcon image;   

    customerframe(Manager M)

    
    {

        this.M = M;
        setTitle("Hall Management System");
        setSize(800,600);
        setLayout(null);
        setResizable(false);
        try{
            image = new ImageIcon("main frame.jpg");
        }
        catch(Exception e)
        {
            System.out.println("Image customer problem");
        }
        Font font = new Font("Arial",Font.BOLD,40);
        L0 = new JLabel("Add Customer");
        L0.setFont(font);
        L0.setBounds(10,30,2000,50);
        L0.setOpaque(true);
        
        
        // l0 = new JLabel("Add Manager Details");
        l1 = new JLabel("Enter Customer Name:");
        l1.setBounds(100,100,130,40);
        l1.setOpaque(true);
        t1 = new JTextField();
        t1.setBounds(250,100,140,40);
        l2 = new JLabel("Enter Customer Id:");
        l2.setBounds(100,200,120,40);
        l2.setOpaque(true);
        t2 = new JTextField();
        t2.setBounds(250,200,140,40);
        l3 = new JLabel("Customer's Contact No:");
        l3.setBounds(100,300,140,40);
        l3.setOpaque(true);
        t3 = new JTextField();
        t3.setBounds(250,300,140,40);
        b1 = new JButton("Enter");
        b1.setBounds(100,400,140,40);
        b2 = new JButton("Clear");
        b2.setBounds(250,400,140,40);
        backgroundimage = new JLabel(image);
        backgroundimage.setBounds(0,-20,getWidth(),getHeight());
        add(L0);
        // add(l0);
        add(l1);add(t1);
        add(l2);add(t2);
        add(l3);add(t3);
        add(b1);
        add(b2);
        add(backgroundimage);
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        
        //setLayout(new BorderLayout());
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
                if(t1.getText().equals("")|| t2.getText().equals("")||t3.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(frame,"Fill all Boxes");
                }

                else if(v.checkString(t1.getText()) && v.checkNumber(t2.getText()) && v.checkNumber(t3.getText()))
                {
                    String name = t1.getText() ;
                    int id = Integer.parseInt(t2.getText());
                    String num = t3.getText();
                    Customer C1 = new Customer(id, name, num);
                    dispose();
                    JOptionPane.showMessageDialog(frame,C1.toString());

                    
                    Hallintermediateframe HIF = new Hallintermediateframe(M,C1);
                }
                else{
                   JOptionPane.showMessageDialog(frame,"Incorrect Input");
                    
                }
            }

            else 
            {
                t1.setText("");
                t2.setText("");
                t3.setText("");
            }
        }
    }
}


