package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-16
 */
public class IFlyTek02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strings = line.split(" ");
        int[] nums = new int[strings.length];
        int i = 0;
        for (String s : strings) {
            nums[i++] = Integer.valueOf(s);
        }
        System.out.println(func1(nums, 0, nums.length-1, 19));
    }

    private static int func(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >>> 1;
            if (nums[mid] == target) {
                return mid + 1;
            } else if (nums[mid] > target) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int func1(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + right >>> 1;
        if (nums[mid] > target) {
            return func1(nums, left, mid - 1, target);
        } else if (nums[mid] < target) {
            return func1(nums, mid + 1, right, target);
        } else {
            return mid + 1;
        }
    }
}
