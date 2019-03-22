package leetcode;



import java.util.Arrays;
import java.util.Map;

/**
 * Created by kimvra on 2019-03-21
 */
public class _0242_Valid_Anagram {
    public static boolean isAnagram(String s, String t) {
        if (s == null) {
            return t == null;
        }
        int slen = s.length();
        int tlen = t.length();
        if (slen == 0) {
            return tlen == 0;
        }
        if (slen != tlen) {
            return false;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = new String(chars);
        chars = t.toCharArray();
        Arrays.sort(chars);
        t = new String(chars);
        return s.equals(t);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
