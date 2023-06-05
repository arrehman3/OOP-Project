import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptFrame extends JFrame  {
    //public JTextField t1,t2,t3;
    private JFrame frame;
    private JLabel backgroundimage,l5,l6,l7,l8,l9,l10,l4,l1,l2,l3,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,L0;
    private JButton b1;
    private ImageIcon image; 
    private Customer C;
    private Manager M;
    private Hall H;
    private Booking B;
    private CateringSystem CS;  

    public ReceiptFrame(Manager M,Customer C,Hall H,Booking B,CateringSystem CS)
    {
        this.M = M;
        this.C = C;
        this.H = H;
        this.B = B;
        this.CS = CS;

        Receipt R = new Receipt(H, M, C, CS, B);
        //R.readFromFile();
        R.writeToFile();
        setTitle("Receipt");
        setSize(800,800);
        setLayout(null);
        setResizable(false);
        try{
            image = new ImageIcon("receipt3.jpg");
        }catch(Exception e)
        {
            System.out.println("receipt error");
        }
        Font font = new Font("Arial",Font.BOLD,40);
        L0 = new JLabel("Receipt");
        L0.setFont(font);
        L0.setBounds(10,30,2000,50);
        L0.setOpaque(true);
        //l0 = new JLabel("Add Manager Details");
        String s  = String.valueOf(R.getHall().getHallId());
        l1 = new JLabel("Hall id: ");
        l1.setBounds(100,100,130,40);
        l1.setOpaque(true);
        l2 = new JLabel(s);
        l2.setBounds(250,100,140,40);
        l2.setOpaque(true);
        l3 = new JLabel("Hall name:");
        l3.setBounds(100,150,120,40);
        l3.setOpaque(true);
        String s1 = (R.getHall().getHallName());
        l4 = new JLabel(s1);
        l4.setBounds(250,150,140,40);
        l4.setOpaque(true);
        l5 = new JLabel("Customer Id:");
        l5.setBounds(100,200,140,40);
        l5.setOpaque(true);
        String s2 = Integer.toString(R.getCustomer().getCustomerId());
        l6 = new JLabel(s2);
        l6.setBounds(250,200,140,40);
        l6.setOpaque(true);
        l7 = new JLabel("Customer Name: ");
        l7.setBounds(100,250,140,40);
        l7.setOpaque(true);
        l8 = new JLabel(R.getCustomer().getName());
        l8.setBounds(250,250,140,40);
        l8.setOpaque(true);
        l9 = new JLabel("Customer Contact No: ");
        l9.setBounds(100,300,140,40);
        l9.setOpaque(true);
        l10 = new JLabel(R.getCustomer().getContactNumber());
        l10.setBounds(250,300,140,40);
        l10.setOpaque(true);

        l11 = new JLabel("Manager Name: ");
        l11.setBounds(400,100,130,40);
        l11.setOpaque(true);
        l12 = new JLabel(R.getManager().getName());
        l12.setBounds(550,100,140,40);
        l12.setOpaque(true);
        l13 = new JLabel("No of Seats:");
        l13.setBounds(400,150,120,40);
        l13.setOpaque(true);
        String s02 = Integer.toString(R.getHall().getNoOfSeats());
        l14 = new JLabel(s02);
        l14.setBounds(550,150,140,40);
        l14.setOpaque(true);
        l15 = new JLabel("Hall Rent: ");
        l15.setBounds(400,200,140,40);
        l15.setOpaque(true);
        String s3 = Double.toString(R.getHall().calculateRent());
        l16 = new JLabel(s3);
        l16.setBounds(550,200,140,40);
        l16.setOpaque(true);
        l17 = new JLabel("Catering Price : ");
        l17.setBounds(400,250,140,40);
        l17.setOpaque(true);
        String s5 = Double.toString(R.getCateringSystem().getPricePerSeat());
        l18 = new JLabel(s5);
        l18.setBounds(550,250,140,40);
        l18.setOpaque(true);
        l19 = new JLabel("Total Price: ");
        l19.setBounds(400,300,140,40);
        l19.setOpaque(true);
        String s6 = Double.toString(R.getCateringSystem().getPricePerSeat()+R.getHall().calculateRent());
        l20 = new JLabel(s6);
        l20.setBounds(550,300,140,40);
        l20.setOpaque(true);

        b1 = new JButton("Proceed");
        b1.setBounds(300,400,140,40);
        backgroundimage = new JLabel(image);
        backgroundimage.setBounds(0,-20,getWidth(),getHeight());
        // b2 = new JButton("Clear");
        // b2.setBounds(300,400,140,40);
        add(L0);
        // add(l0);
        add(l1);add(l2);
        add(l3);add(l4);
        add(l5);add(l6);
        add(l7);add(l8);
        add(l9);add(l10);
        add(l11);add(l12);
        add(l13);add(l14);
        add(l15);add(l16);
        add(l17);add(l18);
        add(l19);add(l20);
        add(b1);
        add(backgroundimage);
        // add(b2);
        
        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        //b2.addActionListener(a);
        
        
        //setLayout(new BorderLayout());
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {

            validations v = new validations();

            if(ae.getActionCommand().equals("Proceed"))
            {
                // if(t1.getText().equals("")|| t2.getText().equals("")||t3.getText().equals(""))
                // {
                //     JOptionPane.showMessageDialog(frame,"Fill all Boxes");
                // }

                // else if (v.checkString(t1.getText()) && v.checkNumber(t2.getText()) && v.checkNumber(t3.getText())){
                //     if(t1.getText().equals("xyz") && t2.getText().equals("1122") && t3.getText().equals("03001234567"))
                //     {
                //         String name = t1.getText() ;
                //         int id = Integer.parseInt(t2.getText());
                //         String num = t3.getText();
                //         Manager M1 = new Manager(id, name, num);
                //         dispose();
                //         customerframe cf = new customerframe(M1);
                //     }
                //     else {
                //         JOptionPane.showMessageDialog(frame,"INVALID CRESIDENTIALS");
                //         JOptionPane.showMessageDialog(frame,"Enter Again");
                //         t1.setText(" ");
                //         t2.setText(" ");
                //         t3.setText(" ");
                //     }    
                    
                // }
                // else{
                //     JOptionPane.showMessageDialog(frame,"Inputs are incorrect");
                // }
                dispose();
                PaymentintermediateFrame PF = new PaymentintermediateFrame();
            }
            // else{
            //     t1.setText("");
            //     t2.setText("");
            //     t3.setText("");
            // }
        }
    }
}


