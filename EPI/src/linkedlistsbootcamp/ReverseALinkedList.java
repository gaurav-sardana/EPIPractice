package linkedlistsbootcamp;

import MyLinkedList.Node;

public class ReverseALinkedList {

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<Integer>(2, new Node<Integer>(5, new Node<Integer>(7, (Node<Integer>) null)));
        Node node = reverseLinkedList(n1);
        while (node != null) {
            System.out.println(node.value);
            node = node.nextNode;
        }

    }

    public static Node reverseLinkedList(final Node node) {
        Node prev = null, curr = node, next;

        while (curr != null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }


}
