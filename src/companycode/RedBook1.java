package companycode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kimvra on 2019-08-18
 */
public class RedBook1 {
    private static int count = 0;
    public static void main(String[] args) {
        int[] nums = {2,3,5};
        Arrays.sort(nums);
        int target = 10;
        dfs(nums, 0, target);
        System.out.println(count);
    }

    private static void dfs(int[] nums, int index, int target) {
        if (0 == target) {
            count++;
            return;
        }
        if (target < nums[0]) {
            return;
        }
        for (int i = index; i < nums.length && nums[i] <= target; i++) {
            dfs(nums, i, target - nums[i]);
        }
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
}
