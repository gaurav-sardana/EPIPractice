package leetcode;

import java.util.*;

public class LC_CountPathsPalindromeInTree {

    public static void main(String[] args) {

        long countPalindromePaths = countPalindromePaths(List.of(-1, 0, 0, 1, 1, 2), "acaabc");
//        long countPalindromePathsOptimised = countPalindromePathsOptimised(List.of(-1, 0, 0, 1, 1, 2), "acaabc");
        System.out.println(countPalindromePaths);
//        System.out.println(countPalindromePathsOptimised);

    }

    public static long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();

        // Build adjacency list
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) children.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            children.get(parent.get(i)).add(i);
        }

        // BFS to compute mask for every node
        int[] mask = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int child : children.get(node)) {
                int bit = 1 << (s.charAt(child) - 'a');
                mask[child] = mask[node] ^ bit;
                queue.offer(child);
            }
        }

        // Check all pairs — O(n²)
        long count = 0;
        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                int xor = mask[u] ^ mask[v];
                // Palindrome if xor == 0 OR xor is a power of 2
                if (xor == 0 || (xor & (xor - 1)) == 0) {
                    count++;
                }

            }
        }
        return count;
    }


    public static long countPalindromePathsOptimised(List<Integer> parent, String s) {
        int n = parent.size();

        // Build adjacency list
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) children.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            children.get(parent.get(i)).add(i);
        }

        // BFS to compute masks and get processing order
        int[] mask = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int child : children.get(node)) {
                int bit = 1 << (s.charAt(child) - 'a');
                mask[child] = mask[node] ^ bit;
                queue.offer(child);
            }
        }

        // Count pairs using a running frequency map
        // Key: mask value, Value: how many nodes seen so far have this mask
        Map<Integer, Integer> counter = new HashMap<>();
        long result = 0;

        for (int node : order) {
            int m = mask[node];

            // Case 1: XOR = 0 → exact match (all chars even frequency)
            result += counter.getOrDefault(m, 0);

            // Case 2: XOR = (1 << i) → exactly one char has odd frequency
            for (int i = 0; i < 26; i++) {
                result += counter.getOrDefault(m ^ (1 << i), 0);
            }

            // Add current mask to counter for future nodes to match against
            counter.merge(m, 1, Integer::sum);
        }

        return result;
    }

}
