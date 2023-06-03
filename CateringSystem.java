import java.io.*;
import java.util.*;

public class CateringSystem implements Serializable{
    
    private String[] foodItems;
    private double[] pricesPerItem;

    public CateringSystem() {
        foodItems = new String[5];
        pricesPerItem = new double[5];
    }

    public void setFoodItems(String[] foodItems) {
        this.foodItems = foodItems;
    }
    public String[] getFoodItems() {
        return foodItems;
    }
    
    public void setPricesPerSeat(double[] pricesPerSeat) {
        this.pricesPerItem = pricesPerSeat;
    }
    public double[] getPricesPerSeat() {
        return pricesPerItem;
    }
    public void addFoodItem(String[] itemName, double[] pricePerDish) {
        foodItems=itemName;
        pricesPerItem=pricePerDish;

        // double[] newPricesPerSeat = new double[pricesPerSeat.length + 1];
        // System.arraycopy(pricesPerSeat, 0, newPricesPerSeat, 0, pricesPerSeat.length);
        // newPricesPerSeat[pricesPerSeat.length] = pricePerSeat;
        // pricesPerSeat = newPricesPerSeat;
    }
    
    public double getPricePerSeat() {
        double total = 0.0;
        for(double i : pricesPerItem )
        {
            total += i;
        }
        return total;
    }

    public String toString()
    {
        return "Dish1:"+foodItems[0]+"\n"+"Price: "+pricesPerItem[0]+"\n"+"Dish2:"+foodItems[1]+"\n"+"Price: "+pricesPerItem[1]+"\n"+"Dish3:"+foodItems[2]+"\n"+"Price: "+pricesPerItem[2]+"\n"+"Dish4:"+foodItems[3]+"\n"+"Price: "+pricesPerItem[3]+"\n"+"Dish5:"+foodItems[4]+"\n"+"Price: "+pricesPerItem[4];
    }

}
