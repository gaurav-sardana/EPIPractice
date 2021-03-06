package arraybootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem9PermuteElementOfAnArray {

	public static void main(String[] args) {
		List<String> list = permutationsString("abc");
		printStringList(list);
		int[] arr = {1,2,3};
		List<int[]> listInteger = permutationsInteger(arr);
		printIntArrayList(listInteger);
		
		// EPI problem 9 Test
		List<Integer> permuted = new ArrayList<Integer>(Arrays.asList(2,0,3,1));
		List<Character> permute = new ArrayList<Character>(Arrays.asList('a','b','c','d'));
		System.out.println(permuted);
		permutePtoA(permuted, permute);
		System.out.println(permute);
		System.out.println(permuted);
	}




	public static List<String> permutationsString(String str){
		List<String> permuteStrings = new ArrayList<String>();
		permuteString("",str,permuteStrings);
		return permuteStrings;
	}

	public static void permuteString (String prefix , String suffix, List<String> results) {

		if(suffix.length()==0) {
			results.add(prefix);
		}

		for(int i=0;i<suffix.length();i++) {
			permuteString(prefix+suffix.charAt(i), suffix.substring(0,i)+suffix.substring(i+1,suffix.length()), results);
		}
	}
	public static void printStringList(List<String> list) {
		for(String str: list) {
			System.out.println(str);
		}
		System.out.println("Total number of permuatations are "+list.size());
	} 

	public static List<int[]> permutationsInteger(int[] arr){
		List<int[]> intPermutations = new ArrayList<int[]>();
		permuteInt(arr,0,intPermutations);
		return intPermutations;
	}

	public static void permuteInt(int[] a, int start, List<int[]> results) {
		if(start >=a.length) {
			results.add(a.clone());
		}
		for(int i=start;i< a.length;i++) {
			swapIntArray(a, start, i);
			permuteInt(a, start+1, results);
			swapIntArray(a, start, i);
		}
	}

	public static void swapIntArray(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void printIntArrayList(List<int[]> arr) {
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println("Total number of permuatations are "+arr.size());
	}

	//EPI problem 9 solution 

	//time O(n) space O(1)
	public static void permutePtoA(List<Integer> permuted, List<Character> permute){

		for(int i=0;i<permute.size();i++) {
			int next =i;
			while(permuted.get(next)>=0)
			{
				Collections.swap(permute, i, permuted.get(next));
				int temp = permuted.get(next);
				permuted.set(next, permuted.get(next) - permuted.size());
				next = temp;
			}
		}
		// restore P
		for(int i=0;i<permuted.size();i++) {
			permuted.set(i, permuted.size()+permuted.get(i));
		}
	}
}
