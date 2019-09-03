package leetcode;

/**
 * Created by kimvra on 2019-07-02
 */
public class _0206_Reverse_List {
    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }

    private ListNode reverseListWithRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curHead = reverseListWithRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return curHead;
    }

    private ListNode review(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = review(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    private ListNode review1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
