package leetcode;


/**
 * Created by kimvra on 2019-03-07
 */
public class _0025_Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode node = new ListNode(0), pre = node;
        node.next = head;
        for (int i = 1; head != null; ++i) {
            if (i % k == 0) {
                pre = reverse(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return node.next;
    }

    private ListNode reverse(ListNode pre, ListNode next) {
        ListNode head = pre.next;
        ListNode move = head.next;
        while (move != next) {
            head.next = move.next;
            move.next = pre.next;
            pre.next = move;
            move = head.next;
        }
        return head;
    }

    private ListNode review(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        while (len < k && node != null) {
            node = node.next;
            len++;
        }
        int count = 0;
        ListNode cur = head;
        ListNode pre = null;
        if (len == k) {
            while (count < k && cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
                count++;
            }
            if (cur != null) {
                head.next = review(cur, k);
            }
            return pre;
        } else {
            return head;
        }
    }
}
