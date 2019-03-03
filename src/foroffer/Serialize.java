package foroffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kimvra on 2019-02-27
 */
public class Serialize {
    public static String toString(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            if (currentNode != null) {
                stringBuilder.append(currentNode.val).append(",");
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            } else {
                stringBuilder.append("#").append(",");
            }
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    public static TreeNode toTree(String str) {
        String[] nodes = str.split(",");
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i].equals("#")) {
                treeNodes[i] = new TreeNode(Integer.valueOf(nodes[i]));
            }
        }
        for (int i = 0, j = 1; i < treeNodes.length; i++) {
            if (treeNodes[i] != null) {
                treeNodes[i].left = treeNodes[j++];
                treeNodes[i].right = treeNodes[j++];
            }
        }
        return treeNodes[0];
    }
}
