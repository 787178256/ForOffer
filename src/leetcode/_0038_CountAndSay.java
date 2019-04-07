package leetcode;

/**
 * Created by kimvra on 2019-04-07
 */
public class _0038_CountAndSay {
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String[] strings = new String[n + 1];
        strings[1] = "1";
        for (int i = 2; i <= n; i++) {
            strings[i] =  next(strings[i - 1]);
        }
        return strings[n];
    }

    private static String next(String s) {
        int len = s.length();
        String res = "";
        for (int i = 0; i < len;) {
            int j = i + 1;
            int count = 1;
            while (j < len && s.charAt(i) == s.charAt(j)) {
                count++;
                j++;
            }
            res = res + count + s.charAt(i);
            i = i + count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
