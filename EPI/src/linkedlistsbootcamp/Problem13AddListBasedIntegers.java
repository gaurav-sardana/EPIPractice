package linkedlistsbootcamp;

import MyLinkedList.Node;

public class Problem13AddListBasedIntegers {

	public static void main(String[] args) {
			Node<Integer> num1 = new Node<Integer>(3,new Node<Integer>(1,new Node<Integer>(4)));
			Node<Integer> num2 = new Node<Integer>(7,new Node<Integer>(0,new Node<Integer>(9)));
			Node<Integer> addTwoNumbers = addTwoNumbers(num1,num2);
			while(addTwoNumbers!=null) {
				System.out.println(addTwoNumbers.value);
				addTwoNumbers=addTwoNumbers.nextNode;
			}
	}
	
	
	//time complexity O(m+n) and O(Max(m,n)), m,n are length of two lists
	public static Node<Integer> addTwoNumbers(Node<Integer> num1 , Node<Integer> num2) {
		
		Node<Integer> dummyHead = new Node<Integer>(0,null);
		Node<Integer> placeIter = dummyHead;
		
		int carry=0;
		while(num1!=null ||  num2!=null) {
			int sum = carry;
			if(num1!=null) {
				sum+=num1.value;
				num1=num1.nextNode;
			}
			if(num2!=null) {
				sum+=num2.value;
				num2 = num2.nextNode;
			}
			
		placeIter.nextNode= new Node<Integer>(sum%10,null);
		carry = sum/10;
		placeIter = placeIter.nextNode;
		}
		if(carry>0) {
			placeIter.nextNode=new Node<Integer>(carry);
		}
		return dummyHead.nextNode;
		
	}

}
