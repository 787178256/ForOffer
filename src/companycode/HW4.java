package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-02
 */
public class HW4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strings = s.split(" ");
        int len = strings.length;
        System.out.println(strings[len - 1]);
    }
}
