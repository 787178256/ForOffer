package pat;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-23
 */
public class CodeUp1934 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int x = in.nextInt();
        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
