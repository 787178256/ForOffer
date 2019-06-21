package leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kimvra on 2019-06-21
 * 二叉树中最大路径和
 */
public class _0124_Max_Path_Sum {
    private int max = Integer.MIN_VALUE;
    private TreeNode root;

    private int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        max = Math.max(max, left + root.val + right);
        return Math.max(left, right) + root.val;
    }

    @Before
    public void init() {
        root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }
    @Test
    public void test() {
        Assert.assertEquals(maxPathSum(root), 42);
    }
}
