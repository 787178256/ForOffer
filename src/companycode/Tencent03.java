package companycode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by kimvra on 2019-08-17
 */
public class Tencent03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Stack<Integer> right = new Stack<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (right.isEmpty()) {
                    right.push(nums[j]);
                } else if (nums[j] > right.peek()) {
                    right.push(nums[j]);
                }
            }
            res[i] = right.size() + 1;
            right.clear();
        }
        Stack<Integer> left = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (left.isEmpty()) {
                    left.push(nums[j]);
                } else if (nums[j] > left.peek()) {
                    left.push(nums[j]);
                }
            }
            res[i] += left.size();
            left.clear();
        }
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(res[i]);
            } else {
                System.out.print(res[i] + " ");
            }
        }
    }
}
