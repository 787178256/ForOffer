package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by kimvra on 2019-09-25
 */
public class _0452_Find_Min_Arrow_Shots {
    private int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int end = points[0][1];
        int res = 1;
        for (int[] point : points) {
            if (point[0] > end) {
                res++;
                end = point[1];
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));
    }
}
