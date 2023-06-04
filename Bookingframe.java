import javax.swing.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.util.ArrayList;

public class Bookingframe extends JFrame {
    private Manager M;
    private Customer C;
    private Hall H;
    private CateringSystem CS;

    private JComboBox<String> timeSlotComboBox;
    private ArrayList<String> datesAndTimeSlots;
    //private ArrayList<String> AvailabeTimeSlot;
    private JButton button;

    public Bookingframe(Manager M,Customer C,Hall H,CateringSystem CS)  {
        this.M=M;
        this.C=C;
        this.H=H;
        this.CS=CS;
        
        setVisible(true);
        
        Booking B = new Booking(H,C,M);
        datesAndTimeSlots = B.getAvailableDates();
        
        JLabel dateLabel = new JLabel("Select a date:");
        
        JComboBox<String> datePicker = new JComboBox<>(datesAndTimeSlots.toArray(new String[0]));
        datePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String selectedDate = (String) datePicker.getSelectedItem();
                String selsectedTime = (String) timeSlotComboBox.getSelectedItem();

                
                ArrayList<String> availableTimeSlots = searchTimeSlots(selectedDate);

                
                updateComboBoxOptions(availableTimeSlots);
                
                int selsectedIndex = timeSlotComboBox.getSelectedIndex();

                if(selsectedIndex!=1)
                {
                    timeSlotComboBox.removeItemAt(selsectedIndex);
                }
                
            }
        });

        
        
        MyActionListener a = new MyActionListener();
            
        
        
        

        button = new JButton("Enter");

        button.addActionListener(a);

        timeSlotComboBox = new JComboBox<>();

        // Create the main GUI layout
        JPanel panel = new JPanel();
        panel.add(dateLabel);
        panel.add(datePicker);
        panel.add(timeSlotComboBox);
        panel.add(button);

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Time Slot Management System");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(panel);
    }

    
    private ArrayList<String> searchTimeSlots(String date) {

        ArrayList<String> slots = new ArrayList<>();

        if (date.equals("2023-05-19")) {
            slots.add("10:00 AM - 12:00 PM");
            slots.add("1:00 PM - 3:00 PM");
            slots.add("4:00 PM - 6:00 PM");
            slots.add("7:00 PM - 10:00 PM");
        } else if (date.equals("2023-05-20")) {
            slots.add("2:00 PM - 4:00 PM");
            slots.add("4:00 PM - 6:00 PM");
            slots.add("7:00 PM - 10:00 PM");
        } else if (date.equals("2023-05-21")) {
            slots.add("11:00 AM - 1:00 PM");
            slots.add("3:00 PM - 5:00 PM");
            slots.add("7:00 PM - 10:00 PM");
        }

        

        return slots;
    }


    private void updateComboBoxOptions(ArrayList<String> timeSlots) {
        timeSlotComboBox.removeAllItems();
        for (String timeSlot : timeSlots) {
            timeSlotComboBox.addItem(timeSlot);
        }
    }

    

        public class MyActionListener implements ActionListener{
            public void actionPerformed (ActionEvent ae)
            {
                if(ae.getActionCommand().equals("Enter"))
                {
                    Booking B = new Booking(H,C,M);
                    //Receipt R = new Receipt(H, M, C, CS, B);
                    ReceiptFrame RF = new ReceiptFrame(M,C,H,B,CS);
                }
            }
        }
    
}

