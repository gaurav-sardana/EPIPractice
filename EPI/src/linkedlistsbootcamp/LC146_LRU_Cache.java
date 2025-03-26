package linkedlistsbootcamp;

import mylinkedlist.Node;

import java.util.HashMap;
import java.util.Map;

public class LC146_LRU_Cache {

    Node<Integer> head;
    Node<Integer> tail;
    int capacity;
    Map<Integer, Node<Integer>> dict;

    public LC146_LRU_Cache(int capacity) {
        this.capacity = capacity;
        head = new Node<>(-1, -1, null, null);
        tail = new Node<>(-1, -1, null, null);
        head.nextNode = tail;
        tail.prevNode = head;
        dict = new HashMap<>();
    }

    public int get(int key) {
        if (!dict.containsKey(key)) return -1;

        Node<Integer> node = dict.get(key);
        remove(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (dict.containsKey(key)) {
            remove(dict.get(key));
        }

        Node<Integer> node = new Node<>(key, value, null, null);
        dict.put(key, node);
        add(node);

        if (dict.size() > capacity) {
            Node<Integer> prevNode = head.nextNode;
            dict.remove(prevNode.key);
            remove(prevNode);
        }
    }


    private void add(Node node) {
        Node lastNode = tail.prevNode;
        lastNode.nextNode = node;
        node.nextNode = tail;
        tail.prevNode = node;
        node.prevNode = lastNode;

    }


    private void remove(Node node) {
        node.prevNode.nextNode = node.nextNode;
        node.nextNode.prevNode = node.prevNode;
    }


}
