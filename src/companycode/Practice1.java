package companycode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kimvra on 2019-02-27
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Practice1 {
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int start = 0, end = 1, level = 1;
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            if (currentNode != null) {
                start++;
                if (currentNode.left == null && currentNode.right == null) {
                    return level;
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            if (start == end) {
                level++;
                start = 0;
                end = queue.size();
            }
        }
        return level;
    }

    public int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            depth++;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return 0;
    }

    public int solution3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return solution3(root.right) + 1;
        } else if (root.right == null) {
            return solution3(root.left) + 1;
        } else {
            int leftDepth = solution3(root.left);
            int rightDepth = solution3(root.right);
            return leftDepth > rightDepth ? rightDepth + 1 : leftDepth + 1;
        }
    }
}
