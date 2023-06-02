import java.io.*;
import java.util.*;

public class main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("\n    Wedding Hall Management System\n \n____________________________________\n \n **********************************\n____________________________________\n");
        WeddingHall weddingHall = null;
        ConferenceHall conferenceHall = null;
        Customer customer = null;
        Manager manager = null;
        CateringSystem cateringSystem = null;
        Booking booking = null;
        Receipt receipt = null;

        
        while (true) {
            System.out.println("Choose the following options:\n\n1 : Select Hall \n2 : Customer\n3 : Manager \n4 : Catering \n5 : Booking \n6 : Generate Receipt \n7 : Payment \n0 : Exit\n");
            System.out.println("--------------------------------------");
            //System.out.println();
            int option1 = scanner.nextInt();
            if (option1 == 1) {
                while (true) {
                    System.out.println("Choose the following options:\n1 : Wedding Hall \n2 : Conference Hall \n0 : Get Back to main menu");
                    int option2 = scanner.nextInt();
                    if (option2 == 1) {
                        System.out.println("Enter Hall id: ");
                        int hallId = scanner.nextInt();
                        System.out.print("Enter Hall name: ");
                        scanner.nextLine(); 
                        String hallName = scanner.nextLine();
                        System.out.println("Enter Number of seats you want in Hall: ");
                        int capacity = scanner.nextInt();
                        weddingHall = new WeddingHall(hallId, hallName, capacity, 2000);
                        
                        weddingHall.checkcapacity();
                        break;
                    } else if (option2 == 2) {
                        System.out.println("Enter Hall id: ");
                        int hallId = scanner.nextInt();
                        System.out.print("Enter Hall name: ");
                        scanner.nextLine(); 
                        String hallName = scanner.nextLine();
                        System.out.println("Enter Number of seats you want in Hall: ");
                        int capacity = scanner.nextInt();
                        conferenceHall = new ConferenceHall(hallId, hallName, capacity, 200);
                        
                        conferenceHall.checkcapacity();
                    }else if (option2 == 0) {
                        break;
                    }else {
                        System.out.println("Please choose correct option.");
                    }
                }
            }
            
             else if (option1 == 2) {
                System.out.println("Enter Customer id: ");
                int customerId = scanner.nextInt();
                System.out.print("Enter Customer name: ");
                scanner.nextLine();
                String customerName = scanner.nextLine();
                System.out.println("Enter Customer Mobile Number: ");
                String MobNum = scanner.nextLine();
                customer = new Customer(customerId, customerName, MobNum);
                customer.display();
            } else if (option1 == 3) {
                System.out.println("Enter Manager id: ");
                int ManagerId = scanner.nextInt();
                System.out.print("Enter Manager name: ");
                scanner.nextLine();
                String ManagerName = scanner.nextLine();
                System.out.println("Enter Manager Mobile Number: ");
                String MobNum = scanner.nextLine();
                manager = new Manager(ManagerId, ManagerName, MobNum);
                manager.display();
            }else if (option1 == 4) {
                cateringSystem = new CateringSystem();

                System.out.print("Enter the number of food items: ");
                int numberOfItems = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < numberOfItems; i++) {
                    System.out.print("Enter the name of food item " + (i + 1) + ": ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter the price of food item " + (i + 1) + " per seat: ");
                    double pricePerSeat = scanner.nextDouble();
                    scanner.nextLine();

                    cateringSystem.addFoodItem(itemName, pricePerSeat);
                }

                //System.out.print("Enter the number of seats: ");
                int numberOfSeats = weddingHall.getNoOfSeats();

                double totalPrice = 0.0;
                List<String> foodItems = cateringSystem.getFoodItems();
                for (int i = 0; i < foodItems.size(); i++) {
                    String itemName = foodItems.get(i);
                    double pricePerSeat = cateringSystem.getPricePerSeat(itemName);
                    double itemTotalPrice = pricePerSeat * numberOfSeats;
                    totalPrice += itemTotalPrice;
                    System.out.println(" \n\n");
                    System.out.println("Price for " + itemName + " per seat: " + pricePerSeat+"\n");
                    System.out.println("Total price for " + itemName + " for " + numberOfSeats + " seats: " + itemTotalPrice+"\n");
                }
                System.out.println("Price for all items for " + numberOfSeats + " seats: " + totalPrice);
                
            }else if (option1 == 5) {
                System.out.println("Choose the following options:\n1 : Booking for Wedding Hall \n2 : Booking for Conference Hall \n0 : Get Back to main menu");
                    int option2 = scanner.nextInt();
                    if (option2 == 1) {
                        if (weddingHall != null && customer != null && manager != null) {
                            System.out.println("Enter Booking id: ");
                            int bookingId = scanner.nextInt();
                            booking = new Booking(bookingId, weddingHall, customer, manager);
                            booking.bookEvent();
                            //System.out.println("Booked Succesfully");
                        }
                        else{
                            System.out.println("");
                            System.out.println("Please first fill the data of Manager and Customer");
                            System.out.println("");
                        }
                    } else if (option2 == 2) {
                        if (conferenceHall != null && customer != null && manager != null) {
                            System.out.println("Enter Booking id: ");
                            int bookingId = scanner.nextInt();
                            booking = new Booking(bookingId, conferenceHall, customer, manager);
                            booking.bookEvent();
                            //System.out.println("Booked Succesfully");
                        }
                        else{
                            System.out.println("");
                            System.out.println("Please first fill the data of Manager and Customer");
                            System.out.println("");
                        }
                    }else if (option2 == 0) {
                        break;
                    }else {
                        System.out.println("Please choose correct option.");
                    }
            }else if (option1 == 6) {
                System.out.println("Choose the following options:\n1 : Wedding Hall \n2 : Conference Hall \n0 : Get Back to main menu");
                    int option2 = scanner.nextInt();
                    if (option2 == 1) {
                        if (weddingHall != null && manager != null && customer != null && booking!=null) {
                            receipt = new Receipt(weddingHall , manager , customer , cateringSystem , booking );
                            receipt.displayReceipt();
                            // ObjectOutputStreamExample a1 = new ObjectOutputStreamExample();
                            // a1.writeToFile();
                            // a1.readFromFile();
                        }
                        else{
                            System.out.println("");
                            System.out.println("Please first fill the data of Manager and Customer");
                            System.out.println("");
                        }
                    } else if (option2 == 2) {
                        if (conferenceHall != null && manager != null && customer != null  && booking!=null) {
                            receipt = new Receipt(conferenceHall , manager , customer , cateringSystem , booking);
                            receipt.displayReceipt();
                            // ObjectOutputStreamExample a1 = new ObjectOutputStreamExample();
                            // a1.writeToFile();
                            // a1.readFromFile();
                        }
                        else{
                            System.out.println("");
                            System.out.println("Please first fill the data of Manager and Customer");
                            System.out.println("");
                        }
                    }else if (option2 == 0) {
                        break;
                    }else {
                        System.out.println("Please choose correct option.");
                    }
                    receipt.writeToFile();
                    receipt.readFromFile();

            }else if (option1 == 7) {
                System.out.println("Choose the payment method:");
                System.out.println("1: Credit Card");
                System.out.println("2: Cash");

                int paymentOption = scanner.nextInt();
                PaymentMethod paymentMethod;

                if (paymentOption == 1) {
                    // Credit card payment
                    System.out.println("Enter card number:");
                    String cardNumber = scanner.next();
                    System.out.println("Enter expiry date:");
                    String expiryDate = scanner.next();
                    System.out.println("Enter CVV:");
                    String cvv = scanner.next();

                    paymentMethod = new CreditCardPayment(cardNumber, expiryDate, cvv);
                } else if (paymentOption == 2) {
                    // Cash payment
                    paymentMethod = new CashPayment();
                } else {
                    System.out.println("Invalid payment option. Please try again.");
                    continue;
                }
                
                if (booking != null ) {
                    double totalRent = booking.calculateTotalRent();
                    paymentMethod.makePayment(totalRent);
                    break;
                }
                else{
                    System.out.println("");
                    System.out.println("Please first you have to Booked the Hall ");
                    System.out.println("");
                }
            }else if (option1 == 0) {
                break;
            } else {
                System.out.println("Please choose correct option.");
             }
        }
    }    
}
