package leetcode;

/**
 * Created by kimvra on 2019-03-05
 */
public class _0014_Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        int minLen = Integer.MAX_VALUE;
        if (len == 0) {
            return "";
        }
        for (String s : strs) {
            minLen = Math.min(s.length(), minLen);
        }
        for (int i = 0; i < minLen; i++) {
            for (int j = 1; j < len; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"hello", "ee", "elloo"};
        System.out.println(longestCommonPrefix(strings));
    }
}
