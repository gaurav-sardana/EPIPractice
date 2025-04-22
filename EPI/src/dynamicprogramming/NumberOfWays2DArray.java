package dynamicprogramming;

public class NumberOfWays2DArray {


    public static void main(String[] args) {
        int[][] dp = new int[5 + 1][2 + 1];
        System.out.println(bino(5, 2, dp));
    }

    public static int bino(int n, int k, int[][] dp) {
        if (k == 0 || k == n) return 1;

        if (dp[n][k] == 0) {
            int a = bino(n - 1, k, dp);
            int b = bino(n - 1, k - 1, dp);
            dp[n][k] = a + b;
        }
        return dp[n][k];
    }
}
