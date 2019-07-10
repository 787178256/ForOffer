package leetcode;

/**
 * Created by kimvra on 2019-02-28
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class _0002_Add_Two_Numbers {
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum = sum / 10;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        if (sum / 10 != 0) {
            temp.next = new ListNode(1);
        }
        return node.next;
    }

    public static ListNode ByteDance(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);
        int c = 0;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (head1 != null && head2 != null) {
            int sum = head1.val + head2.val + c;
            ListNode node = new ListNode(sum % 10);
            c = sum / 10;
            p.next = node;
            p = node;
            head1 = head1.next;
            head2 = head2.next;
        }
        while (head1 != null) {
            int sum = head1.val + c;
            ListNode node = new ListNode(sum % 10);
            c = sum / 10;
            p.next = node;
            p = node;
            head1 = head1.next;
        }
        while (head2 != null) {
            int sum = head2.val + c;
            ListNode node = new ListNode(sum % 10);
            c = sum / 10;
            p.next = node;
            p = node;
            head2 = head2.next;
        }
        return reverse(head.next);
    }

    private static ListNode reverse(ListNode head) {
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(7);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(0);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(2);
        ListNode node = ByteDance(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
