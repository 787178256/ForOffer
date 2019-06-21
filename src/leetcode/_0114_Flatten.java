package leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by kimvra on 2019-06-21
 */
public class _0114_Flatten {
    private TreeNode node;

    private void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }

    @Before
    public void init() {
        node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(5);
        node.right.right = new TreeNode(6);
    }

    @Test
    public void test() {
        flatten(node);
        while (node != null) {
            System.out.println(node.val + " ");
            node = node.right;
        }
    }
}
