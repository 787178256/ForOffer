package companycode;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-05
 */
public class PDD2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num1 = in.next();
        String num2 = in.next();
        System.out.println(new BigDecimal(num1).multiply(new BigDecimal(num2)));
    }
}
