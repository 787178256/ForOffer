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

    public String getPermutation1(int n, int k) {
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            used[i] = false;
        }
        List<String> pre = new ArrayList<>();
        return dfs(nums, used, n, k, 0, pre);
    }

    private int factorial(int n) {
        // 这种编码方式包括了 0 的阶乘是 1 这种情况
        int res = 1;
        while (n > 0) {
            res *= n;
            n -= 1;
        }
        return res;
    }

    private String dfs(int[] nums, boolean[] used, int n, int k, int depth, List<String> pre) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (String c : pre) {
                sb.append(c);
            }
            return sb.toString();
        }
        int ps = factorial(n - 1 - depth);
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (ps < k) {
                k -= ps;
                continue;
            }
            pre.add(nums[i] + "");
            used[i] = true;
            return dfs(nums, used, n, k, depth + 1, pre);
        }
        // 如果参数正确的话，代码不会走到这里
        throw new RuntimeException("参数错误");
    }

    private String review(int[] nums, boolean[] used, int n, int k, int depth, List<String> pre) {
        if (depth == n) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : pre) {
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        }
        int ps = factorial(n - 1 - depth);
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (k > ps) {
                k -= ps;
                continue;
            }
            pre.add(nums[i] + "");
            used[i] = true;
            return dfs(nums, used, n, k, depth + 1, pre);
        }
        throw new RuntimeException("");
    }

    public static void main(String[] args) {
        //System.out.println(getPermutation(4, 9));
    }
}
