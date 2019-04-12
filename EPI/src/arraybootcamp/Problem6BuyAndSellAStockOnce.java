package arraybootcamp;import javax.swing.text.html.MinimalHTMLWriter;

public class Problem6BuyAndSellAStockOnce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	double[] arr=	{310,315,275,295,260,270,290,230,255,350};
	System.out.println("Maximum Profit : "+getMaxProfit(arr));
	}

	public static double getMaxProfit(double[] arr) {
		double minValue = Double.MAX_VALUE,maxProfit = 0;
		for(int i=0;i<arr.length;i++) {
			maxProfit = Math.max(maxProfit, arr[i]-minValue);
			minValue = Math.min(arr[i], minValue);
		}
		return maxProfit;
	}
}
