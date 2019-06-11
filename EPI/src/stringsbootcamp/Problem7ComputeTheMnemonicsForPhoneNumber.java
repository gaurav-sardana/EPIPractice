package stringsbootcamp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem7ComputeTheMnemonicsForPhoneNumber {
	private static final String[] MNEMONICS= {"0","1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	public static void main(String[] args) {
		String nm = "2297979";
		List<String> mnemonics= getPhoneMnemonics(nm);
		Iterator<String>  iterator= mnemonics.iterator();
		System.out.println("Total number of mnemonics of "+nm+" are : "+mnemonics.size());
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	//we can also do using 7 for loops 
	public static List <String> getPhoneMnemonics(String phoneNumber){
		char[]  partialPnemonics = new  char[phoneNumber.length()];
		List <String> mnemonics = new ArrayList<String>();
		phoneMnemonicsHelper(phoneNumber,0,partialPnemonics,mnemonics);
		return mnemonics;
	}
	
	private static void phoneMnemonicsHelper(String phoneNumber , int digit, char[] partialMneomics,List<String> mneomics) {
		if(digit == phoneNumber.length()) {
			mneomics.add(new String(partialMneomics));
		}else {
			for(int i=0; i < MNEMONICS[phoneNumber.charAt(digit) - '0'].length();i++) {
				partialMneomics[digit] = MNEMONICS[phoneNumber.charAt(digit) - '0'].charAt(i);
				phoneMnemonicsHelper(phoneNumber,digit+1,partialMneomics,mneomics);
			}
		}
	}
}
