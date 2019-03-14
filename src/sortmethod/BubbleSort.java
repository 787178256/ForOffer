package sortmethod;

/**
 * Created by kimvra on 2019-03-13
 */
public class BubbleSort {
    public static void sort(int[] nums, int n) {
        int i, j, flag;
        int temp;
        for (i = n - 1; i >= 1;--i) {
            flag = 0;
            for (j = 1; j <= i; j++) {
                if (nums[j - 1] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                return;
            }
        }
    }
}
