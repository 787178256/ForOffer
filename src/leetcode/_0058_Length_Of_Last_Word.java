package leetcode;

/**
 * Created by kimvra on 2019-05-04
 */
public class _0058_Length_Of_Last_Word {
    public static int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        String[] strings = s.split(" ");
        int len = strings.length;
        return strings[len - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" "));
    }
}
