package foroffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kimvra on 2019-02-27
 */
public class Median {
    private ArrayList<Integer> list = new ArrayList<>();

    public void insert(Integer num) {
        list.add(num);
    }

    public Double getMedian() {
        Collections.sort(list);
        int length = list.size();
        if (length % 2 == 1) {
            return list.get(length / 2).doubleValue();
        } else {
            return (list.get(length / 2) + list.get(length / 2 - 1)) / 2.0;
        }
    }
}
