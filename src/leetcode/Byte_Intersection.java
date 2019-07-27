package leetcode;

/**
 * Created by kimvra on 2019-07-27
 */
public class Byte_Intersection {
    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA, tempB = headB;
        int lenA = 0, lenB = 0;
        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }
        int count = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while (count > 0) {
                headA = headA.next;
                count--;
            }
            while (headB != null && headA != null && headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            if (headA == null || headB == null) {
                return null;
            } else {
                return headA;
            }
        } else {
            while (count > 0) {
                headB = headB.next;
                count--;
            }
            while (headA != null && headB != null && headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            if (headA == null || headB == null) {
                return null;
            } else {
                return headA;
            }
        }
    }
}
