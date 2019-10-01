package leetcode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-10-01
 */
public class _0725_Split_List_To_Parts {
    private ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode node = root;
        while (node != null) {
            len++;
            node = node.next;
        }
        ListNode[] res = new ListNode[k];
        if (len <= k) {
            ListNode tempNode = root;
            int i = 0;
            for (; i < len; i++) {
                res[i] = tempNode;
                ListNode next = tempNode.next;
                tempNode.next = null;
                tempNode = next;
            }
            while (i < k) {
                res[i++] = null;
            }
            return res;
        } else {
            int m = len / k;
            int n = len % k;
            ListNode tempNode = root;
            int j = 0;
            for (; j < n; j++) {
                res[j] = tempNode;
                int count = 0;
                while (count < m) {
                    tempNode = tempNode.next;
                    count++;
                }
                ListNode nextNode = tempNode.next;
                tempNode.next = null;
                tempNode = nextNode;
            }
            while (j < k) {
                res[j++] = tempNode;
                int count = 0;
                while (count < m - 1) {
                    tempNode = tempNode.next;
                    count++;
                }
                ListNode nextNode = tempNode.next;
                tempNode.next = null;
                tempNode = nextNode;
            }
            return res;
        }
    }

    @Test
    public void test() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next = new ListNode(8);
        root.next.next.next.next.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next.next.next.next.next = new ListNode(10);
        ListNode[] res = splitListToParts(root, 3);
        for (ListNode node : res) {
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
}
