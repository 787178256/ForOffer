package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-05
 */
public class HW15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.next();
            String s = "";
            for (int i = 0; i < string.length(); i++) {
                if (!s.contains(string.substring(i, i + 1))) {
                    s += string.substring(i, i + 1);
                }
            }
            System.out.println(s);
        }
    }
}
