package companycode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-24
 */
public class YFD01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        Map<Integer, Integer> mapCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            if (mapCount.containsKey(nums[i])) {
                mapCount.put(nums[i], mapCount.get(nums[i]) + 1);
            } else {
                mapCount.put(nums[i], 1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (mapCount.get(nums[i]) <= m) {
                stringBuilder.append(nums[i] + " ");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.print(stringBuilder.toString());
    }
}
