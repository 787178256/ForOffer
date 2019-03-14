package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-03-14
 */
public class MPractice56 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
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
}
