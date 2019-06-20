package leetcode;

/**
 * Created by kimvra on 2019-06-20
 */
public class _0104_Max_Depth {
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
