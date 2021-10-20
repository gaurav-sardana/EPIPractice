package recursion;

/**
 * @author gauravsardana
 * @since 21/10/21
 */
public class SumOfNNaturalNumbers {
    public static void main(String[] args) {
        System.out.println(sum(2));
    }

    // Better Option : Formula n(n+1)/2
    //Time : O(n)
    //Space : O(n)
    public static int sum(final int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);

        // return (n* (n+1))/2
    }
}

