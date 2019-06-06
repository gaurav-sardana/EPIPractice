package stringsbootcamp;

public class Problem2BaseConversion {

	public static void main(String[] args) {
		String str = "615";
		//Assuming 2<=base1 and b2<=16
		String result = doBaseConversion(str,7,13);
		System.out.println(result);
	}
	//time complexity is O(n(1+logbase2 base1)
	public static String doBaseConversion(String numAsString,int base1, int base2) {
		boolean isNegative=numAsString.startsWith("-");
		int numAsInt = 0;
		for(int i= ( isNegative ? 1:0) ;i<numAsString.length() ;i++) {
			numAsInt *= base1;
			numAsInt += Character.isDigit(numAsString.charAt(i)) ?  numAsString.charAt(i) - '0' : numAsString.charAt(i) + 10 - 'A'  ;
		}
		return (isNegative ? "-" : "") +  (numAsInt==0 ? "0" : constructFromBase(numAsInt,base2));
	}
	public static String constructFromBase(int numAsInt, int baseToChange) {
		return numAsInt == 0 ? "" : constructFromBase(numAsInt/baseToChange,baseToChange)
				+ (char)(numAsInt % baseToChange >=10 ? 'A' + (numAsInt % baseToChange) -10 : '0'+numAsInt % baseToChange);
	}
}
