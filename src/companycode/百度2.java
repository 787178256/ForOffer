package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-17
 */
public class 百度2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            long n = in.nextLong();
            long m = in.nextLong();
            long k = in.nextLong();
            if (n > m) {
                long t = n;
                n = m;
                m = t;
            }
            long l = 0;
            long r = n;
            long mid;
            while (l <= r) {
                mid = l + r >>> 1;
                if (mid * m <= k) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            l--;
            System.out.println(n - l);
        }
    }
}
