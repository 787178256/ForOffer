package companycode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kimvra on 2019-03-29
 */
public class Alibaba02 {
    public static void main(String[] args) {
        String[] strings = new String[]{"12", "65", "9", "90"};
        func(strings);

    }

    private static void func(String[] strings) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        Arrays.sort(strings, (String str1, String str2) -> {
            return (str2 + str1).compareTo(str1 + str2);
        });
        for (String s : strings) {
            System.out.print(s);
        }
    }
}
