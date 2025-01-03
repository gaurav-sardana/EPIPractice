package arraybootcamp;

public class Problem6BuyAndSellAStockOnce {
    public static void main(String[] args) {
        double[] arr = { 310, 315, 275, 295, 260, 270, 290, 230, 255, 350 };
        System.out.println("Maximum Profit : " + getMaxProfit(arr));
    }

    //selling price must be larger than buying price.
    // we need to find max(prices[j] = prices[i]) for every i & j where j>i
    public static double getMaxProfit(double[] arr) {
        double minValue = Double.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            maxProfit = Math.max(maxProfit, arr[i] - minValue);
            minValue = Math.min(arr[i], minValue);
        }
        return maxProfit;
    }
}
