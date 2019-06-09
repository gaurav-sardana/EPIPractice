package stringsbootcamp;

public class Problem6ReverseAllTheWordsInASentence {

	public static void main(String[] args) {
		String test = "Alice likes Bob";
		System.out.println(reverseSentence(test));
		System.out.println(reverseStringEPI(test));
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

	public static String reverseStringEPI(String str) {
		char[] sentence = str.toCharArray();
		reverse(sentence, 0, sentence.length);
		int start = 0, end;
		while( (end = find(sentence, ' ', start)) !=-1) {
			//reversing each word before and after delimiter
			reverse(sentence, start, end);
			start = end+1;
		}
		//reversing last word after last delimiter
		reverse(sentence, start, sentence.length);
		return new String(sentence);
	}
	
	// method to reverse the char[] 
	// generic for any start and end of array
	public static void reverse (char[] arr, int start, int stop) {
		if(start>=stop) {
			return ;
		}
		
		int lastIndex = stop - 1;
		for(int i=start;i<=start + (lastIndex- start) / 2 ; i++){
			char temp = arr[i];
			arr[i] = arr[lastIndex-i+start];
			arr[lastIndex - i+start] = temp;
		}
		
	}
	
	// method to find the delimiter index
	public static int find(char[] arr, char delimiter , int start) {
		for(int i=start;i<arr.length;i++) {
			if(arr[i] == delimiter) {
				return i;
			}
		}
		return -1;
	}

}
