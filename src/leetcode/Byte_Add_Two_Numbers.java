package leetcode;

/**
 * Created by kimvra on 2019-07-27
 */
public class Byte_Add_Two_Numbers {
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        int c = 0, sum;
        while (l1 != null && l2 != null) {
            sum = (l1.val + l2.val + c) % 10;
            c = (l1.val + l2.val + c) / 10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = (l1.val + c) % 10;
            c = (l1.val + c) / 10;
            temp.next = new ListNode(sum);
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null) {
            sum = (l2.val + c) % 10;
            c = (l2.val + c) / 10;
            temp.next = new ListNode(sum);
            l2 = l2.next;
            temp = temp.next;
        }
        if (c != 0) {
            temp.next = new ListNode(c);
        }
        return pre.next;
    }
}
