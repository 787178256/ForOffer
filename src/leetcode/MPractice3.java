package leetcode;

/**
 * Created by kimvra on 2019-02-28
 */
public class MPractice3 {
   public int solution(String s) {
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

    public static void main(String[] args) {
        System.out.println(solution1("au"));
    }
}
