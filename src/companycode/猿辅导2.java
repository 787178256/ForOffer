package companycode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-09-18
 * 翻转链表第i到第j个节点
 */
public class 猿辅导2 {
    private ListNode solution(ListNode head, int i, int j) {
        int count = 1;
        ListNode node = head, start = head, end = head;
        while (count != j) {
            if (count == i - 1) {
                start = node;
            }
            count++;
            node = node.next;
        }
        end = node;
        ListNode next = end.next;
        ListNode cur = start.next;
        ListNode c = cur;
        while (cur != next) {
            ListNode temp = cur.next;
            cur.next = start.next;
            start.next = cur;
            cur = temp;
        }
        c.next = cur;
        return head;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution(head, 2, 4);
        while (head != null) {
            System.out.println(head.x);
            head = head.next;
        }
    }
}
