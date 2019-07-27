package leetcode;

/**
 * Created by kimvra on 2019-07-27
 */
public class Byte_Detect_Cycle {
    private ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        ListNode p = head;
        ListNode q = slow;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
