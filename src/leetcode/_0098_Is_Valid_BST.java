package leetcode;

import foroffer.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by kimvra on 2019-06-19
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class _0098_Is_Valid_BST {
    private static List<Integer> list = new ArrayList<>();
    private static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        inOrder(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left != null) {
            inOrder(treeNode.left);
        }
        list.add(treeNode.val);
        if (treeNode.right != null) {
            inOrder(treeNode.right);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(20);
        System.out.println(isValidBST(treeNode));
    }
}
