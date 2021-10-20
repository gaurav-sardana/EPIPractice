package recursion;

/**
 * @author gauravsardana
 * @since 21/10/21
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return factorial(n - 1) * n;
    }
}
