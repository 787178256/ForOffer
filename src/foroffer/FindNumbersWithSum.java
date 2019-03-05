package foroffer;

import java.util.ArrayList;

/**
 * Created by kimvra on 2019-03-05
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> solution(int[] array, int sum) {
        int len = array.length;
        int i = 0, j = len - 1;
        ArrayList<Integer> list  = new ArrayList<>();
        while (i <= j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                break;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
        return list;
    }
}
