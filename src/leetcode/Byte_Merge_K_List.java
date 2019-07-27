package leetcode;

/**
 * Created by kimvra on 2019-07-27
 */
public class Byte_Merge_K_List {
    private ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int mid = left +  right >>> 1;
        ListNode l0 = helper(lists, left, mid);
        ListNode l1 = helper(lists, mid + 1, right);
        return mergeTwoList(l0, l1);
    }

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
        temp.next = l1 != null ? l1 : l2;
        return pre.next;
    }
}
