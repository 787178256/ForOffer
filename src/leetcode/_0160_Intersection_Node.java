package leetcode;

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
}
