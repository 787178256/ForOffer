import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-03
 * 最小字典序，两数之和为奇数则可以交换
 */
public class WY3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] nums = new String[n];
        List<String> jishu = new ArrayList<>();
        List<String> oushu = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums[i] = in.next();
            if (Integer.valueOf(nums[i]) % 2 == 0) {
                oushu.add(nums[i]);
            } else {
                jishu.add(nums[i]);
            }
        }
        if (jishu.isEmpty() || oushu.isEmpty()) {
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    System.out.print(nums[i]);
                } else {
                    System.out.print(nums[i] + " ");
                }
            }
            return;
        }
        Collections.sort(jishu, String::compareTo);
        Collections.sort(oushu, String::compareTo);
        int i = 0, j = 0;
        int count = Math.min(oushu.size(), jishu.size());
        while (i < count && j < count) {
            if (jishu.get(i).compareTo(oushu.get(j)) < 0) {
                System.out.print(jishu.get(i) + " ");
                i++;
            } else {
                System.out.print(oushu.get(j) + " ");
                j++;
            }
        }
        if (i == jishu.size()) {
            while (j < oushu.size()) {
                if (j == oushu.size() - 1) {
                    System.out.print(oushu.get(j));
                    j++;
                } else {
                    System.out.print(oushu.get(j) + " ");
                    j++;
                }
            }

        }
        if (j == oushu.size()) {
            while (i < jishu.size()) {
                if (i == jishu.size() - 1) {
                    System.out.print(jishu.get(i));
                    i++;
                } else {
                    System.out.print(jishu.get(i) + " ");
                    i++;
                }
            }
        }
    }
}
