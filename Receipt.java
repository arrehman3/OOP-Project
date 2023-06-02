import java.io.*;
import java.util.*;
public class Receipt implements Serializable{
    private Hall hall;
    private Customer customer;
    private Manager manager;
    private CateringSystem cateringSystem;
    private Booking booking;
    //private List<CateringItem> foodItems;
    private String receipt;
    

    public Receipt( Hall hall, Manager manager, Customer customer,CateringSystem cateringSystem , Booking booking) {
        this.hall = hall;
        this.manager = manager;
        this.customer = customer;
        this.cateringSystem = cateringSystem;
        this.booking = booking;
    }

    public void displayReceipt() {
        System.out.println("\n\n*************** Receipt ***************\n");
        System.out.println("\nBooking id : " + booking.getBookingId()+" \n");
        System.out.println("\nCustomer id : " + customer.getCustomerId());
        System.out.println("Customer Name : " + customer.getName());
        System.out.println("Customer Contact Number : " + customer.getContactNumber()+" \n");
        System.out.println("\nManager id : " + manager.getManagerId());
        System.out.println("Manager Name : " + manager.getName());
        System.out.println("Manager Contact Number : " + manager.getContactNumber()+" \n");
        
        System.out.println("\nHall id : " + hall.getHallId());
        System.out.println("Hall Type : " + hall.getHallName());
        System.out.println("Seats for booking : " + hall.getNoOfSeats());
        System.out.println("Amount without cattering : "+hall.calculateRent());

        System.out.println("Food Items with Prices :: ");
    
        double CatteringPrice = 0.0; 
        for (int i = 0; i < cateringSystem.getFoodItems().size(); i++) {
            String itemName = cateringSystem.getFoodItems().get(i);
            double price = cateringSystem.getPricePerSeat(itemName);
            double itemTotalPrice = price * hall.getNoOfSeats();
            CatteringPrice += itemTotalPrice;
            System.out.println(" - "+i + " Item Name : " + itemName + "\n    Item Price   $ : " + price);
        }

        System.out.println("\nTotal Amount of Cattering : " + CatteringPrice +"\n");
        System.out.println("Total Rent of Hall : "+hall.calculateRent()+"\n");
        double total = CatteringPrice + hall.calculateRent();
        System.out.println("\nTotal Amount of Booking id : "+booking.getBookingId()+" is " + total +"\n");
        System.out.println("-----------------------------------------");
    }
    public void writeToFile() {
        try {
            File file = new File("filename.txt");
            boolean isNewFile = false;

            if (!file.exists()) {
                isNewFile = file.createNewFile();
            }

            if (isNewFile) {
                System.out.println("New file created: " + file.getName());
            }

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            Receipt receipt = new Receipt(hall , manager , customer , cateringSystem , booking );
            objectOutputStream.writeObject(receipt);
            objectOutputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void readFromFile() {
        try {
            File file = new File("filename.txt");
            if (file.exists()) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                Receipt receipt = (Receipt) objectInputStream.readObject();
                objectInputStream.close();

                //System.out.println("Receipt Data: " + receipt);
            } else {
                System.out.println("File does not exist.");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public String getReceiptData() {
        return receipt;
    }

    public void setReceiptData(String receipt) {
        this.receipt = receipt;
    }
}