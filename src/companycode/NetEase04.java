package companycode;


import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-21
 */
public class NetEase04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(func(nums, 0, n - 1));
    }

    public static int func(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }

        int len = (end - start) / 2;
        int leftSum = func(nums, start, start + len);
        int rightSum = func(nums, start + len + 1, end);
        int sum = 0;
        int i = start + len;
        int j = end;
        int length = end - start;
        int[] temp = new int[length + 1];
        while (i >= start && j >= start + len + 1) {
            if (nums[i] > nums[j]) {
                //count += j - start - len; //统计逆序对数目
                sum += nums[i] - nums[j];
                temp[length--] = nums[i--];
            } else {
                temp[length--] = nums[j--];
            }
        }

        while (i >= start) {
            temp[length--] = nums[i--];
        }

        while (j >= start + len + 1) {
            temp[length--] = nums[j--];
        }
        length = end - start + 1;
        for(int k = 0; k < length; k++) {
            nums[start++] = temp[k];
        }

        return sum + leftSum + rightSum;
    }
}
