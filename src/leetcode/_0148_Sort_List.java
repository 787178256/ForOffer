package leetcode;

/**
 * Created by kimvra on 2019-07-01
 */
public class _0148_Sort_List {
    private ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode node = new ListNode(0);
        ListNode cur = node;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return node.next;
    }
}
