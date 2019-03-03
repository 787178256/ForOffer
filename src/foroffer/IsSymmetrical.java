package foroffer;

/**
 * Created by kimvra on 2019-02-23
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class IsSymmetrical {

    public boolean solution(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }

    public boolean comRoot(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return comRoot(left.left, right.right) && comRoot(left.right, right.left);
    }


}
