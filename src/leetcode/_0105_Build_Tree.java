package leetcode;

/**
 * Created by kimvra on 2019-06-20
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 */
public class _0105_Build_Tree {
    public TreeNode buildTree(int [] pre,int [] in) {
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
