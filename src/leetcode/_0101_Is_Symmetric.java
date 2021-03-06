package leetcode;

/**
 * Created by kimvra on 2019-06-19
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class _0101_Is_Symmetric {

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isMirror(p.left, q.right) && isMirror(p.right, q.left);
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }
}
