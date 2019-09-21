package companycode;

import java.util.*;
/**
 * Created by kimvra on 2019-09-19
 */
public class 小米 {
    public static void func(char[] chars, String stringBuilder, List<String> res, boolean[] used) {
        if (stringBuilder.length() == chars.length) {
            res.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                used[i] = true;
                //stringBuilder.append(chars[i]);
                func(chars, stringBuilder + chars[i], res, used);
                used[i] = false;
                //stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        List<String> res = new ArrayList<>();
        boolean[] used = new boolean[chars.length];
        func(chars, "", res, used);
        System.out.println(res);
    }
}
