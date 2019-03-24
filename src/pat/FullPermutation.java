package pat;

import java.util.*;

/**
 * Created by kimvra on 2019-03-24
 */
public class FullPermutation {
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static void permutationHelper(char[] chars, int index, ArrayList<String> list) {
        if (index == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            Set<Character> charSet = new HashSet<>();
            for (int i = index; i < chars.length; i++) {
                if (i == index || !charSet.contains(chars[i])) {
                    charSet.add(chars[i]);
                    swap(chars, index, i);
                    permutationHelper(chars, index + 1, list);
                    swap(chars, index, i);
                }
            }
        }
    }

    public static ArrayList<String> permutation(String string) {
        ArrayList<String> list = new ArrayList<>();
        if (string != null || string.length() > 0) {
            permutationHelper(string.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(permutation("abc"));
    }
}
