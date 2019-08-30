package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-08-30
 */
public class _0089_Gray_Code {
    private List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i) {
            res.add(i ^ i >> 1);
        }
        System.out.println(res);
        return res;
    }
    @Test
    public void test() {
        System.out.println(grayCode(3));
    }
}
