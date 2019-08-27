package leetcode;

/**
 * Created by kimvra on 2019-08-26
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class _0082_Delete_Duplicates {
    private ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = new ListNode(-1000);
        ListNode move = node;
        move.next = head;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (move.next == cur) {
                move = move.next;
            } else {
                move.next = cur.next;
            }
            cur = cur.next;
        }
        return node.next;
    }
}
