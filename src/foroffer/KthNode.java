package foroffer;

import java.util.LinkedList;

/**
 * Created by kimvra on 2019-02-27
 */
public class KthNode {
    private static LinkedList<TreeNode> linkedList = new LinkedList<>();

    public static TreeNode solution(TreeNode node, int k) {
        if (k == 0) {
            return null;
        }
        inOrder(node);
        if (k > linkedList.size()) {
            return null;
        }
        return linkedList.get(k - 1);
    }

    private static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        linkedList.add(node);
        inOrder(node.right);
    }
}
