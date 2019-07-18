package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kimvra on 2019-03-13
 */
public class _0279_Perfect_Squares {

    public static int numSquare(int n) {
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squareList) {
                if (square > i) {
                    break;
                }
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }


    private static List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while (square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
    }

    private List<Integer> func(int n) {
        List<Integer> res = new ArrayList<>();
        int start = 1;
        int i = 1;
        while (i <= n) {
            res.add(i);
            start++;
            i = start * start;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSquare(12));
    }

    @Test
    public void test() {
        System.out.println(func(19));
        System.out.println(generateSquareList(19));
    }
}
