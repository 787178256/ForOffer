package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by kimvra on 2019-07-03
 */
public class _0207_Course {
    private boolean canFinish(int numCourses, int[][] prerequisite) {
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        int rows = prerequisite.length;
        for (int i = 0; i < rows; i++) {
            inDegree[prerequisite[i][1]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int num = 0;
        while (!queue.isEmpty()) {
            int courseNO = queue.remove();
            num++;
            for (int i = 0; i < rows; i++) {
                if (prerequisite[i][0] == courseNO) {
                    inDegree[prerequisite[i][1]]--;
                    if (inDegree[prerequisite[i][1]] == 0) {
                        queue.add(prerequisite[i][1]);
                    }
                }
            }
        }

        return num == numCourses;
    }



    @Test
    public void test() {
        int numCourses = 3;
        int[][] prerequisite = {{1,0},{2,1}};
        Assert.assertTrue(canFinish(numCourses, prerequisite));
    }
}