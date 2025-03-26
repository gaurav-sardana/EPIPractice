package mylinkedlist;

public class Node<E> {
    public Node<E> nextNode;
    public Node<E> prevNode;

    public E value;
    public E key;

    public Node(E e) {
        value = e;
    }


    public Node(E e, Node<E> n) {
        this(e);
        nextNode = n;
    }


    public Node(E key, E value, Node<E> next, Node<E> prev) {
        this.value = value;
        this.key = key;
        this.nextNode = next;
        this.prevNode  = prev;
    }

}
