package stringsbootcamp;

public class Problem6ReverseAllTheWordsInASentence {

	public static void main(String[] args) {
		String test = "Alice likes Bob";
		System.out.println(reverseSentence(test));
	}
	public static String reverseWords(String sentencce) {
		return null;
	}
	
	public static String reverseSentence(String sentence) {
		String[] arr = sentence.split(" ");
		String result = "";
		for(int i=0;i<arr.length/2 ; i++) {
			String temp =arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		int j=0; 
		while(j<arr.length) {
			result+=arr[j]+" ";
			j++;
		}
		return result;
	}

}
