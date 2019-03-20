package foroffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by kimvra on 2019-03-18
 */
public class Tree {
    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    private void afterOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.println(root.val);
    }


    private void layer(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node  = queue.remove();
            System.out.println(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    private void preOrderWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    private void afterOrderWithStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode lastPopNode = null;
        while (!stack.isEmpty()) {
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
            while (!stack.isEmpty()) {
                if (lastPopNode == stack.peek().right || stack.peek().right == null) {
                    lastPopNode = stack.pop();
                    System.out.println(lastPopNode.val);
                } else if (stack.peek().right != null) {
                    stack.push(stack.peek().right);
                    break;
                }
            }
        }
    }

    private void inOrderWithStack(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.println(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                    break;
                }
            }
        }
    }
}
