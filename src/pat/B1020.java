package pat;

import java.util.*;

/**
 * Created by kimvra on 2019-03-24
 */
class MoonCake implements Comparable<MoonCake> {
    double store;
    double sell;
    double price;

    @Override
    public int compareTo(MoonCake o) {
        return this.price != o.price ? (this.price > o.price ? -1 : 1) : 0;
    }
}

public class B1020 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double D = in.nextDouble();
        ArrayList<MoonCake> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            MoonCake moonCake = new MoonCake();
            moonCake.store = in.nextDouble();
            list.add(moonCake);
        }
        for (int i = 0; i < n; i++) {
            MoonCake moonCake = list.get(i);
            moonCake.sell = in.nextInt();
            moonCake.price = moonCake.sell / moonCake.store;
        }
        Collections.sort(list);
        double ans = 0;
        for (int i = 0; i < n; i++) {
            MoonCake moonCake = list.get(i);
            if (moonCake.store <= D) {
                D -= moonCake.store;
                ans += moonCake.sell;
            } else {
                ans += moonCake.price * D;
                break;
            }
        }
        String s = String.format("%.2f", ans);
        System.out.println(s);
    }
}
