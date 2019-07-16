package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kimvra on 2019-07-16
 * 快慢指针找中点，反转后半链表c
 */
public class _0234_Is_Palindrome {
    private boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        if (len % 2 == 0) {
            len = len / 2;
        } else {
            len = len / 2 + 2;
        }
        p = head;
        while (len > 1) {
            p = p.next;
            len--;
        }
        ListNode newHead = reverse(p);
        while (newHead != null && head != null) {
            if (newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    @Test
    public void test() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        Assert.assertFalse(isPalindrome(root));
    }
}
