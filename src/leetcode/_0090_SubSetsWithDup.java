package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by kimvra on 2019-09-08
 */
public class _0090_SubSetsWithDup {
    private List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= len; i++) {
            dfs(nums, 0, res, new ArrayList<>(), i);
        }
        System.out.println(res);
        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> list, int len) {
        if (list.size() == len && !res.contains(list)) {
            List<Integer> ll = new ArrayList<>(list);
            res.add(ll);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (len == 1 && i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, i + 1, res, list, len);
            list.remove(new Integer(nums[i]));
        }
    }

    @Test
    public void test() {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
