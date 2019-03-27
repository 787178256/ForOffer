package pat;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-25
 */
public class B1023 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] count = new int[10];
        for (int i = 0; i < 10; i++) {
            count[i] = in.nextInt();
        }
        for (int i = 1; i < 10; i++) {
            if (count[i] > 0) {
                System.out.print(i);
                count[i]--;
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i);
            }
        }
    }
}
