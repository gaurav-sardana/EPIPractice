package graphs;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MinSteps {
    private static final Pattern RUNTIME =
            Pattern.compile("\\((\\d{4})\\s*(?:([-\u2013])\\s*(\\d{4})?\\s*)?\\)");

    public static void main(String[] args) {
//        System.out.println(bfs(10,1,10, 2, 1));

        System.out.println(Arrays.toString(parseRuntime("(2018)")));
    }

    static int[] parseRuntime(String s) {
        if (s == null) return null;
        Matcher m = RUNTIME.matcher(s);
        if (!m.find()) return null;                 // no valid year -> ignore

        int start = Integer.parseInt(m.group(1));
        int end;
        if (m.group(2) == null)        end = start;                       // (2019)
        else if (m.group(3) == null)   end = -1;                          // (2019- )  ongoing
        else                           end = Integer.parseInt(m.group(3));// (2019-2020)
        return new int[]{ start, end };
    }

    public static int bfs(int total, int start, int target, int forSteps, int backSteps) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{start, 0});
        visited.add(start);
        while (!queue.isEmpty()) {
            Integer[] curr = queue.poll();
            if (curr[0] == target) return curr[1];

            for (int next : new int[]{curr[0] + forSteps, curr[0] - backSteps}) {

                if (next <= total && next >= start && !visited.contains(next)) {
                    visited.add(next);
                    queue.offer(new Integer[]{next, curr[1] + 1});
                }
            }
        }
        return -1;


    }
}
