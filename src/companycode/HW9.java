package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-04
 */
public class HW9 {
    private static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLong()) {
            long input = in.nextLong();
            System.out.println(getResult(input));
        }
    }

    public static String getResult(long ulDataInput) {
        int n = (int) Math.sqrt((double) ulDataInput);
        for (int i = 2; i <= n; i++) {
            if (ulDataInput % i == 0) {
                if (isPrime(i)) {
                    stringBuilder.append(i + " ");
                }
                if (isPrime((int) ulDataInput / i)) {
                    stringBuilder.append(ulDataInput / i + " ");
                }
                getResult(ulDataInput / i);
                break;
            }
        }
        return stringBuilder.toString();
    }

    private static boolean isPrime(int n) {
        if (n <= 3) {
            return true;
        }
        int sqrt = (int) Math.sqrt((double) n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
