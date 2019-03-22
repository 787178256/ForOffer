package leetcode;

/**
 * Created by kimvra on 2019-03-01
 */
public class _0009_Is_Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int len = s.length();
        for (int i = 0, j = len - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
