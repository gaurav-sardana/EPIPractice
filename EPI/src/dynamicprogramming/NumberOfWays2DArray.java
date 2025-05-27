package dynamicprogramming;

public class NumberOfWays2DArray {


    public static void main(String[] args) {
        int[][] dp = new int[5 + 1][2 + 1];
        long[][] dp2 = new long[18 + 1][18 + 1];
        System.out.println(bino(5, 2, dp));
        System.out.println(bin2o(18, 18, dp2));
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

    public static long bin2o(int n, int k, long[][] dp) {
        if (dp[n][k] != 0) return dp[n][k];
        if (k == 0 || n == 0) return 0;
        if (k == 1 && n == 1) return 1;

        if (dp[n][k] == 0) {
            dp[n][k] = bin2o(n - 1, k, dp) + bin2o(n, k - 1, dp);
        }
        return dp[n][k];
    }
}
