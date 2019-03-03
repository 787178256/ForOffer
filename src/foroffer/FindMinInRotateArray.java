package foroffer;

/**
 * Created by kimvra on 2019-03-03
 */
public class FindMinInRotateArray {
    public int solution(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int low = 0, high = array.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
        }
        return array[low];
    }
}
