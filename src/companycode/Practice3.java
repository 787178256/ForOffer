package companycode;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-02-27
 */
public class Practice3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num1 = in.next();
        String num2 = in.next();
        BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);
        System.out.println(b1.multiply(b2));
    }
}
