import java.io.*;
import java.util.*;
public class CashPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        // Logic to process cash payment
        System.out.println("Collect cash payment of $" + amount);
        System.out.println("Payment successful!");
    }
}
