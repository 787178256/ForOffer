package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-21
 */
public class _0039_Combination_Sum {
    public static int combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(listAll, list, candidates, target, 0);
        return listAll.size();
    }

    private static void helper(List<List<Integer>> listAll, List<Integer> tmp, int[] candidates, int target, int num) {
        if (target == 0) {
            listAll.add(tmp);
            return;
        }
        if (target < candidates[0]) {
            return;
        }
        for (int i = num; i < candidates.length && candidates[i] <= target; i++) {
            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            helper(listAll, list, candidates, target - candidates[i], i);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strings = s.split(" ");
        int target = Integer.valueOf(strings[0]);
        String[] nums = strings[1].substring(1, strings[1].length() - 1).split(",");
        int[] candidates = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            candidates[i] = Integer.valueOf(nums[i]);
        }
        System.out.println(combinationSum(candidates, target));
    }
}
