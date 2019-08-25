package companycode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-25
 */
public class KuaiShou3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            String[] nums = str1.split(" ");
            String[] letters = str2.split(" ");
            List<String> list = new ArrayList<>();
            int index1 = 0, index2 = 0;
            for (; index1 < nums.length; index1++) {
                if ((index1+1) % 4 != 0) {
                    list.add(nums[index1]);
                } else {
                    list.add(nums[index1]);
                    if (index2 < letters.length) {
                        list.add(letters[index2]);
                        index2++;
                    }
                }
            }
            while (index2 < letters.length) {
                list.add(letters[index2++]);
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i < list.size()-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
