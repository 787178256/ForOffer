package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kimvra on 2019-06-23
 */
public class _0139_Word_Break {
    private boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] res = new boolean[len+1];
        res[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && wordDict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[len];
    }

    private boolean review(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] res = new boolean[len+1];
        res[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && wordDict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[len];
    }
    @Test
    public void test() {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        Assert.assertTrue(wordBreak(s, wordDict));

        String s1 = "catsandog";
        List<String> wordDict1 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        Assert.assertFalse(wordBreak(s1, wordDict1));
    }
}
