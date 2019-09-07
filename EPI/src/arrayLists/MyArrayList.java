package arrayLists;


public class MyArrayList<E> {

	private Object[] arr ;
	private int size ;
	
	public MyArrayList(int initialCapacity){
		this.arr = new Object[initialCapacity];
	}
	
	public MyArrayList () {
		this(10);
	}
	
	public Object add(E e) {
		if(this.size >=this.arr.length) this.increase();
		this.arr[this.size++] = e;
		return this.arr[this.size-1];
	}
	
	public int size() {
		return size;
	}
	
	public Object get(int index) {
		if(index>= size()) {
			throw new IndexOutOfBoundsException();
		}
		return arr[index];
	}

	private void increase() {
		Object[] temp = new Object[this.arr.length+5];
		for(int i=0;i<this.arr.length;i++) {
			temp[i] =  this.arr[i];
		}
		this.arr= temp;
	}
	
}
