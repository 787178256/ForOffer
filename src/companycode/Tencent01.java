package companycode;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-04-05
 */
public class Tencent01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        String m = in.next();
        BigInteger sum = new BigInteger(n).divide(new BigInteger(m)).divide(new BigInteger("2"))
                .multiply(new BigInteger(m)).multiply(new BigInteger(m));
        System.out.println(sum);
    }
}
