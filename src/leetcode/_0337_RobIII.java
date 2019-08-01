package leetcode;

/**
 * Created by kimvra on 2019-08-01
 */
public class _0337_RobIII {
    private int rob(TreeNode root) {
        return doRob(root);
    }

    private int doRob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int include = root.val;
        int exclude = doRob(root.left) + doRob(root.right);
        if (root.left != null) {
            include += doRob(root.left.left);
            include += doRob(root.left.right);
        }
        if (root.right != null) {
            include += doRob(root.right.left);
            include += doRob(root.right.right);
        }
        return Math.max(include, exclude);
    }
}
