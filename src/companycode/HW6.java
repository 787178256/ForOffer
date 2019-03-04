package companycode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-04
 */
public class HW6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(in.nextInt());
            }
            list.stream().distinct().sorted().forEach(integer -> System.out.println(integer));
        }
    }
}
