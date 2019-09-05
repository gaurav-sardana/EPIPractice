package stringsbootcamp;

public class Problem13FindTheFirstOccurenceOfASubstring {

	public static void main(String[] args) {
		System.out.println(rabinkarp("abcd","cdefabcdghijk"));
		
	}
	
	
	//Rabin Karp Solution 
	public static int rabinkarp(String pattern , String text ) {
		
		if(pattern.length() > text.length()) {
			return -1;
		}
		
		final int BASE=26;
		int patternHash =0 , textHash =0;
		int powerS = 1;
		for(int i=0;i<pattern.length();i++) {
			powerS = i>0 ? powerS * BASE:1;
			patternHash = patternHash * BASE +  pattern.charAt(i);
			textHash = textHash *BASE + text.charAt(i);
		}
		
		for(int i= pattern.length() ;i<text.length();i++) {
			if(patternHash == textHash && text.substring(i-pattern.length(), i).equals(pattern)) {
				return i -  pattern.length();
			}
			
			textHash -= text.charAt(i-pattern.length()) * powerS;
			textHash = textHash * BASE + text.charAt(i);
		}
		
		if(patternHash == textHash && text.substring(text.length() - pattern.length()).equals(pattern)) {
			return text.length() - pattern.length();
		}
		
		return -1;
	}
	
	

}
