package arraybootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem3MultiplyTwoArbitaryPrecisionIntegers {
    public static void main(String[] args) {
        Integer[] arr1 = { 1, 9, 3, 7, 0, 7, 7, 2, 1 };
        Integer[] arr2 = { -7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7 };
        //if int a = 010 java considers it as octal value of 8 as number starts with 0.
        List<Integer> row1 = new ArrayList<Integer>(Arrays.asList(arr1));
        List<Integer> row2 = new ArrayList<Integer>(Arrays.asList(arr2));
        List<Integer> multiplied = multiply(row1, row2);
        Problem2IncreaseInArbitaryPrecisionInteger.printList(multiplied);
    }

    public static List<Integer> multiply(List<Integer> arr1, List<Integer> arr2) {

        final int sign = arr1.get(0) < 0 ^ arr2.get(0) < 0 ? -1 : 1;
        arr1.set(0, Math.abs(arr1.get(0)));
        arr2.set(0, Math.abs(arr2.get(0)));

        List<Integer> multipledData = new ArrayList<Integer>(Collections.nCopies(arr1.size() + arr2.size(), 0));

        for (int i = arr1.size() - 1; i >= 0; i--) {
            for (int j = arr2.size() - 1; j >= 0; j--) {
                multipledData.set(i + j + 1, multipledData.get(i + j + 1) + (arr1.get(i) * arr2.get(j)));
                multipledData.set(i + j, multipledData.get(i + j) + multipledData.get(i + j + 1) / 10);
                multipledData.set(i + j + 1, multipledData.get(i + j + 1) % 10);
            }
        }
        //remove trailing zeroes
        int nonZeroElemnt = 0;
        while (nonZeroElemnt > multipledData.size() && multipledData.get(nonZeroElemnt) == 0) {
            nonZeroElemnt++;
        }
        multipledData = multipledData.subList(nonZeroElemnt, multipledData.size());
        if (multipledData.isEmpty()) {
            return Arrays.asList(0);
        }
        multipledData.set(0, multipledData.get(0) * sign);
        return multipledData;
    }

    //	There are m partial products, each with at most n + 1 digits. We perform 0(1) operationsoneachdigit in each partialproduct,so the timecomplexityis0(nm).

    //	public static long[] multiply(long[] arr1, long[] arr2) {
    //		String array1="";
    //		String array2="";
    //		long multiplyResult;
    //		for(int i=0;i<arr1.length;i++) {
    //			array1+=arr1[i];
    //		}
    //		for(int i=0;i<arr2.length;i++) {
    //			array2+=arr2[i];
    //		}
    //		long temp1 = Long.parseLong(array1);
    //		multiplyResult = Long.parseLong(array1) * Long.parseLong(array2);
    //		String temp=Long.toString(multiplyResult);
    //		long[] newArray = new long[temp.length()];
    //		for(int i=0;i<temp.length();i++) {
    //			if(temp.charAt(i)!='-' && temp.charAt(i)!='+') {
    //				newArray[i]=temp.charAt(i);
    //			}
    //		}
    //		return newArray;
    //	}

    public static String multipleStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int value = (num1.charAt(i) - '0') * num2.charAt(j) - '0';
                result[i + j + 1] = result[i + j + 1] + value;
                result[i + j] = result[i + j] + result[i + j + 1] / 10;
                result[i + j + 1] = result[i + j + 1] % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : result) {
            if (!(p == 0 && sb.length() == 0)) {
                sb.append(p);
            }
        }

        return sb.toString().length() != 0 ? sb.toString() : "0";
    }

}
