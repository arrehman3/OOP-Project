import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CateringSystemConferenceframe extends JFrame {
    private Manager M;
    private Customer C;
    private Hall H;
    
    public JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    public JFrame frame;
    public JLabel backgroundimage,l0,l1,l2,l3,L0,l4,l5,l6,l7,l8,l9,l10;
    public JButton b1,b2,b3; 
    public ImageIcon image;  

    CateringSystemConferenceframe(Manager M,Customer C,Hall H)
    {
        // System.out.println("33333333333333333333333333333333333333333");
        setTitle("Hall Management System");
        setSize(800,700);
        setLayout(null);
        try{
            image = new ImageIcon("C:/Users/Pc/Pictures/cateringsystem1.1.jpeg"); 
        }catch(Exception e)
        {
            System.out.println("Catering image issue");
        }
        Font font = new Font("Arial",Font.BOLD,40);
        L0 = new JLabel("Welcome to Catering Arrangements");
        L0.setFont(font);
        L0.setBounds(10,30,2000,50);
        L0.setOpaque(true);
        // l0 = new JLabel("Add Manager Details");
        l1 = new JLabel("Enter Dish 1 :");
        l1.setBounds(100,100,130,40);
        l1.setOpaque(true);
        t1 = new JTextField();
        t1.setBounds(250,100,140,40);
        l2 = new JLabel("Enter Dish 1 Price:");
        l2.setBounds(100,150,120,40);
        l2.setOpaque(true);
        t2 = new JTextField();
        t2.setBounds(250,150,140,40);
        l3 = new JLabel("Enter Dish 2:");
        l3.setBounds(100,200,140,40);
        l3.setOpaque(true);
        t3 = new JTextField();
        // int temp = Integer.parseInt(t3.getText());
        // if (temp>2000) {
        //     JOptionPane.showMessageDialog(frame,"Capacity more than 2000");
        //     t3.setText("");
        //     JOptionPane.showMessageDialog(frame,"Fill it again");
        // }
        t3.setBounds(250,200,140,40);
        l4 = new JLabel("Enter Dish 2 Price:");
        l4.setBounds(100,250,140,40);
        l4.setOpaque(true);
        t4 = new JTextField();
        t4.setBounds(250,250,140,40);
        l5 = new JLabel("Enter Dish 3");
        l5.setBounds(100,300,140,40);
        l5.setOpaque(false);
        t5 = new JTextField();
        t5.setBounds(250,300,140,40);
        l6 = new JLabel("Enter Dish 3 Price :");
        l6.setBounds(100, 350, 140,40);
        l6.setOpaque(false);
        t6 = new JTextField();
        t6.setBounds(250,350,140,40);
        l7 = new JLabel("Enter Dish 4 :");
        l7.setBounds(100,400,140,40);
        l7.setOpaque(false);
        t7 = new JTextField();
        t7.setBounds(250,400,140,40);
        l8 = new JLabel("Enter Dish 4 Price :");
        l8.setBounds(100,450,140,40);
        l8.setOpaque(false);
        t8 = new JTextField();
        t8.setBounds(250,450,140,40);
        l9 = new JLabel("Enter Dish 5 :");
        l9.setBounds(100,500,140,40);
        l9.setOpaque(false);
        t9 = new JTextField();
        t9.setBounds(250,500,140,40);
        l10 = new JLabel("Enter Dish 5 Price :");
        l10.setBounds(100,550,140,40);
        l10.setOpaque(false);
        t10 = new JTextField();
        t10.setBounds(250,550,140,40);
        b1 = new JButton("Enter");
        b1.setBounds(150,600,140,40);
        b2 = new JButton("Clear");
        b2.setBounds(300,600,140,40);
        backgroundimage = new JLabel(image);
        backgroundimage.setBounds(0,-20,getWidth(),getHeight());
        add(L0);
        // add(l0);
        add(l1);add(t1);
        add(l2);add(t2);
        add(l3);add(t3);
        add(l4);add(t4);
        add(l5);add(t5);
        add(l6);add(t6);
        add(l7);add(t7);
        add(l8);add(t8);
        add(l9);add(t9);
        add(l10);add(t10);
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
                // int temp = Integer.parseInt(t3.getText());
                if(t1.getText().equals("")|| t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||t6.getText().equals("")||t7.getText().equals("")||t8.getText().equals("")||t9.getText().equals("")||t10.getText().equals(" "))
                {
                    JOptionPane.showMessageDialog(frame,"Fill all Boxes");
                }
                // else if(temp>200)
                // {
                //     JOptionPane.showMessageDialog(frame,"Capacity more than 200");
                //     t3.setText("");
                //     JOptionPane.showMessageDialog(frame,"Fill it again");
                // }


                else if(v.checkString(t1.getText()) && v.checkNumber(t2.getText()) && v.checkString(t3.getText()) && v.checkNumber(t4.getText()) && v.checkString(t5.getText()) && v.checkNumber(t6.getText()) && v.checkString(t7.getText()) && v.checkNumber(t8.getText()) && v.checkString(t9.getText()) && v.checkNumber(t10.getText()))
                {
                    String [] nameArray = new String[5];
                    double [] priceArray = new double[5];
                    nameArray[0] = t1.getText() ;
                    priceArray[0]=Double.parseDouble(t2.getText());
                    nameArray[1] = t3.getText() ;
                    priceArray[1]=Double.parseDouble(t4.getText());
                    nameArray[2] = t5.getText() ;
                    priceArray[2]=Double.parseDouble(t6.getText());
                    nameArray[3] = t7.getText() ;
                    priceArray[3]=Double.parseDouble(t8.getText());
                    nameArray[4] = t9.getText() ;
                    priceArray[4]=Double.parseDouble(t10.getText());
                    CateringSystem CS = new CateringSystem();
                    CS.addFoodItem(nameArray, priceArray);
                    //ConferenceHall CH = new ConferenceHall(id, name, seats, 200);
                    dispose();
                    JOptionPane.showMessageDialog(frame,CS.toString());
                    CBookingframe Cbf = new CBookingframe();
                    // CateringSystemFrame CSF = new CateringSystemFrame();
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
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
                
            }
        }
    }


}

