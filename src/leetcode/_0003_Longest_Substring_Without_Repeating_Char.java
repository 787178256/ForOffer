package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-02-28
 */
public class _0003_Longest_Substring_Without_Repeating_Char {
   public static int solution(String s) {
       int len;
       if (s == null || (len = s.length()) == 0) {
           return 0;
       }
       int preP = 0, max = 0;
       int[] hash = new int[128];
       for (int i = 0; i < len; i++) {
           char c = s.charAt(i);
           if (hash[c] > preP) {
               preP = hash[c];
           }
           int l = i - preP + 1;
           hash[c] = i + 1;
           if (l > max) {
               max = l;
           }
       }
       return max;
   }

   private int review(String s) {
       int len;
       if (s == null || (len = s.length()) == 0) {
           return 0;
       }
       int pre = 0;
       int max = 0;
       int[] hash = new int[26];
       for (int i = 0; i < len; i++) {
           char c = s.charAt(i);
           if (hash[c - 'a'] > pre) {
               pre = hash[c - 'a'];
           }
           int l = i - pre + 1;
           hash[c - 'a'] = i + 1;
           if (l > max) {
               max = l;
           }
       }
       return max;
   }

   public static int solution1(String s) {
       if (s == null || s.length() == 0) {
           return 0;
       }
       if (s.length() == 1) {
           return 1;
       }
       int max = 0;
       int length = s.length();
       for (int i = 0, j = 1; i < length & j < length;) {
           if (s.substring(i, j).contains(String.valueOf(s.charAt(j)))) {
               int l = j - i;
               if (l > max) {
                   max = l;
               }
               i++;
               j = i + 1;
           } else {
               if (j + 1 == length) {
                   int l = j - i + 1;
                   return l > max ? l : max;
               } else  {
                   j++;
               }

           }
       }
       return max;
   }

   private int slidingWindow(String s) {
       if (s == null || s.length() == 0) {
           return 0;
       }
       List<Character> list = new ArrayList<>();
       int start = 0, end = 0, len = s.length(), maxLen = Integer.MIN_VALUE;
       while (start < len) {
           while (end < len && !list.contains(s.charAt(end))) {
               list.add(s.charAt(end));
               end++;
           }
           int l = end - start;
           if (l > maxLen) {
               maxLen = l;
           }
           list.remove((Character) s.charAt(start++));
       }
       return maxLen;
   }
    public static void main(String[] args) {
        System.out.println(solution("abcabcbb"));
    }

    @Test
    public void test() {
       Assert.assertEquals(3, slidingWindow("abcabcbb"));
    }
}
