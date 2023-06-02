import java.io.*;
public class ConferenceHall extends Hall implements Serializable {
    private int capacity;

    public ConferenceHall(int hallId, String hallName, int NoOfSeats, int capacity) {
        super(hallId, hallName, NoOfSeats);
        this.capacity = capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCapacity() {
        return capacity;
    }

    public void checkcapacity(){
        if (getNoOfSeats()<getCapacity()) {
            display();
        }
        else{
            System.out.println("Sorry Maximum Capacity is 200 seats for conference. ");
        }
    }
    @Override
    public double calculateRent() {
        // Calculate rent based on capacity and number of seats
        double baseRent = getNoOfSeats() * 279;
        return baseRent ;
    }
    public void display(){
        System.out.println("*************************");
        System.out.println("");
        System.out.println("Conference Hall id : "+getHallId());
        System.out.println("Conference Hall Name : "+getHallName());
        System.out.println("Number of seats you are booking : "+getNoOfSeats());
        System.out.println("Hall total rent : "+calculateRent());
        System.out.println("");
        System.out.println("*************************");
        System.out.println("");
    }
}
