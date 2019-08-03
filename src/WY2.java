import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-03
 * 判断左右两数之后大于中间数
 */
public class WY2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[i] = in.nextInt();
            }
        }
    }

    private static void helper(int[] nums) {

    }
}
