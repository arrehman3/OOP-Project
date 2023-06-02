import java.io.*;
class WeddingHall extends Hall implements Serializable{
    private int capacity;

    public WeddingHall(int hallId, String hallName, int NoOfSeats, int capacity) {
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
            System.out.println("Sorry Maximum Capacity is 2000 seats for wedding. ");
        }
    }
    @Override
    public double calculateRent() {
        // Calculate rent based on capacity and decoration cost
        double baseRent = getNoOfSeats() * 568;
        return baseRent;
    }
    public void display(){
        System.out.println("*************************");
        System.out.println("");
        System.out.println("Wedding Hall id : "+getHallId());
        System.out.println("Wedding Hall Name : "+getHallName());
        System.out.println("Number of seats you are booking : "+getNoOfSeats());
        System.out.println("Hall total rent : "+calculateRent());
        System.out.println("");
        System.out.println("*************************");
        System.out.println("");
    }
}
