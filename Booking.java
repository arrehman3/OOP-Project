import java.io.*;
import java.util.*;
public class Booking implements Serializable{
    // private int bookingId;
    private Hall hall;
    private Customer customer;
    private Manager manager;
    private ArrayList<String> availableDates;

    public Booking( Hall hall, Customer customer, Manager manager) {
        // this.bookingId = bookingId;
        this.hall = hall;
        this.customer = customer;
        this.manager = manager;
        this.availableDates = new ArrayList<>();
        initializeAvailableDates();
    }

    // public int getBookingId() {
    //     return bookingId;
    // }

    public Hall getHall() {
        return hall;
    }

    public Manager getManager() {
        return manager;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<String> getAvailableDates() {
        return availableDates;
    }

    public double calculateTotalRent() {
        return hall.calculateRent();
    }

    private void initializeAvailableDates() {
        // Add available dates
        availableDates.add("2023-05-19");
        availableDates.add("2023-05-20");
        availableDates.add("2023-05-21");
        // Add more dates as needed
    }

    public void bookEvent() {
        System.out.println("Available Dates:");
        for (int i = 0; i < availableDates.size(); i++) {
            String date = availableDates.get(i);
            System.out.println(" - " + date);
        }        

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the date for your event: ");
        String selectedDate = scanner.nextLine();

        if (availableDates.contains(selectedDate)) {
            System.out.println("Available Time Slots for " + selectedDate + ":");
            List<String> availableSlots = getAvailableSlots(selectedDate);
            for (int i = 0; i < availableSlots.size(); i++) {
                String slot = availableSlots.get(i);
                System.out.println("- " + slot);
            }            

            System.out.print("Enter the time slot for your event: ");
            String selectedSlot = scanner.nextLine();

            if (availableSlots.contains(selectedSlot)) {
                System.out.println("\n\n*************************");
                System.out.println("");
                //System.out.println("Booking id :" +getBookingId());
                System.out.println("Customer id :"+customer.getCustomerId());
                System.out.println("Customer Name :"+customer.getName());
                System.out.println("Customer Contact Number :"+customer.getContactNumber());
                System.out.println("Booking confirmed for Date : " + selectedDate);
                System.out.println("Booking confirmed for Time Slot : " + selectedSlot);
                System.out.println("");
                System.out.println("Time Slot Booked Successfully.");
                System.out.println("*************************\n\n");
                System.out.println("");
                //System.out.println("Booking confirmed for Date: " + selectedDate + ", Time Slot: " + selectedSlot);
                // Perform the necessary booking operations
            } else {
                System.out.println("Invalid time slot selected.");
            }
        } else {
            System.out.println("Invalid date selected.");
        }
    }

    private ArrayList<String> getAvailableSlots(String date) {

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

        // Add more logic to fetch slots based on your requirements

        return slots;
    }

    public void removetimeslot(String date,String slot)
    {
        List<String> temp = getAvailableSlots(date);
        if(temp.contains(slot))
        {
            temp.remove(slot);
            if(temp.isEmpty()){
                availableDates.remove(date);
            }
        }
    }
}
