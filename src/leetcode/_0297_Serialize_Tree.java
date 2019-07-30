package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kimvra on 2019-07-30
 */
public class _0297_Serialize_Tree {

}
class Codec {

    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
                stringBuilder.append(node.val + " ");
            } else {
                stringBuilder.append("null" + " ");
            }
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (!"null".equals(nodes[i])) {
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
