package arraybootcamp;

public class Problem7BuyAndSellAStockTwice {

	public static void main(String[] args) {	
		double[] stockPrices = {12,11,13,9,12,8,14,13,15};
		System.out.println("Max profit : "+ buyAndSellStockTwice(stockPrices));
	}
	
	public static double buyAndSellStockTwice(double[] arr) {
		double[] firstBuySellProfits = new double[arr.length];
		double maxProfit = 0.0;
		double minPrice = Double.MAX_VALUE;
		// profit if we buy/sell only once
		for(int i=0; i<arr.length;i++) {
			minPrice = Math.min(minPrice, arr[i]);
			maxProfit = Math.max(maxProfit, arr[i]-minPrice);
			firstBuySellProfits[i] = maxProfit;
		}
		
		// after once we sell after that again we buy and sell
		
		double maxPrice = Double.MIN_VALUE;
		
		for(int i= arr.length -1 ; i>0 ;i--) {
			maxPrice = Math.max(maxPrice, arr[i]);
			maxProfit = Math.max(maxProfit, (maxPrice- arr[i]) + firstBuySellProfits[i-1]);
		}
		return maxProfit;
	}

}
