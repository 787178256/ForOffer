package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kimvra on 2019-04-02
 */
public class _0047_PermuteII {

    private static boolean[] used;

    private static List<List<Integer>> res;

    private static HashSet<List<Integer>> hashSet = new HashSet<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        func(nums, 0, list);
        return res.stream().distinct().collect(Collectors.toList());
    }

    private static void func(int[] nums, int index, LinkedList<Integer> linkedList) {
        if (index == nums.length) {
            if (!hashSet.contains(linkedList)) {
                LinkedList<Integer> tmp = new LinkedList<>(linkedList);
                res.add(tmp);
                hashSet.add(tmp);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                linkedList.addLast(nums[i]);
                func(nums, index + 1, linkedList);
                linkedList.removeLast();
                used[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,0,3};
        permuteUnique(nums);
        System.out.println(res);
    }
}
