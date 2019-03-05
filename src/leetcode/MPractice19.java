package leetcode;

/**
 * Created by kimvra on 2019-03-05
 */
public class MPractice19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode afterPre = head;
        while (n-- > 0) {
            afterPre = afterPre.next;
        }
        if (afterPre != null) {
            while (afterPre.next != null) {
                pre = pre.next;
                afterPre = afterPre.next;
            }
            pre.next = pre.next.next;
        } else {
            head = head.next;
        }
        return head;
    }
}
