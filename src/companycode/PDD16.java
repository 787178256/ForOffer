package companycode;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-01
 */
public class PDD16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] Xi = new int[n];
            int maxXi = 0;
            for (int i = 0; i < n; i++) {
                Xi[i] = in.nextInt();
                if (maxXi < Xi[i]) {
                    maxXi = Xi[i];
                }
            }
            double[] gg = new double[maxXi + 1];
            for (int i = 1; i <= maxXi; i++) {
                gg[i] = 1.0;
            }
            for (int i = 1; i <= maxXi; i++) {
                for (int j = 0; j < n; j++) {
                    if (Xi[j] >= i) {
                        gg[i] *= 1.0 * i / Xi[j];
                    }
                }
            }
            double out = 0.0;
            for (int i = 1; i <= maxXi; i++) {
                out += (gg[i] - gg[i - 1]) * i;
            }
            System.out.printf("%.2f", out);
        }
    }

    private double func(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        double[] lessThan = new double[n + 1];
        for (int i = 1; i <= max; i++) {
            lessThan[i] = 1.0;
        }
        for (int i = 1; i <= max; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] > i) {
                    lessThan[i] *= 1.0 * i / nums[j];
                }
            }
        }
        double res = 0.0;
        for (int i = 1; i <= n; i++) {
            res += 1.0 * i * (lessThan[i] - lessThan[i - 1]);
        }
        System.out.printf("%.2f", res);
        return res;
    }

    @Test
    public void test() {
        int[] Xi = {2,2};
        System.out.println(func(Xi));
    }
}
