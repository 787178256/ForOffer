package leetcode;

/**
 * Created by kimvra on 2019-03-08
 */
public class EPractice167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i+1, j+1};
            } else if (sum < target){
                ++i;
            } else {
                --j;
            }
        }
        return null;
    }
}