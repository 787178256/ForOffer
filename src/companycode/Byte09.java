package companycode;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by kimvra on 2019-09-15
 * 3
 * 3 3
 * 1 3
 * 2 3
 */
public class Byte09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int finishTime = 0, max = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            int c = in.nextInt();
            map.put(t, c);
        }
        System.out.println(map);
        for (Map.Entry entry : map.entrySet()) {
            Integer t = (Integer) entry.getKey();
            Integer c = (Integer) entry.getValue();
            if (t < finishTime) {
                max = Math.max(max, finishTime - t + c);
                finishTime = finishTime + c;
            } else {
                finishTime = t + c;
                max = Math.max(c, max);
            }
        }
        System.out.println(finishTime);
        System.out.println(max);
    }
}
