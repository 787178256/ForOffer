package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-08-16
 */
public class _0077_Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, k, n, 1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int count, int k, int n, int index, List<Integer> list, List<List<Integer>> res) {
        if (count == k) {
            List<Integer> integerList = new ArrayList<>(list);
            res.add(integerList);
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            dfs(count + 1, k, n, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
