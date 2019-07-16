package companycode;

/**
 * Created by kimvra on 2019-07-16
 */
public class ByteDance04 {
    private static int func(TreeNode root) {
        if (root != null) {
            int left = func(root.left);
            int right = func(root.right);
            return Math.max(left, right) + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;
        TreeNode node = new TreeNode(4);
        root.left.left = node;
        System.out.println(func(root));
    }
}
