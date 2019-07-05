package leetcode;

/**
 * Created by kimvra on 2019-07-05
 */
public class _0226_Invert_Tree {
    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        TreeNode temp = left;
        root.left = right;
        root.right = temp;

        return root;
    }
}
