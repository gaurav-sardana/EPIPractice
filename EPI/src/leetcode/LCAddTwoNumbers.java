package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gauravsardana
 * @since 22/01/24
 */
public class LCAddTwoNumbers {
    public static void main(String[] args) {

        final ListNode l1 = new ListNode(9,9,9,9,9,9,9);
        final ListNode l2 = new ListNode(9,9,9,9);
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            final int i1 = l1 != null ? l1.val : 0;
            final int i2 = l2 != null ? l2.val : 0;
            int sum = i1 + i2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummyHead.next;
    }
}

class ListNode {
    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        final List<Integer> result = new ArrayList<>();
        ListNode temp = next;
        result.add(val);
        while (temp != null) {
            result.add(temp.val);
            temp = temp.next;
        }
        return result.toString();
    }

    ListNode(int... val) {
        ListNode listNode = new ListNode(0);
        ListNode curr = listNode;
        for (int i = 0; i < val.length; i++) {
            curr.next = new ListNode(val[i]);
            curr = curr.next;
        }
        this.val = listNode.next.val;
        this.next = listNode.next.next;

    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

