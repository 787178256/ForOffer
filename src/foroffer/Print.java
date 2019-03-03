package foroffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by kimvra on 2019-02-27
 */
public class Print {
    public ArrayList<ArrayList<Integer>> solution(TreeNode pRoot) {
        int layer = 1;
        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();
        oddStack.push(pRoot);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while (!oddStack.empty() || !evenStack.empty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (layer % 2 == 1) {
                while (!oddStack.empty()) {
                    TreeNode currentNode = oddStack.pop();
                    if (currentNode != null) {
                        temp.add(currentNode.val);
                        evenStack.push(currentNode.left);
                        evenStack.push(currentNode.right);
                    }
                }
                if (!temp.isEmpty()) {
                    result.add(temp);
                    layer++;
                }
            } else {
                while (!evenStack.empty()) {
                    TreeNode currentNode = evenStack.pop();
                    if (currentNode != null) {
                        temp.add(currentNode.val);
                        oddStack.push(currentNode.right);
                        oddStack.push(currentNode.left);
                    }
                }
                if (!temp.isEmpty()) {
                    result.add(temp);
                    layer++;
                }
            }
        }
        return result;
    }
}
