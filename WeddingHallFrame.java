import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeddingHallFrame extends JFrame {
    private Manager M;
    private Customer C;
    //private Hallintermediateframe H;
    public JTextField t1,t2,t3;
    public JFrame frame;
    public JLabel backgroundimage,l0,l1,l2,l3,L0;
    public JButton b1,b2,b3;   
    public ImageIcon image;
    WeddingHallFrame(Manager M,Customer C)
    {
        this.M=M;
        this.C=C;
        setTitle("Hall Management System");
        setSize(800,600);
        setLayout(null);
        setResizable(false);
        try{
            image = new ImageIcon("wedding hall 1.0.jpeg");
        }
        catch(Exception e)
        {

        }
        Font font = new Font("Arial",Font.BOLD,40);
        L0 = new JLabel("Welcome to Wedding Hall");
        L0.setFont(font);
        L0.setBounds(10,30,2000,50);
        L0.setOpaque(true);
        
        // l0 = new JLabel("Add Manager Details");
        l1 = new JLabel("Enter Hall Name:");
        l1.setBounds(100,100,130,40);
        l1.setOpaque(true);
        t1 = new JTextField();
        t1.setBounds(250,100,140,40);
        l2 = new JLabel("Enter hall Id:");
        l2.setBounds(100,200,120,40);
        l2.setOpaque(true);
        t2 = new JTextField();
        t2.setBounds(250,200,140,40);
        l3 = new JLabel("No of Seats:");
        l3.setBounds(100,300,140,40);
        l3.setOpaque(true);
        t3 = new JTextField();
        // int temp = Integer.parseInt(t3.getText());
        // if (temp>2000) {
        //     JOptionPane.showMessageDialog(frame,"Capacity more than 2000");
        //     t3.setText("");
        //     JOptionPane.showMessageDialog(frame,"Fill it again");
        // }
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

        // int temp = Integer.parseInt(t3.getText());
        // if (temp>2000) {
        //     JOptionPane.showMessageDialog(frame,"Capacity more than 2000");
        //     t3.setText("");
        //     JOptionPane.showMessageDialog(frame,"Fill it again");
        // }
        
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
                //int temp = Integer.parseInt(t3.getText());
                if(t1.getText().equals("")|| t2.getText().equals("")||t3.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(frame,"Fill all Boxes");
                }
                else if(Integer.parseInt(t3.getText())>2000)
                {
                    JOptionPane.showMessageDialog(frame,"Capacity more than 2000");
                    t3.setText("");
                    JOptionPane.showMessageDialog(frame,"Fill it again");
                }


                else if(v.checkString(t1.getText()) && v.checkNumber(t2.getText()) && v.checkNumber(t3.getText()))
                {
                    String name = t1.getText() ;
                    int id = Integer.parseInt(t2.getText());
                    int seats = Integer.parseInt(t3.getText());
                    Hall H = new WeddingHall(id, name, seats, 2000);
                    //WeddingHall WH1 = new WeddingHall(id, name, seats, 2000);
                    dispose();
                    JOptionPane.showMessageDialog(frame,H.toString());
                    CateringSystemFrame CSF = new CateringSystemFrame(M,C,H);
                    // JOptionPane.showMessageDialog(frame,"Succesfull");
                    
                    // Hallintermediateframe HIF = new Hallintermediateframe();
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
