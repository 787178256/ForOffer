package leetcode;

/**
 * Created by kimvra on 2019-07-05
 */
public class _0226_Invert_Tree {
    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);

        return root;
    }
}
