package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by kimvra on 2019-08-03
 * 堆排超时
 * 使用前缀搜索
 */
public class _0440_Find_Kth_Number {
    private static int findKthNumber(int n, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i <= n; i++) {
            if (i > k) {
                queue.add(String.valueOf(i));
                queue.poll();
            } else {
                queue.add(String.valueOf(i));
            }
        }
        for (String s : queue) {
            System.out.println(s);
        }
        return Integer.valueOf(queue.peek());
    }

    private static int findKthNumber_(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            long step = 0, first = cur, last = cur + 1;
            while (first <= n) {
                step += Math.min(n + 1, last) - first;
                first *= 10;
                last *= 10;
            }
            if (step < k) {
                ++cur;
                k -= step;
            } else {
                cur *= 10;
                --k;
            }
        }
        return cur;
    }
    public static void main(String[] args) {
        System.out.println(findKthNumber_(13, 2));
    }
}
