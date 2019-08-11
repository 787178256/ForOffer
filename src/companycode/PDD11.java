package companycode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-11
 */
public class PDD11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        double avg = (nums[0] + nums[1] + nums[2]) / 3.0;
        double min = (Math.abs(nums[0] - avg) * Math.abs(nums[0] - avg) + Math.abs(nums[1] - avg) * Math.abs(nums[1] - avg) + Math.abs(nums[2] - avg) * Math.abs(nums[2] - avg)) / 3.0;
        for (int i = 0; i < N - 2; i++) {
            double tempAvg = (nums[i] + nums[i + 1] + nums[i + 2]) / 3.0;
            double temp = (Math.abs(nums[i] - tempAvg) * Math.abs(nums[i] - tempAvg) + Math.abs(nums[i + 1] - tempAvg) * Math.abs(nums[i + 1] - tempAvg) + Math.abs(nums[i + 2] - tempAvg) * Math.abs(nums[i + 2] - tempAvg)) / 3.0;
            min = Math.min(min, temp);
        }
        System.out.printf("%.2f", min);
    }
}
