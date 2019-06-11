package stringsbootcamp;

public class Problem8TheLookAndSayProblem {

	public static void main(String[] args) {
		for(int i=1;i<=10;i++) {
			System.out.println(lookAndSay(i));
		}
	}
	
	private static String lookAndSay(int n) {
		String start = "1"; 
		for(int i=1;i<n;i++) {
			start = nextNumber(start);
		}
		return start;
	}

	private static String nextNumber(String start) {
		StringBuilder builder=new StringBuilder();
		
		for(int i=0;i<start.length();i++) {
			int count =1;
			while(i+1<start.length() && start.charAt(i)==start.charAt(i+1) ) {
				count++;
				i++;
			}
			builder.append(count);
			builder.append(start.charAt(i));
		}
		
		return builder.toString();
	}

}
