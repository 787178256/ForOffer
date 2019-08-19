package companycode;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-18
 */
public class RedBook4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //N只魔物
        int T = in.nextInt(); //T个回合
        int M = in.nextInt(); //M点法力
        int[] H = new int[N];
        PriorityQueue<Integer> queue = new PriorityQueue<>((Integer o1, Integer o2)-> (o2 - o1));//大顶堆
        int sum = 0;
        for (int i = 0; i < N; i++) {
            H[i] = in.nextInt();
            queue.add(H[i]);
            sum += H[i];
        }
        int left = 0, right = queue.peek();
        while (left < right) {
            int mid = left + right >>> 1;
            if (check(T, M, mid, queue, sum)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    private static boolean check(int T, int M, int damage, PriorityQueue<Integer> queue, long sum) {
        while (!queue.isEmpty()) {
            if (M > 0) {
                int max = queue.poll();
                sum -= max;
                if (max > damage) {
                    int count = Math.min(max / damage, M);
                    int rest = max - count * damage;
                    sum += rest;
                    queue.add(rest);
                    M -= count;
                    T -= count;
                } else {
                    T--;
                    M--;
                }
                if (T < 0) {
                    return false;
                }
            } else {
                return T >= sum;
            }
        }
        return true;
    }
}
