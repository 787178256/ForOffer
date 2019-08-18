package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kimvra on 2019-03-30
 */
public class _0040_Combination_Sum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        func(listAll, list, candidates, target, 0);
        return listAll;
    }

    private static void func(List<List<Integer>> listAll, List<Integer> tmp, int[] candidates, int target, int index) {
        if (target == 0) {
            listAll.add(tmp);
            return;
        }
        if (target < candidates[0]) {
            return;
        }
        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            func(listAll, list, candidates, target - candidates[i], i + 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        int target = 10;
        System.out.println(combinationSum2(candidates, target));
    }

}
