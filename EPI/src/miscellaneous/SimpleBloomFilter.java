package miscellaneous;

import java.util.BitSet;

/*
   - A Bloom filter uses:
            1. A bit array of size m( initialised to 0)
            2. k independent has functions

   - Add(x) :
            - Hash the input x with k hash functions
            - Set the k corresponding bits in array to 1

   - Check(x)
            - Hash x with the same k hash functions
            - If any of the k bits is 0, x is definitely not in the set
            - If all k bits are 1, x is possibly in the set.


*/
public class SimpleBloomFilter {

    private int size;
    private int[] seeds;
    private BitSet bitSet;

    public SimpleBloomFilter(int size, int[] seeds) {
        this.size = size;
        this.bitSet = new BitSet(size);
        this.seeds = seeds;
    }

    private int hash(String value, int seed) {
        int result = 0;
        for (char c : value.toCharArray()) {
            result = (seed * result) + c;
        }
        return (size - 1) & result;
    }

    public void add(String value) {

        for (int seed : seeds) {
            int hash = hash(value, seed);
            bitSet.set(hash);
        }

    }

    public boolean mightContain(String value) {
        for (int seed : seeds) {
            int hash = hash(value, seed);
            if (!bitSet.get(hash)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int size = 1024;
        int[] seeds = {7, 11, 13, 31, 37, 61};

        SimpleBloomFilter filter = new SimpleBloomFilter(size, seeds);

        // Adding items
        filter.add("apple");
        filter.add("banana");
        filter.add("cherry");

        // Checking presence
        System.out.println("Might contain 'apple': " + filter.mightContain("apple"));   // true
        System.out.println("Might contain 'banana': " + filter.mightContain("banana")); // true
        System.out.println("Might contain 'grape': " + filter.mightContain("grape"));   // false or true (false positive possible)
    }

}
