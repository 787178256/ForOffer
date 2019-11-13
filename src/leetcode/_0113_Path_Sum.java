package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * Created by kimvra on 2019-11-13
 */
public class _0113_Path_Sum {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    private int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.target = sum;
        helper(root, 0, new ArrayList<Integer>() );
        return result;
    }

    private void helper(TreeNode node, int currentSum, List<Integer> currentList) {

        if( node == null ) {
            return ;
        }
        currentSum += node.val;
        currentList.add(node.val);
        if( node.left == null && node.right == null ) {
            if( currentSum == target ) {
                result.add( new ArrayList<>(currentList) );
            }
            currentList.remove(currentList.size()-1);
            return ;
        }
        helper(node.left, currentSum, currentList);
        helper(node.right, currentSum, currentList);
        currentList.remove(currentList.size()-1);
    }
}
