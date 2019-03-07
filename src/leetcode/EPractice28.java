package leetcode;

/**
 * Created by kimvra on 2019-03-06
 */
public class EPractice28 {
    public static int strStr(String hayStack, String needle) {
        if (!hayStack.contains(needle)) {
            return -1;
        }
        return hayStack.indexOf(needle);
    }

    private static int strStr1(String haystack, String needle) {
        int len0 = haystack.length();
        int len1 = needle.length();
        if (len0 < len1) {
            return -1;
        }
        if (len0 == len1) {
            return haystack.equals(needle) ? 0 : -1;
        }
        for (int i = 0; ; i++) {
            if (i + len1 > len0) {
                return -1;
            }
            for (int j = 0; ;j++) {
                if (j == len1) {
                    return i;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        String hayStack = "hello";
        String needle = "ll";
        System.out.println(strStr1(hayStack, needle));
    }
}
