package foroffer;

/**
 * Created by kimvra on 2019-03-02
 */
public class ConstructTree {
    public TreeNode solution(int[] pre, int[] in) {
        return func(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode func(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode node = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                node.left = func(pre, startPre + 1, i - startIn + startPre, in, startIn, i - 1);
                node.right = func(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return node;
    }
}
