package companycode;

import java.util.*;

/**
 * Created by kimvra on 2019-03-10
 */
public class PDD7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // n家银行
        int d = in.nextInt(); // 银行的最小距离d
        if (n == 1) {
            System.out.println(0);
            return;
        }
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> money = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt(); // 坐标
            int b = in.nextInt(); // 金额
            list.add(a);
            map.put(b, a);
            money.add(b);
        }
        Collections.sort(list);
        if (list.get(n - 1) - list.get(0) < d) {
            System.out.println(0);
            return;
        }
        Collections.sort(money);
        for (int i = n - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (Math.abs(map.get(money.get(i)) - map.get(money.get(j))) >= d) {
                    System.out.println(money.get(i) + money.get(j));
                    return;
                }
            }
        }
    }
}
