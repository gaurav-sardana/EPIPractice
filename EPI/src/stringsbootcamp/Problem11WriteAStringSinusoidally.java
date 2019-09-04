package stringsbootcamp;

public class Problem11WriteAStringSinusoidally {

	public static void main(String[] args) {
		System.out.println(printStringSinusoidally("Hello World!"));
	}
	
	private static String printStringSinusoidally(String string) {
		String  snakeString = "";
		for(int i=1;i<string.length();i+=4) {
			snakeString+=string.charAt(i) == ' ' ? '/' : string.charAt(i);
		}
		for(int i=0;i<string.length();i+=2) {
			snakeString+=string.charAt(i) == ' ' ? '/' : string.charAt(i);
		}
		for(int i=3;i<string.length();i+=4) {
			snakeString+=string.charAt(i) == ' ' ? '/' : string.charAt(i);
		}
		return snakeString;
	}

}
