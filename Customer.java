import java.io.*;
public class Customer implements Serializable{
    private int customerId;
    private String name;
    private String contactNumber;

    public Customer(int customerId, String name, String contactNumber) {
        this.customerId = customerId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerName(String name) {
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

    public String toString()
    {
        return "Name: " + name + "\n" + "CustomerId: "+ customerId + "\n" +"ContactNo: "+ contactNumber;
    }
    
    public void display(){
        System.out.println("*************************");
        System.out.println("");
        System.out.println("Customer id : "+getCustomerId());
        System.out.println("Customer Name : "+getName());
        System.out.println("Customer Contact Number : "+getContactNumber());
        System.out.println("");
        System.out.println("Customer has been Added successfully . ");
        System.out.println("");
        System.out.println("*************************");
        System.out.println("");
    }
}