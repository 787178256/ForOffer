package companycode;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by kimvra on 2019-07-20
 * 1->2->3->...->n   ===>   1->n->2->n-1...
 */
public class ByteDance07 {
    private void reverse(ListNode root) {
        if (root == null || root.next == null || root.next.next == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode p = root;
        int len = 0;
        while (p != null) {
            stack.push(p);
            p = p.next;
            len++;
        }
        p = root;
        len = len / 2;
        while (len > 0) {
            ListNode temp = p.next;
            p.next = stack.pop();
            p.next.next = temp;
            p = temp;
            len--;
        }
        p.next = null;
        while (root != null) {
            System.out.println(root.x);
            root = root.next;
        }

    }

    @Test
    public void test() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        //root.next.next.next.next = new ListNode(5);
        reverse(root);
    }
}
class ListNode {
    int x;
    ListNode next;
    ListNode(int x) {
        this.x = x;
    }
}
