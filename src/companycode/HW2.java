package companycode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kimvra on 2019-03-01
 */
public class HW2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        Collections.sort(list);
        list.stream().distinct().collect(Collectors.toList()).stream().forEach(integer -> System.out.println(integer));
    }
}
