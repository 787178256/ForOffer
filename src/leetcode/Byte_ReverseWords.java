package leetcode;

import java.util.Arrays;

/**
 * Created by kimvra on 2019-07-11
 */
public class Byte_ReverseWords {
    private static String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        s = s.trim();
        String[] strings = s.split(" ");
        int i = 0;
        for (String string : strings) {
            if (!string.equals("")) {
                strings[i++] = string;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = i-1; j >= 0; j--) {
            stringBuilder.append(strings[j]);
            if (j != 0) {
                stringBuilder.append(" ");
            }
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = " hello world  hi";
        String ss = "   ";
        System.out.println(ss.length());
        System.out.println(Arrays.toString(ss.split(" ")));
//        System.out.println(s.trim());
//        String[] ss = new String[]{"hi, hello"};
//        System.out.println(Arrays.toString(ss));
//        String[] strings = s.trim().split(" ");
//        System.out.println(Arrays.toString(strings));
        reverseWords(s.trim());
        //System.out.println(s.trim().split(" "));
    }
}
