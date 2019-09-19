package leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by kimvra on 2019-07-02
 */
public class _0160_Intersection_Node {
    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode temp = headA;
        while (temp != null) {
            lenA++;
            temp = temp.next;
        }
        int lenB = 0;
        temp = headB;
        while (temp != null) {
            lenB++;
            temp = temp.next;
        }
        int count = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while (count > 0) {
                headA = headA.next;
                count--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private ListNode solutionWithStack(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode nodeA = stackA.pop();
            ListNode nodeB = stackB.pop();
            if (nodeA != nodeB) {
                return nodeA.next;
            }
        }
        return null;
    }

    @Test
    public void test() {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;
        System.out.println(solutionWithStack(headA, headB).val);
    }
}
