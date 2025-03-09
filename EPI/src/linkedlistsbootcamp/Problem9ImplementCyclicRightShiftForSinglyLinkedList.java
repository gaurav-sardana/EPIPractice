package linkedlistsbootcamp;

import MyLinkedList.Node;

public class Problem9ImplementCyclicRightShiftForSinglyLinkedList {

    public static void main(String[] args) {
        Node<Integer> node = new Node<Integer>(1, new Node<Integer>(2, new Node<Integer>(3, new Node<Integer>(4, new Node<Integer>(5, new Node<Integer>(6, new Node<Integer>(7, new Node<Integer>(8, new Node<Integer>(9, new Node<Integer>(10, new Node<Integer>(11)))))))))));
        Node<Integer> rightShiftNodeByK = rightShiftNodeByK(node, 12);
        while (rightShiftNodeByK != null) {
            System.out.println(rightShiftNodeByK.value);
            rightShiftNodeByK = rightShiftNodeByK.nextNode;
        }
    }

    public static Node<Integer> rightShiftNodeByK(Node<Integer> node, int k) {
        Node<Integer> tail = node;
        int len = 1;
        while (tail.nextNode != null) {
            len++;
            tail = tail.nextNode;
        }
        k %= len;
        if (k == 0) {
            return node;
        }
        tail.nextNode = node;
        int noOfStepsToMakeNewHead = len - k;
        while (noOfStepsToMakeNewHead-- > 0) {
            tail = tail.nextNode;
        }
        Node<Integer> newHead = tail.nextNode;
        tail.nextNode = null;
        return newHead;
    }
}
