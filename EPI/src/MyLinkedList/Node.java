package MyLinkedList;

public class Node<E> {
    public Node<E> nextNode;

    public E value;

    public Node(E e) {
        value = e;
    }

    public Node(E e, Node<E> n) {
        this(e);
        nextNode = n;
    }

}
