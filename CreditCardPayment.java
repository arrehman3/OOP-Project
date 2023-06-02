import java.io.*;
import java.util.*;
public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void makePayment(double amount) {
        // Logic to process credit card payment
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("CVV: " + cvv);
        System.out.println("Payment successful!");
    }
}