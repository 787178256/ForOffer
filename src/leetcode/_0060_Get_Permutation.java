package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kimvra on 2019-05-17
 */
public class _0060_Get_Permutation {
    /**
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     *
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * 给定 n 的范围是 [1, 9]。
     * 给定 k 的范围是[1,  n!]。
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     * 输入: n = 3, k = 3
     * 输出: "213"
     * 输入: n = 4, k = 9
     * 输出: "2314"
     */

    private static List<String> res = new LinkedList<>();
    private static boolean used[];

    public static String getPermutation(int n, int k) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        used = new boolean[n];
        StringBuilder stringBuilder = new StringBuilder();
        permutationHelper(0, stringBuilder, list);

        return res.get(k - 1);
    }

    private static void permutationHelper(int index, StringBuilder sb, List<Integer> list) {
        if (index == list.size()) {
            res.add(sb.toString());
        }

        for (int i = 0; i < list.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                sb.append(list.get(i));
                permutationHelper(index + 1, sb, list);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
    }
}
