package leetcode.arrays_strings;

/**
 * @author gauravsardana
 * @since 05/02/25
 */
public class LC134_GasStation {
    public static void main(String[] args) {
        final int[] gas = { 0, 0, 0, 0, 15 };
        final int[] cost = { 3, 4, 5, 1, 2 };
        System.out.println(canCompleteCircuit(gas, cost));

    }

    private static int canCompleteCircuit(final int[] gas, final int[] cost) {
        int totalGain = 0, currGain = 0, answer = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGain += gas[i] - cost[i];
            currGain += gas[i] - cost[i];

            if (currGain < 0) {
                currGain = 0;
                answer = i + 1;
            }
        }
        return totalGain >= 0 ? answer : -1;
    }
}
