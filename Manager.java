import java.io.*;
public class Manager implements Serializable{
    private int managerId;
    private String name;
    private String contactNumber;

    public Manager(int managerId, String name, String contactNumber) {
        this.managerId = managerId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
    public int getManagerId() {
        return managerId;
    }

    public void setManagerName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setCustomercontact(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void display(){
        System.out.println("*************************");
        System.out.println("");
        System.out.println("Customer id : "+getManagerId());
        System.out.println("Customer Name : "+getName());
        System.out.println("Customer Contact Number : "+getContactNumber());
        System.out.println("");
        System.out.println("Customer has been Added successfully . ");
        System.out.println("");
        System.out.println("*************************");
        System.out.println("");
    }
}
