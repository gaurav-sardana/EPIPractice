package recursion;

/**
 * @author gauravsardana
 * @since 21/10/21
 */
public class Power {
    //m^n
    public static void main(String[] args) {
        System.out.println(pow(2, 5));
        System.out.println(pow2(2, 5));
        System.out.println(powLoop(2, 3));
    }

    private static int pow(int m, int n) {
        if (n == 0) {
            return 1;
        }
        return pow(m, n - 1) * m;
    }

    private static int pow2(int m, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return pow2(m * m, n / 2);
        } else {
            return m * pow2(m * m, (n - 1) / 2);
        }
    }

    private static int powLoop(int m, int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= m;
        }
        return result;
    }
}
