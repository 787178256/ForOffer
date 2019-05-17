package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kimvra on 2019-03-14
 */
public class _0056_Merge_Intervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 0) {
            return intervals;
        }

        intervals.sort(Comparator.comparing(Interval::getStart));
        int start = intervals.get(0).getStart();
        int end = intervals.get(0).getEnd();
        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals) {
            if (interval.getStart() <= end) {
                end = Math.max(end, interval.getEnd());
            } else {
                res.add(new Interval(start, end));
                start = interval.getStart();
                end = interval.getEnd();
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    /**
     *
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */
    public List<Interval> reviewSolution(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }

        intervals.sort(Comparator.comparing(Interval::getStart));
        int start = intervals.get(0).getStart();
        int end = intervals.get(0).getEnd();

        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals) {
            if (interval.getStart() <= interval.getEnd()) {
                end = Math.max(end, interval.getEnd());
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
