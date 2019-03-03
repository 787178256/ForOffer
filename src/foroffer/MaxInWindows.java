package foroffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kimvra on 2019-02-27
 */
public class MaxInWindows {
    public static ArrayList<Integer> solution(int[] num, int size) {
        int n = num.length - size + 1;
        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0) {
            return list;
        }
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                temp.add(num[i + j]);
            }
            list.add(Collections.max(temp));
        }
        return list;
    }


    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        int size = 3;
        System.out.println(solution(num, size));
    }
}
