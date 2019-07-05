package leetcode;

/**
 * Created by kimvra on 2019-07-05
 */
public class _0567_Check_Inclusion {
    private boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() > s2.length()) {
            return false;
        }
        int len1 = s1.length();
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for (int j = 0; j < len1; j++) {
            hash1[s1.charAt(j)-'a']++;
            hash2[s2.charAt(j)-'a']++;
        }
        for (int j = len1; j < s2.length(); j++) {
            if (func(hash1, hash2)) {
                return true;
            }
            hash2[s2.charAt(j-len1)-'a']--;
            hash2[s2.charAt(j)-'a']++;
        }
        if (func(hash1, hash2)) {
            return true;
        }
        return false;
    }

    private boolean func(int[] chars1, int[] chars2) {
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }
}
