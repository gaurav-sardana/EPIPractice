package arraybootcamp;

import java.util.*;

/**
 * @author gauravsardana
 * @since 23/09/21
 */
public class QuickSort {
    public static int findMaximumProfit(List<String> category, List<Integer> price) {
        // Combine categories with prices
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < category.size(); i++) {
            items.add(new Item(category.get(i), price.get(i)));
        }

        // Sort items by price in descending order
        items.sort((a, b) -> a.price - b.price);

        // Track the number of unique categories sold
        Set<String> uniqueCategories = new HashSet<>();
        int totalProfit = 0;

        for (Item item : items) {
            // Add the category to the set of sold categories
            uniqueCategories.add(item.category);

            // Calculate the profit
            int profit = item.price * uniqueCategories.size();
            totalProfit += profit;
        }

        return totalProfit;
    }

    // Helper class to store item details
    static class Item {
        String category;
        int price;

        Item(String category, int price) {
            this.category = category;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        List<String> categories = Arrays.asList("3", "2", "2", "3");
        List<Integer> prices = Arrays.asList(2, 7, 3, 4);

        int result = findMaximumProfit(categories, prices);
        System.out.println("Total Profit: " + result);
    }

}
