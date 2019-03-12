package companycode;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-10
 */
public class PDD6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        if (s == null || s.length() == 0) {
            return;
        }
        /*if (s.length() == 1) {
            System.out.println(s);
            return;
        }*/
        s = s.toLowerCase();
        /*if (!s.substring(1).contains(String.valueOf(s.charAt(0)))) {
            System.out.println(s.charAt(0));
        } else {
            System.out.println(func(s));
        }*/
        System.out.println(func(s));

    }
    public static char func(String s) {
        List<Character> list = new ArrayList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            list.add(s.charAt(i));
        }
        for (int i = len - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(i) == list.get(j)) {
                    if (list.get(j + 1) - list.get(j) < 0) {
                        list.remove(j);
                        i--;
                    }
                }
            }
        }
        return list.get(0);
    }
}
