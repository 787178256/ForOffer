package leetcode;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kimvra on 2019-03-22
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class _0236_Lowest_Common_Ancestor {

    private HashMap<TreeNode, TreeNode> parent = new HashMap<>();

    private HashMap<TreeNode, Integer> level = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }

    private TreeNode review(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
            return q;
        }
        helper(root);
        int pLevel = level.get(p);
        int qLevel = level.get(q);
        if (qLevel > pLevel) {
            int h = qLevel - pLevel;
            while (h > 0) {
                q = parent.get(q);
                h--;
            }
        }else if (qLevel < pLevel) {
            int h = pLevel - qLevel;
            while (h > 0) {
                p = parent.get(p);
                h--;
            }
        }
        if (q == p) {
            return q;
        }
        while (parent.get(p) != parent.get(q)) {
            p = parent.get(p);
            q = parent.get(q);
        }
        return parent.get(p);
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        parent.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int l = 1;
        int c = 1;
        while (!queue.isEmpty()) {
            c--;
            TreeNode node = queue.poll();
            level.put(node, l);
            if (node.left != null) {
                queue.add(node.left);
                parent.put(node.left, node);
            }
            if (node.right != null) {
                queue.add(node.right);
                parent.put(node.right, node);
            }
            if (c == 0) {
                c = queue.size();
                l++;
            }
        }
    }
}
