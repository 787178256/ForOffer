package companycode;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-03
 */
public class WY1 {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0.000000");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//班级人数
        int[] nums = new int[n];//成绩
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int q = in.nextInt();//问询次数
        for (int i = 0; i < q; i++) {
            int index = in.nextInt();
            int grade = nums[index - 1];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] <= grade) {
                    count++;
                }
            }
            double res = (double) (count - 1) / n * 100;
            System.out.println(decimalFormat.format(res));
        }
    }
}
