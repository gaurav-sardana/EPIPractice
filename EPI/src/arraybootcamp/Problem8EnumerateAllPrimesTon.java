package arraybootcamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem8EnumerateAllPrimesTon {

	public static void main(String[] args) {

		List<Integer> primeNumbers = getPrime1ToNMethod1(18); 
		Problem2IncreaseInArbitaryPrecisionInteger.printList(primeNumbers);
		List<Integer> primes = getPrime1ToNMethod2(18);
		Problem2IncreaseInArbitaryPrecisionInteger.printList(primes);
	}
	// method 2 by EPI
	
	public static List<Integer> getPrime1ToNMethod2(int n){
		List<Integer> primes = new ArrayList<Integer>();
		
		List<Boolean> isPrime = new ArrayList<Boolean>(Collections.nCopies(n+1, true));
		isPrime.set(0,false);
		isPrime.set(1,false);
		for(int i=2 ; i<=n;i++) {
			if(isPrime.get(i)) {
				primes.add(i);
				//filter the multiples of i
			}
			for(int j=i;j<=n;j+=i) {
				isPrime.set(j, false);
			}
		}
		return primes;
	}
	
	
	//my try
	public static List<Integer> getPrime1ToNMethod1(int n) {
		
		List<Integer> primeNumbers = new ArrayList<Integer>();
		for(int i=2;i<n;i++) {
			if(checkPrime(i)) {
				primeNumbers.add(i);
			}
		}
		
		return primeNumbers;
	}
	
	public static boolean checkPrime(int n) {
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}

}
