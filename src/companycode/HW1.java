package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-01
 */
public class HW1 {
    public static int solution(int n) {
        int count = 0;
        while (n >= 2) {
            if (n == 2) {
                count++;
                break;
            }
            count = count + n / 3;
            n = n / 3 + n % 3;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            while (n >= 2) {
                if (n == 2) {
                    count++;
                    break;
                }
                count = count + n / 3;
                n = n / 3 + n % 3;
            }
        }
        System.out.println(count);
    }
}
