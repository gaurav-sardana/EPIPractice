package hashtablesbootcamp;

public class HashFunctionSuitableForString {

	public static int stringHash(String str, int modulus) {

		int kMul = 997;
		int value = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			value = (value * kMul + c) % modulus;
		}
		return value;
	}

	public static void main(String[] args) {

		System.out.println(stringHash("Gaurav", 7));
		System.out.println(stringHash("gaurav", 7));
		System.out.println(stringHash("bikram", 7));
		System.out.println(stringHash("harsh", 7));
		System.out.println(stringHash("DJ", 7));
		System.out.println(stringHash("rinki", 7));
		System.out.println(stringHash("harish", 7));
		System.out.println(stringHash("mohit", 7));
		System.out.println(stringHash("Gaurav", 7));
	}

}
