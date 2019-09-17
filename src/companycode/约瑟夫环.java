package companycode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kimvra on 2019-09-17
 */
public class 约瑟夫环 {
    private int func(List<Integer> list, int k) {
        int i = 0;
        while (list.size() > 1) {
            i = (i + k) % list.size();
            list.remove(i);
        }
        System.out.println(list.get(0));
        return list.get(0);
    }

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        func(list, 3);
    }
}
