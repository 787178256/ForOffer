package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-02
 */
public class HW5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String s = in.next();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equalsIgnoreCase(s)) {
                ++count;
            }
        }
        System.out.println(count);
    }
}
