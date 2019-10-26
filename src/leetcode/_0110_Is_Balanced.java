package leetcode;

/**
 * Created by kimvra on 2019-10-26
 */
public class _0110_Is_Balanced {
    private boolean isBalanced(TreeNode root) {
        return root == null || Math.abs(depth(root.right) - depth(root.left)) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
