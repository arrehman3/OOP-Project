import javax.swing.*;
import java.awt.*;
// import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hallintermediateframe extends JFrame {

    
    public JFrame frame;
    public JLabel l1,l2,l3,l0,L0;
    public JButton b1,b2,b3;
    public JPanel panel;
    public JTextField t1,t2,t3;

    Hallintermediateframe()
    {
        // setTitle("Hall Management111 System");
        // setExtendedState(MAXIMIZED_BOTH);
        // setLayout(null);
        // l1 = new JLabel("Select Hall");
        // Font font =  new Font("Arial",Font.BOLD,36);
        // l1.setFont(font);
        // l1.setBounds(10,30,2000,50);

        // b1 = new JButton("Wedding Hall");
        // b2 = new JButton("Conference Hall");

        // add(l1);
        // add(b1);
        // add(b2);

        // panel = new JPanel();
        // frame.add(panel);
        // panel.setLayout(new GridLayout(2,2));
        // panel.add(l1);
        // panel.add(b1);
        // panel.add(b2);


        setTitle("Hall Management 444 System");
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(null);
        Font font = new Font("Arial",Font.BOLD,40);
        L0 = new JLabel("Welcome to Hall 888 Management System");
        L0.setFont(font);
        L0.setBounds(10,30,2000,50);
        
        
        // l0 = new JLabel("Add Manager Details");
        l1 = new JLabel("Enter Customer Name:");
        l1.setBounds(100,100,130,40);
        t1 = new JTextField();
        t1.setBounds(250,100,140,40);
        l2 = new JLabel("Enter Customer Id:");
        l2.setBounds(100,200,120,40);
        t2 = new JTextField();
        t2.setBounds(250,200,140,40);
        l3 = new JLabel("Customer's Contact No:");
        l3.setBounds(100,300,140,40);
        t3 = new JTextField();
        t3.setBounds(250,300,140,40);
        b1 = new JButton("Enter");
        b1.setBounds(150,400,140,40);
        b2 = new JButton("Clear");
        b2.setBounds(300,400,140,40);
        add(L0);
        // add(l0);
        add(l1);add(t1);
        add(l2);add(t2);
        add(l3);add(t3);
        add(b1);
        add(b2);
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);
        
        //setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);




        // MyActionListener a = new MyActionListener();
        // b1.addActionListener(a);
        // b2.addActionListener(a);

        // setVisible(true);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    // public class MyActionListener implements ActionListener{
    //     public void actionPerformed(ActionEvent ae) {
    //         if(ae.getActionCommand().equals("Wedding Hall"))
    //         {

    //         }
    //         else if(ae.getActionCommand().equals("Conference Hall"))
    //         {

    //         }
    //     }    
    // }

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
                    JOptionPane.showMessageDialog(frame,"Changed");
                    dispose();
                    
                    Hallintermediateframe HIF = new Hallintermediateframe();
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
