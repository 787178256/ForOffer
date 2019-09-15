package companycode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-15
 */
public class 信用卡中心3 {
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String max = s.replace("?", "9");
        System.out.println(func(Integer.valueOf(max), s));

    }

    private static int func(int max, String s) {
        int i = 0, sum = i * 13 + 5;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while (sum <= max) {
            if (isMatch(String.valueOf(sum), s)) {
                list.add(sum);
                count++;
            }
            i++;
            sum = i * 13 + 5;
        }
        System.out.println(list);
        return count;
    }

    private static boolean isMatch(String s1, String s2) {
        if (s1.length() < s2.length()) {
            int c = s2.length() - s1.length();
            StringBuilder stringBuilder = new StringBuilder();
            while (c > 0) {
                stringBuilder.append("0");
                c--;
            }
            s1 = stringBuilder.append(s1).toString();
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i) || s2.charAt(i) == '?') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
