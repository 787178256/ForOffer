package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kimvra on 2019-06-24
 * 给定一个链表，判断链表中是否有环。
 */
public class _0141_Has_Cycle {
    private boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    private boolean func(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;
        Assert.assertTrue(hasCycle(head));
    }
}
