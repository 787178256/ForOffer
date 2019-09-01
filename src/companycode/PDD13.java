package companycode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-01
 */
public class PDD13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String numStr = line.substring(0, line.indexOf(';'));
        String[] nums = numStr.split(",");
        int N = Integer.valueOf(line.substring(line.indexOf(';') + 1));
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (Integer.valueOf(nums[i]) % 2 == 0) {
                list1.add(Integer.valueOf(nums[i]));
            } else {
                list2.add(Integer.valueOf(nums[i]));
            }
        }
        Collections.sort(list1, (x, y) -> (y - x));
        Collections.sort(list2, (x, y) -> (y - x));
        if (list1.size() >= N) {
            for (int i = 0; i < N; i++) {
                if (i == N - 1) {
                    System.out.print(list1.get(i));
                } else {
                    System.out.print(list1.get(i) + ",");
                }
            }
            return;
        } else {
            for (int i = 0; i < list1.size(); i++) {
                System.out.print(list1.get(i) + ",");
            }
            for (int i = 0; i < list2.size() && i < N - list1.size(); i++) {
                if (i == N - list1.size() - 1) {
                    System.out.print(list2.get(i));
                } else {
                    System.out.print(list2.get(i) + ",");
                }
            }
            return;
        }
    }
}
