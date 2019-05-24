package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kimvra on 2019-05-24
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
 * 示例 1：
 *
 * 输入: ["23:59","00:00"]
 * 输出: 1
 *
 * 备注:
 *
 * 列表中时间数在 2~20000 之间。
 * 每个时间取值在 00:00~23:59 之间。
 *
 *
 *
 */
public class _0539_Find_Min_Difference {
    public static int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (!o1.substring(0, 2).equals(o2.substring(0, 2))) {
                    return o1.substring(0, 2).compareTo(o2.substring(0, 2));
                } else {
                    return o1.substring(3).compareTo(o2.substring(3));
                }
            }
        });
        int len = timePoints.size();
        int minRes = Integer.parseInt(timePoints.get(0).substring(0, 2)) * 60 + Integer.parseInt(timePoints.get(0).substring(3)) +
                60 - Integer.parseInt(timePoints.get(len - 1).substring(3)) + (23 - Integer.parseInt(timePoints.get(len - 1).substring(0, 2))) * 60;

        for (int i = 0; i < len - 1; i++) {
            int tempRes = func(timePoints.get(i), timePoints.get(i + 1));
            if (tempRes < minRes) {
                minRes = tempRes;
            }
        }
        return minRes;
    }

    private static int func(String time1, String time2) {
        return (Integer.parseInt(time2.substring(0, 2)) - Integer.parseInt(time1.substring(0, 2))) * 60 + Integer.parseInt(time2.substring(3)) - Integer.parseInt(time1.substring(3));
    }


    /**
     * 第二种，将每个时间转换为分钟，转换为int数组，进行排序后计算。
     * @param args
     */
    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("23:59", "06:00", "13:13", "11:20");
        System.out.println(findMinDifference(timePoints));
    }
}
