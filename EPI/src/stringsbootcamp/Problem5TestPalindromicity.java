package stringsbootcamp;

public class Problem5TestPalindromicity {

	public static void main(String[] args) {

		String str = "A man, a plan, a canal, Panama." ;
		isPalindromic(str);
		System.out.println("The String '"+str+"' is "+ (isPalindromic(str) ? "palindromic" : "not palindromic"));
	}
	public static boolean isPalindromic(String str) {
		int i=0, j= str.length()-1;
		while(i<j) {
			while(!Character.isLetterOrDigit(str.charAt(i)) && i<j) {
				i++;
			}
			while(!Character.isLetterOrDigit(str.charAt(j)) && i<j) {
				j--;
			}
			if(Character.toLowerCase(str.charAt(i++)) != Character.toLowerCase(str.charAt(j--)) ) {
				return false;
			}
		}
		
		return true;
	}

}
