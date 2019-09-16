package leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kimvra on 2019-09-16
 */
public class _0103_Zigzag_Level_Order {
    private List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int layer = 1, c = 1;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            c--;
            TreeNode node = queue.removeFirst();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (c == 0) {
                if (layer % 2 == 0) {
                    Collections.reverse(list);
                }
                layer++;
                res.add(list);
                list = new ArrayList<>();
                c = queue.size();
            }
        }
        return res;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(zigzagLevelOrder(root));
    }
}
