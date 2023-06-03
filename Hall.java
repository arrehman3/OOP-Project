import java.io.*;
public abstract class Hall implements Serializable{
    private int hallId;
    private String hallName;
    private int NoOfSeats;
    private boolean availability;

    public Hall(int hallId, String hallName, int NoOfSeats) {
        this.hallId = hallId;
        this.hallName = hallName;
        this.NoOfSeats = NoOfSeats;
        this.availability = true;
    }

    public void setHallId(int HallId) {
        this.hallId = hallId;
    }
    public int getHallId() {
        return hallId;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
    public String getHallName() {
        return hallName;
    }

    public void setNoOfSeats(int NoOfSeats) {
        this.NoOfSeats = NoOfSeats;
    }
    public int getNoOfSeats() {
        return NoOfSeats;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String toString()
    {
        return "Hall Name: "+hallName +"\n"+"Hall id: "+hallId+"\n"+"No. of Seats: "+NoOfSeats;
    }

    // Abstract method for calculating hall rent
    public abstract double calculateRent();
}
