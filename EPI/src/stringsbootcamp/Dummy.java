package stringsbootcamp;

public class Dummy {
	
	
	public static void main(String[] args) {
		String str = "tacocat";
		int possbilities=0;
		int i=1;
		while(i<=str.length()) {
			for(int j=0;j<=str.length() -i;j++) {
				String substring = str.substring(j, j+i);
				if(isPalindromic(substring)) {
					System.out.println(substring);
					possbilities++;
				}
			}
			i++;
		}
		System.out.println("The number of combination palindromics are : "+possbilities);
	}
	
	public static boolean isPalindromic(String str) {
		for(int i=0;i<str.length()/2;i++) {
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		
		return true;
	}

}

