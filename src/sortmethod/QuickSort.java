package sortmethod;

/**
 * Created by kimvra on 2019-03-13
 */
public class QuickSort {
    public static void sort(int[] nums, int low, int high) {
        int temp;
        int i = low, j = high;
        if (low < high) {
            temp = nums[low];
            while (i != j) {
                while (j > i && nums[j] > temp) {
                    --j;
                }
                if (j > i) {
                    nums[i] = nums[j];
                    ++i;
                }
                while (j > i && nums[i] < temp) {
                    ++i;
                }
                if (j > i) {
                    nums[j] = nums[i];
                    --j;
                }
            }
            nums[i] = temp;
            sort(nums, low, i - 1);
            sort(nums, i + 1, high);
        }
    }
}
