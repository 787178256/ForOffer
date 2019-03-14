package companycode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-13
 */
public class HW01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        while (in.hasNext()) {
            String str1 = in.next();
            String str2 = in.next();
            String str3 = in.next();
            String[] strings1 = str1.split("\\.");
            String[] strings2 = str2.split("\\.");
            String[] strings3 = str3.split("\\.");
            int result1;
            int result2;
            for (int i = 0; i < 4; i++) {
                result1 = Integer.valueOf(strings1[i]) & Integer.valueOf(strings3[i]);
                result2 = Integer.valueOf(strings2[i]) & Integer.valueOf(strings3[i]);
                if (result1 != result2) {
                    flag = false;
                }
                list.add(result1);
            }
            if (flag) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
            for (int i = 0; i < 4; i++) {
                if (i == 3) {
                    System.out.print(list.get(i));
                } else {
                    System.out.print(list.get(i) + ".");
                }
            }
        }
    }
}
