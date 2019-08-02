package companycode;

import java.util.*;

/**
 * Created by kimvra on 2019-08-01
 */
public class WY07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append('a');
        }
        for (int i = 0; i < m; i++) {
            stringBuilder.append('z');
        }
        boolean[] used = new boolean[m + n];
        StringBuilder sb = new StringBuilder();
        List<String> strings = new ArrayList<>();
        permutation(stringBuilder.toString(), 0, strings, sb, used);
        System.out.println(strings.get(k - 1));
    }

    private static void permutation(String s, int index, List<String> strings, StringBuilder stringBuilder, boolean[] used) {
        if (index == s.length()) {
            if (!strings.contains(stringBuilder.toString()))
                strings.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                permutation(s, index + 1, strings, stringBuilder.append(s.charAt(i)), used);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                used[i] = false;
            }
        }
    }
}
