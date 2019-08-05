package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kimvra on 2019-08-05
 */
public class _0057_Insert {
    private int[][] insert(int[][] intervals, int[] newInterval) {
        Interval interval = new Interval(newInterval[0], newInterval[1]);
        List<Interval> list = new ArrayList<>();
        for (int[] num : intervals) {
            list.add(new Interval(num[0], num[1]));
        }
        list.add(interval);
        Collections.sort(list, Comparator.comparingInt(Interval::getStart));
        List<Interval> res = helper(list);
        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i).getStart();
            result[i][1] = res.get(i).getEnd();
        }
        return result;
    }

    private List<Interval> helper(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        int start = intervals.get(0).getStart();
        int end = intervals.get(0).getEnd();
        for (Interval interval : intervals) {
            if (interval.getStart() <= end) {
                end = Math.max(interval.getEnd(), end);
            } else {
                res.add(new Interval(start, end));
                start = interval.getStart();
                end = interval.getEnd();
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
