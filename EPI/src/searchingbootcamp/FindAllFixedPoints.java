package searchingbootcamp;

import java.util.ArrayList;
import java.util.List;

public class FindAllFixedPoints {
    static void findAllFixedPoints(int[] arr, int left, int right, List<Integer> result) {
        if (left > right) return;

        int mid = left + (right - left) / 2;

        if (arr[mid] == mid) {
            result.add(mid);
        }
        findAllFixedPoints(arr, left, mid - 1, result); // Continue searching left
        findAllFixedPoints(arr, mid + 1, right, result); // Continue searching right
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 6, 6, 6, 6, 7};
        List<Integer> fixedPoints = new ArrayList<>();
        findAllFixedPoints(arr, 0, arr.length - 1, fixedPoints);

        if (!fixedPoints.isEmpty()) {
            System.out.println("Fixed Points found at indices: " + fixedPoints);
        } else {
            System.out.println("No Fixed Point found");
        }
    }
}
