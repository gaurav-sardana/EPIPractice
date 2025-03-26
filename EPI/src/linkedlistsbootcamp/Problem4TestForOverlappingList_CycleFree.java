package linkedlistsbootcamp;

import mylinkedlist.Node;

public class Problem4TestForOverlappingList_CycleFree {

	public static void main(String[] args) {
		Node< Integer> nodeoverLap = new Node<Integer>(30);
		Node< Integer> node = new Node<Integer>(10,new Node<Integer>(20,nodeoverLap));
		Node<Integer> node2 = new Node<Integer>(40,nodeoverLap);
		nodeoverLap.nextNode = new Node<Integer>(50,new Node<Integer>(60));
		Node<Integer> overlappingNoCylclicList = overlappingNoCylclicList(node,node2);
		// tandem loop
		while(overlappingNoCylclicList!=null) {
			System.out.println(overlappingNoCylclicList.value)	;
			overlappingNoCylclicList = overlappingNoCylclicList.nextNode;
			
		}

	}
	
	public static Node<Integer> overlappingNoCylclicList(Node<Integer> node1,Node<Integer> node2){
		
		int L1 = calcLength(node1) , L2= calcLength(node2);
		if(L1>L2) {
			node1 = advanceNode(node1, L1-L2);
		}else {
			node2 = advanceNode(node2, L2-L1);
		}
		
		while(node1!=null && node2!=null && node1!=node2) {
			node1 = node1.nextNode;
			node2 = node2.nextNode;
		}
		
		return node1;
	}
	
	public static Node<Integer> advanceNode(Node<Integer> node, int count) {
		int j=0;
		while (j++<count) {
			node=node.nextNode;
		}
		return node;
	}
	

	private static int calcLength(Node<Integer> node) {
		int len = 0;
		Node<Integer> node1 = node;
		while (node1 != null) {
			node1 = node1.nextNode;
			len++;
		}
		return len;
	}

}
