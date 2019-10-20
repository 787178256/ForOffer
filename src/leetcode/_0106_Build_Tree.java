package leetcode;

/**
 * Created by kimvra on 2019-10-20
 */
public class _0106_Build_Tree {
    private TreeNode buildTree(int[] inorder, int[] postorder) {
        return func(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode func(int[] inorder, int startIn, int endIn, int[] postorder, int startPost, int endPost) {
        if (startIn > endIn || startPost > endPost) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[endPost]);
        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == postorder[endPost]) {
                root.left = func(inorder, startIn, i - 1, postorder, startPost, i - startIn + startPost - 1);
                root.right = func(inorder, i + 1, endIn, postorder, startPost + i - startIn, endPost - 1);
                break;
            }
        }
        return root;
    }
}
