package dynamicprogramming;

import java.util.*;

public class SearchForASequenceIn2DArray {

    public static void main(String[] args) {

        List<Integer> row1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<Integer> row2 = new ArrayList<Integer>(Arrays.asList(3, 4, 5));
        List<Integer> row3 = new ArrayList<Integer>(Arrays.asList(5, 6, 7));
        List<List<Integer>> grid = new ArrayList<List<Integer>>(Arrays.asList(row1, row2, row3));

        List<Integer> pattern = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 6));
        List<Integer> pattern2 = new ArrayList<Integer>(Arrays.asList(1, 3, 1, 3));
        System.out.println(searchASequence(grid, pattern));
        System.out.println(searchASequence(grid, pattern2));
    }

    public static boolean searchASequence(List<List<Integer>> grid, List<Integer> pattern) {
        List<Attempt> answer;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                answer = new LinkedList<>();
                if (isXYComputational(i, j, 0, pattern, grid, new HashSet<>(), answer)) {
                    System.out.println(answer);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isXYComputational(int x, int y, int offset, List<Integer> pattern, List<List<Integer>> grid, Set<Attempt> previousAttempts, List<Attempt> answer) {

        if (offset == pattern.size()) {
            return true;
        }

        if (x < 0 || y < 0 || x >= grid.size() || y >= grid.get(x).size() || previousAttempts.contains(new Attempt(x, y, offset)))
            return false;
        if (Objects.equals(grid.get(x).get(y), pattern.get(offset)) && (isXYComputational(x - 1, y, offset + 1, pattern, grid, previousAttempts, answer) || isXYComputational(x + 1, y, offset + 1, pattern, grid, previousAttempts, answer) || isXYComputational(x, y - 1, offset + 1, pattern, grid, previousAttempts, answer) || isXYComputational(x, y + 1, offset + 1, pattern, grid, previousAttempts, answer))) {
            answer.add(new Attempt(x, y, offset));
            return true;
        }
        previousAttempts.add(new Attempt(x, y, offset));
        return false;
    }
}

class Attempt {
    int x, y, offset;

    public Attempt(int x, int y, int offset) {
        this.x = x;
        this.y = y;
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "[" + this.x + "," + this.y + "," + this.offset + "]";
    }
}
