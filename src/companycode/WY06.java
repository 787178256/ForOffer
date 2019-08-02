package companycode;

import java.util.*;

/**
 * Created by kimvra on 2019-08-02
 */
public class WY06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = in.nextInt();
        }
        int count = 0;
        List<Integer> fromIndex = new ArrayList<>();
        List<Integer> toIndex = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int maxIndex = max(height);
            int minIndex = min(height);
            if (height[maxIndex] - height[minIndex] <= 1) {
                break;
            }
            height[maxIndex]--;
            height[minIndex]++;
            count++;
            fromIndex.add(maxIndex + 1);
            toIndex.add(minIndex + 1);
        }
        System.out.println(height[max(height)] - height[min(height)] + " " + count);
        for (int i = 0; i < count; i++) {
            System.out.println(fromIndex.get(i) + " " + toIndex.get(i));
        }
    }

    private static int max(int[] height) {
        int index = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[index]) {
                index = i;
            }
        }
        return index;
    }

    private static int min(int[] height) {
        int index = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] < height[index]) {
                index = i;
            }
        }
        return index;
    }
}
