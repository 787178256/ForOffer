package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by kimvra on 2019-06-18
 * 给定一个颗二叉树，返回中序遍历
 */
public class _0094_Inorder_Traversal {
    static List<Integer> res = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        res.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return res;
    }

    public static List<Integer> inorderWithStack(TreeNode root) {
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }

            while (!stack.isEmpty()) {
                TreeNode curNode = stack.pop();
                res.add(curNode.val);
                if (curNode.right != null) {
                    stack.push(curNode.right);
                    root = curNode.right;
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderWithStack(root));
    }
}
