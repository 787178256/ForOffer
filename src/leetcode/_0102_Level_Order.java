package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kimvra on 2019-06-20
 */
public class _0102_Level_Order {
    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root == null) {
            return res;
        }
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int count = linkedList.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = linkedList.pollFirst();
                count--;
                list.add(node.val);
                if (node.left != null) {
                    linkedList.add(node.left);
                }
                if (node.right != null) {
                    linkedList.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
