package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by kimvra on 2019-03-08
 */
public class _0345_Reverse_Vowels_of_a_String {
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] res = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                res[i++] = ci;
            } else if (!vowels.contains(cj)) {
                res[j--] = cj;
            } else {
                res[i++] = cj;
                res[j--] = ci;
            }
        }
        return new String(res);
    }
}
