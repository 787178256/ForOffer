package pat;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-23
 */
public class B1036 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cols = in.nextInt();
        char c = in.next().charAt(0);
        int rows = cols / 2 + (cols % 2 > 0 ? 1 : 0);
        for (int j = 0; j < rows; j++) {
            if (j == 0 || j == rows - 1) {
                for (int i = 0; i < cols; i++) {
                    System.out.print(c);
                }
                System.out.println();
            } else {
                System.out.print(c);
                for (int i = 0; i < cols - 2; i++) {
                    System.out.print(" ");
                }
                System.out.println(c);
            }
        }
    }
}
