package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kimvra on 2019-07-20
 */
public class _0424_Character_Replacement {
    private int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0, end = 0, len = s.length(), maxLen = Integer.MIN_VALUE, maxc = 0;
        int[] hash = new int[26];
//        while (start < len) {
//            while (end < len) {
//                maxc = Math.max(maxc, ++hash[s.charAt(end) - 'A']);
//                if (end - start + 1 - maxc > k) {
//                    --hash[s.charAt(end) - 'A'];
//                    break;
//                }
//                end++;
//            }
//            maxLen = Math.max(maxLen, end - start);
//            hash[s.charAt(start) - 'A']--;
//            start++;
//        }
//        System.out.println(maxc + " " + start + " " + end);
//        return maxLen;
        while (end < len) {
            hash[s.charAt(end) - 'A']++;
            maxc = Math.max(maxc, hash[s.charAt(end) - 'A']);
            if (end - start + 1 - maxc > k) {
                hash[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, characterReplacement("AABABBA", 1));
    }
}
