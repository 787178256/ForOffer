package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by kimvra on 2019-10-20
 */
public class _0107_Level_Order_Bottom {
    private List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int c = 1;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            list.add(node.val);
            c--;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (c == 0) {
                res.add(list);
                list = new ArrayList<>();
                c = queue.size();
            }
        }
        Collections.reverse(res);
        return res;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrderBottom(root));
    }
}
