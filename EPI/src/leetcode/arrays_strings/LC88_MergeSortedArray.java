package leetcode.arrays_strings;

import java.util.Arrays;

/**
 * @author gauravsardana
 * @since 09/11/24
 */

// Problem debug :
// 1. Both the arrays are sorted ,
// 2.  both have fixed number of elements,

public class LC88_MergeSortedArray {
    public static void main(String[] args) {
        final int[] array1 = { 1, 2, 3, 0, 0, 0 };
        final int[] array2 = { 2, 5, 6 };
        //        merge(array1, 3, array2, 3);
        //        System.out.println("Brute Force with Quick Sort : " + Arrays.toString(array1));
        //        merge2(array1, 3, array2, 3);
        //        System.out.println("Two Pointers Approach : " + Arrays.toString(array1));
        merge3(array1, 3, array2, 3);
        System.out.println("Three Pointers Approach : " + Arrays.toString(array1));

    }

    // Brute Force with Quick Sort
    // time complexity : O((m+n)log(m+n))
    // space complexity : O(n)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    //Two Pointers Approach with linear Time
    // time complexity : O(m+n)
    // space complexity : O(m)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        //        Step 1 : copy array of nums1 to nums2Copy - nums1 will just act as dummy array to populate the values in order.
        //        This is because the elements of array nums1 have to be stored somewhere so that they aren't overwritten.
        final int[] num1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            num1Copy[i] = nums1[i];
        }

        //Step 3 :// Read pointers for nums1Copy and nums2 respectively.
        int p0 = 0;
        int p1 = 0;

        //Step 2 :
        // Compare elements from nums1Copy and nums2 and write the smallest to nums1.
        // require write pointer
        // * cases to handle :
        //  1. num1 has no elements, all of num2 should be allocated to num1
        //  2. num2 has no elements or num2 has been explored completely(p1==n)  (p1 >= n)

        for (int i = 0; i < m + n; i++) {
            if (p1 >= n || p0 < m && num1Copy[p0] < nums2[p1]) { //here  p1 >= n is required before to make sure out of bounds shouldn't occur, hence else needs to be ignore
                nums1[i] = num1Copy[p0++];
            } else {
                nums1[i] = nums2[p1++];
            }
        }

    }

    //Three Pointers Approach
    // time complexity : O(m+n)
    // space complexity : O(1)

    // Tip : Whenever you're trying to solve an array problem in place, always consider the possibility of iterating backwards instead of forwards through the array. It can completely change the problem, and make it a lot easier.
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {

        int p0 = m - 1;
        int p1 = n - 1;

        for (int i = (m + n) - 1; i >= 0; i--) {
            if (p1 < 0) {
                break;
            }
            if (p0 >= 0 && nums1[p0] > nums2[p1]) {
                nums1[i] = nums1[p0--];
            } else {
                nums1[i] = nums2[p1--];
            }
        }

    }
}
