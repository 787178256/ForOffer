package companycode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kimvra on 2019-09-02
 * 寻找最小正整数
 * 给定一个正整数n，找到最小的正整数m，使得m的每一位数字的乘积等于n，m不存在的话，输出0。
 * 504--->789
 * 29--->0
 * 18--->29
 */
public class 网易08 {
    private static int func(int n) {
        if (n == 1) {
            return n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 9; i > 1; i--) {
            while (n % i == 0) {
                list.add(i);
                n = n / i;
            }
        }
        if (n != 1) {
            System.out.println(new ArrayList<>());
            return 0;
        }
        Collections.reverse(list);
        System.out.println(list);
        return 1;
    }

    public static void main(String[] args) {
        func(504);
    }
}
