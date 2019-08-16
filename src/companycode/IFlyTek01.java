package companycode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-16
 */
public class IFlyTek01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        List<Integer> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (Character.digit(c, 10) != -1) {
                list.add(Character.digit(c, 10));
            }
        }
        if (list.size() == 0) {
            System.out.print(-1);
            return;
        }
        Collections.sort(list);
        for (int i : list) {
            System.out.print(i);
        }

    }
}
