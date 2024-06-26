import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.Book;

public class ConferenceHallFrame extends JFrame {
    private Manager M;
    private Customer C;
    
    //private Hallintermediateframe H;
    private JTextField t1,t2,t3;
    private JFrame frame;
    private JLabel backgroundimage,l0,l1,l2,l3,L0;
    private JButton b1,b2,b3; 
    private ImageIcon image;  

    ConferenceHallFrame(Manager M,Customer C)
    {
        this.M=M;
        this.C=C;
        // System.out.println("33333333333333333333333333333333333333333");
        setTitle("Hall Management System");
        setSize(800,600);
        setLayout(null);
        setResizable(false);
        try{
            image = new ImageIcon("conference 1.2.jpg");  
        }
        catch(Exception e)
        {
            System.out.println("conference hall error");
        }
        Font font = new Font("Arial",Font.BOLD,40);
        L0 = new JLabel("Welcome to Conference Hall");
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
        backgroundimage.setBounds(0,-20,this.getWidth(),this.getHeight());

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
                int temp = Integer.parseInt(t3.getText());
                if(t1.getText().equals("")|| t2.getText().equals("")||t3.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(frame,"Fill all Boxes");
                }
                else if(temp>200)
                {
                    JOptionPane.showMessageDialog(frame,"Capacity more than 200");
                    t3.setText("");
                    JOptionPane.showMessageDialog(frame,"Fill it again");
                }


                else if(v.checkString(t1.getText()) && v.checkNumber(t2.getText()) && v.checkNumber(t3.getText()))
                {
                    String name = t1.getText() ;
                    int id = Integer.parseInt(t2.getText());
                    int seats = Integer.parseInt(t3.getText());
                    Hall H = new ConferenceHall(id, name, seats, 200);
                    //ConferenceHall CH = new ConferenceHall(id, name, seats, 200);
                    dispose();
                    JOptionPane.showMessageDialog(frame,H.toString());
                    CateringSystemFrame CS = new CateringSystemFrame(M,C,H);
                    //CateringSystemConferenceframe CSF = new CateringSystemConferenceframe(M,C,H);
                    //JOptionPane.showMessageDialog(frame,"Succesfull");
                    
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

