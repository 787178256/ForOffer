package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-16
 */
public class ByteDance03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int peoples = in.nextInt();
            int[] scores = new int[peoples];
            int count = peoples;
            for (int j = 0; j < peoples; j++) {
                scores[j] = in.nextInt();
            }
            if (peoples <= 2) {
                System.out.println(peoples);
            } else {
                if (scores[0] > scores[1] && scores[0] > scores[peoples - 1]) {
                    count++;
                }
                if (scores[peoples - 1] > scores[peoples - 2] && scores[peoples - 1] > scores[0]) {
                    count++;
                }
                for (int j = 1; j < peoples - 1; j++) {
                    if (scores[j] > scores[j - 1] && scores[j] > scores[j + 1]) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
