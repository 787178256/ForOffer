package leetcode;

/**
 * Created by kimvra on 2019-03-20
 */
public class HPractice10 {
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2))
                    || (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
                    && isMatch(s.substring(1), p));
        }
        return !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
                && isMatch(s.substring(1), p.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a", "."));
    }
}
