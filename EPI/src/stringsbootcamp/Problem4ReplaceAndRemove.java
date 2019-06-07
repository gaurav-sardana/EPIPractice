package stringsbootcamp;

public class Problem4ReplaceAndRemove {

	public static void main(String[] args) {
		char[] arr = {'a','c','a','a','a','a','a'};
		 replaceAndRemove(4,arr);
		System.out.println(arr);
	}

	public static void replaceAndRemove(int size,char[] charArr) {
		int writeIdx = 0 , aCount = 0; 
		for(int i=0;i<size;i++) {
			if(charArr[i]!='b') {
				charArr[writeIdx++] = charArr[i];
			}
			if(charArr[i] == 'a') {
				aCount++;
			}
		}
		
		int currentIdx = writeIdx -1;
		writeIdx =  writeIdx + aCount - 1;
		final int finalSize = writeIdx  + 1;
		
		while(currentIdx>=0) {
			if(charArr[currentIdx]=='a') {
				charArr[writeIdx--] = 'd';
				charArr[writeIdx--] = 'd';
			}else {
				charArr[writeIdx--] = charArr[currentIdx];
			}
			--currentIdx;
		}
		System.out.println("Final Size : " +finalSize);
	}

}
