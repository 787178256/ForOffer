package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-04
 */
public class HW10 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        long number;
        while (in.hasNextLong()) {
            number = in.nextLong();
            isPrimeFactor(number);
        }
    }

    private static void isPrimeFactor(long num) {
        long number = num;
        while (number != 1) {
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) {
                    number /= i;
                    System.out.print(i + " ");
                    break;
                }
            }
        }
    }
}
