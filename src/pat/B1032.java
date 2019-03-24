package pat;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-23
 */
public class B1032 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] school = new int[10000010];
        for (int i = 0; i < n; i++) {
            int schoolId = in.nextInt();
            int score = in.nextInt();
            school[schoolId] += score;
        }
        int maxScore = -1, maxId = -1;
        for (int i = 1; i <= n; i++) {
            if (school[i] > maxScore) {
                maxScore = school[i];
                maxId = i;
            }
        }
        System.out.printf(maxId + " " + maxScore);
    }
}
