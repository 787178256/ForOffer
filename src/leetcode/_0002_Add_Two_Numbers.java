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
}
