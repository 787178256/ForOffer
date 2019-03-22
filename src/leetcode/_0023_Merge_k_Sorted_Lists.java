package leetcode;

/**
 * Created by kimvra on 2019-03-05
 */
public class _0023_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return func(lists, 0, lists.length - 1);
    }

    private ListNode func(ListNode[] listNodes, int left, int right) {
        if (left >= right) {
            return listNodes[left];
        }
        int mid = left + right >>> 1;
        ListNode l0 = func(listNodes, left, mid);
        ListNode l1 = func(listNodes, mid + 1, right);
        return merge2List(l0, l1);
    }

    private ListNode merge2List(ListNode l0, ListNode l1) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l0 != null && l1 != null) {
            if (l0.val < l1.val) {
                temp.next = l0;
                l0 = l0.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        temp.next = l0 != null ? l0 : l1;
        return head.next;
    }
}
