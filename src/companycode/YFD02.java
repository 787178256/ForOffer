package companycode;

import java.util.*;

/**
 * Created by kimvra on 2019-08-24
 */
public class YFD02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        for (int i = 0; i < c; i++) {
            int T = in.nextInt();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> (y - x));
            for (int j = 0; j < T; j++) {
                int input = in.nextInt();
                if (input > 0) {
                    priorityQueue.add(input);
                }
            }
            int res = 0;
            while (priorityQueue.size() > 2) {
                int a = priorityQueue.poll() - 1;
                int b = priorityQueue.poll() - 1;
                int t = priorityQueue.poll() - 1;
                if (a > 0) {
                    priorityQueue.add(a);
                }
                if (b > 0) {
                    priorityQueue.add(b);
                }
                if (t > 0) {
                    priorityQueue.add(t);
                }
                res++;
            }
            System.out.println(res);
        }
    }

}
