package stringsbootcamp;

public class Problem3ComputeSpreadsheetColumnEncosing {

	public static void main(String[] args) {

		System.out.println(ssDecodeColId("ZZZZZZZZZZZZZZZZZZZZZZ"));
	}

	public static int ssDecodeColId(String str) {
		int result =0;
		for(int i =0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c>='A'&& c<='Z') {
				result = (result * 26 ) + c -'A'+1;
			}
		}
		return result;
	}
}
