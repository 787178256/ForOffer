package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kimvra on 2019-03-14
 */
public class _0378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int kthSmallest1(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        for (int[] m : matrix) {
            for (int a : m) {
                list.add(a);
            }
        }
        Collections.sort(list);
        return list.get(k - 1);
    }
}
