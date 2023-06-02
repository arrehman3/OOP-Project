import java.io.*;
import java.util.*;

public class CateringSystem implements Serializable{
    
    private List<String> foodItems;
    private double[] pricesPerSeat;

    public CateringSystem() {
        foodItems = new ArrayList<>();
        pricesPerSeat = new double[0];
    }

    public void setFoodItems(List<String> foodItems) {
        this.foodItems = foodItems;
    }
    public List<String> getFoodItems() {
        return foodItems;
    }
    
    public void setPricesPerSeat(double[] pricesPerSeat) {
        this.pricesPerSeat = pricesPerSeat;
    }
    public double[] getPricesPerSeat() {
        return pricesPerSeat;
    }
    
    public void addFoodItem(String[] itemName, double[] pricePerSeat) {
        foodItems.add(itemName);
        double[] newPricesPerSeat = new double[pricesPerSeat.length + 1];
        System.arraycopy(pricesPerSeat, 0, newPricesPerSeat, 0, pricesPerSeat.length);
        newPricesPerSeat[pricesPerSeat.length] = pricePerSeat;
        pricesPerSeat = newPricesPerSeat;
    }
    
    public double getPricePerSeat(String itemName) {
        int index = foodItems.indexOf(itemName);
        if (index != -1) {
            return pricesPerSeat[index];
        }
        return 0.0;
    }
}
