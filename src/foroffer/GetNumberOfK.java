package foroffer;

import org.junit.Test;

/**
 * Created by kimvra on 2019-08-27
 */
public class GetNumberOfK {
    private int count = 0;
    public int getNumberOfK(int[] array, int k) {
        return func(array, k, 0, array.length - 1);
    }

    private int func(int[] array, int k, int left, int right) {
        while (left <= right) {
            int mid = left + right >>> 1;
            if (array[mid] == k) {
                return 1 + func(array, k, mid + 1, right) + func(array, k, left, mid - 1);
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] array = {1,2,2,3,3,3};
        System.out.println(getNumberOfK(array, 2));
    }

}
