package leetcode;

/**
 * Created by kimvra on 2019-07-27
 */
public class Byte_Merge_List {
    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while (l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return pre.next;
    }
}
