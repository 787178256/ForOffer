package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kimvra on 2019-04-01
 */
public class _0046_Permute {
    private static ArrayList<List<Integer>> res;
    private static boolean[] used;

    public static List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums, 0, p);

        return res;
    }

    private static void generatePermutation(int[] nums, int index, LinkedList<Integer> p){
        if (index == nums.length) {
            List<Integer> list = new LinkedList<>(p);
            res.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                p.addLast(nums[i]);
                generatePermutation(nums, index + 1, p);
                p.removeLast();
                used[i] = false;
            }
        }
        return;
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {3, 3, 0, 3};
        List<List<Integer>> res = permute(nums);
        for(List<Integer> list: res)
            printList(list);
    }
}
