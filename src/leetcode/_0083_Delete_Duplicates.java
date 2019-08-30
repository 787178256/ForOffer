package leetcode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-08-30
 * 1-->2-->2====>1-->2
 */
public class _0083_Delete_Duplicates {
    private ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
