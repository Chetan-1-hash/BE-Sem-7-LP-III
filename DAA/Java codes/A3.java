import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Item {
    int weight;
    int value;
    double valuePerWeight;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.valuePerWeight = (double) value / weight;
    }
}

public class A3 {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(10, 60));
        items.add(new Item(20, 100));
        items.add(new Item(30, 120));

        int knapsackCapacity = 50;
        double maxValue = maximizeValue(items, knapsackCapacity);

        System.out.println("Maximum value: " + maxValue);
    }

    public static double maximizeValue(List<Item> items, int knapsackCapacity) {
        // Sort the items by valuePerWeight in descending order
        sortItemsByValuePerWeightDescending(items);

        double totalValue = 0.0;
        int remainingCapacity = knapsackCapacity;

        for (Item item : items) {
            if (item.weight <= remainingCapacity) {
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } 
            else {
                // Fraction of the item can be taken to fill the knapsack
                double fraction = (double) remainingCapacity / item.weight;
                totalValue += fraction * item.value;
                break; // Knapsack is full
            }
        }

        return totalValue;
    }

    public static void sortItemsByValuePerWeightDescending(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(i).valuePerWeight < items.get(j).valuePerWeight) {
                    Collections.swap(items, i, j);
                }
            }
        }
    }
}
