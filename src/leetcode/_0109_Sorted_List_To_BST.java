package leetcode;

/**
 * Created by kimvra on 2019-10-21
 */
public class _0109_Sorted_List_To_BST {
    private TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode pre = head, slow = head.next, fast = head.next.next;
        while (fast != null && fast.next != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }                   // slow 抵达中点！
        pre.next = null;    // pre  用于从中点断链
        TreeNode root = new TreeNode(slow.val);
        root.left  = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
