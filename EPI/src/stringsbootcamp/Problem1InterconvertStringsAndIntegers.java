package stringsbootcamp;

public class Problem1InterconvertStringsAndIntegers {

	public static void main(String[] args) {
		System.out.println(isPalindromic("abcddcba"));
		String str = "-123456aksd78naknsdjnakj98";
		System.out.println("String "+str+" to integer : "+convertStrtoIntA1(str));

	}

	//my approach
	public static int convertStrtoIntA1(String str) {
		int number =0;
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c>='0' && c<='9') {
				number = (number * 10 )+ (c-48);
			}
		}
		return str.charAt(0)=='-' ? -number: number;
	}

	//Basic
	public static boolean isPalindromic(String str) {
		for(int i=0, j=str.length()-1;i<j ;j--,i++) {
			if(str.charAt(i)!=str.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
