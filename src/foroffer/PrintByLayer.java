package foroffer;

import java.util.*;

/**
 * Created by kimvra on 2019-02-27
 */
public class PrintByLayer {
    public static ArrayList<ArrayList<Integer>> solution(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return null;
        }
        Queue<TreeNode> layer = new LinkedList<>();
        layer.add(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0, end = 1;
        while (!layer.isEmpty()) {
            TreeNode currentNode = layer.remove();
            list.add(currentNode.val);
            start++;
            if (currentNode.left != null) {
                layer.add(currentNode.left);
            }
            if (currentNode.right != null) {
                layer.add(currentNode.right);
            }
            if (start == end) {
                start = 0;
                end = layer.size();
                result.add(list);
                list = new ArrayList<>();
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> solution1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int depth = 1;
        depth(pRoot, depth, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if (root == null) {
            return;
        }
        if (depth > list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(depth - 1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }
}
