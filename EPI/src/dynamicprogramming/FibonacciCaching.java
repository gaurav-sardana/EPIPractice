package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciCaching {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fibo(6));
        System.out.println(fiboDP(6));
    }

    // with memoization
    public static int fibo(int n) {
        if (n <= 1) return n;

        if (!map.containsKey(n)) {
            map.put(n, fibo(n - 2) + fibo(n - 1));
        }

        return map.get(n);
    }

    public static int fiboDP(int n) {

        if (n <= 1) return n;

        int fMinus2 = 0;
        int fMinus1 = 1;
        for (int i = 2; i <= n; i++) {
            int sum = fMinus2 + fMinus1;
            fMinus2 = fMinus1;
            fMinus1 = sum;
        }
        return fMinus1;


    }


}
