package stringsbootcamp;

public class Problem12ImplementRunLengthEncoding {

	public static void main(String[] args) {
//aaaabcccaa
		System.out.println(encoding("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcccaa"));
		System.out.println(epiDecoding(encoding("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcccaa")));
	}
	
	public static String encoding(String encoding) {
		int count = 1;
		String decoded="";
		for(int i=0;i<encoding.length();i++) {
			if(i<encoding.length()-1 && encoding.charAt(i)==encoding.charAt(i+1)) {
				count++;
			}else {
				decoded+= count+""+encoding.charAt(i);
				count=1;
			}
		}
		return decoded;
	}
	
	//will fail if the alphabet is more than 9.
	private static StringBuilder decoding(String encoded) {
		StringBuilder decoded = new StringBuilder();
		int pointer=0;
		while(pointer<encoded.length()) {
			int multiple =encoded.charAt(pointer) - '0';
			for(int i=1;i<=multiple;i++) {
				decoded.append(encoded.charAt(pointer+1));
			}
			pointer+=2;
		}
		return decoded;
	}
	
	private static StringBuilder epiDecoding(String encoded) {
		StringBuilder decoded = new StringBuilder();
		int count=0;
		for(int i=0;i<encoded.length();i++) {
			char charAt = encoded.charAt(i);
			if(Character.isDigit(charAt)) {
				count = count *10 + charAt-'0';
			}else {
				while(count>0) {
					decoded.append(charAt);
					count--;
				}
			}
		}
		return decoded;
	}

}
