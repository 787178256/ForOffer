package companycode;

/**
 * Created by kimvra on 2019-08-25
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class KuaiShou2 {
    static boolean canBeOne(int a) {
        HashMap<Long, Boolean> hm = new HashMap<>();
        long m = a;
        long res = 0;
        while (true) {
            while (m != 0) {
                long temp = m % 10;
                res += temp * temp;
                m = m / 10;
            }
            if(res == 1)
                return true;
            if(!hm.getOrDefault(m,false)){
                hm.put(res,true);
                m = res;
                res = 0;
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(func(1));
        System.out.println(func(10));
        System.out.println(func(9));
    }

    private static boolean func(int n) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            int m = 0;
            while (n != 0) {
                int k = n % 10;
                m += k * k;
                n = n / 10;
            }
            if (m == 1) {
                return true;
            } else {
                if (list.contains(m)) {
                    return false;
                } else {
                    list.add(m);
                    n = m;
                }
            }
        }
    }

}