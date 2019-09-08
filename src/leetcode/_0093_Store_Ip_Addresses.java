package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-07-26
 */
public class _0093_Store_Ip_Addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        //backtrack(0, "", 4, s, res, n);
        dfs(s, 0, "", 4, res, s.length());
        return res;
    }

    private void backtrack(int i, String tmp, int flag, String s, List<String> res, int n) {
        if (i == n && flag == 0) {
            res.add(tmp.substring(0, tmp.length() - 1));
            return;
        }
        if (flag < 0) return;
        for (int j = i; j < i + 3; j++) {
            if (j < n) {
                if (i == j && s.charAt(j) == '0') {
                    backtrack(j + 1, tmp + s.charAt(j) + ".", flag - 1, s, res, n);
                    break;
                }
                if (Integer.parseInt(s.substring(i, j + 1)) <= 255)
                    backtrack(j + 1, tmp + s.substring(i, j + 1) + ".", flag - 1, s, res, n);
            }
        }
    }

    private void dfs(String s, int index, String tmpStr, int count, List<String> res, int len) {
        if (index == len && count == 0) {
            res.add(tmpStr.substring(0, tmpStr.length() - 1));
            return;
        }
        if (count < 0) {
            return;
        }
        for (int i = index; i < len && i < index + 3; i++) {
            if (i == index && s.charAt(i) == '0') {
                dfs(s, i + 1, tmpStr + s.charAt(i) + ".", count - 1, res, len);
                break;
            }
            if (Integer.valueOf(s.substring(index, i + 1)) <= 255) {
                dfs(s, i + 1, tmpStr + s.substring(index, i + 1) + ".", count - 1, res, len);
            }
        }
    }
    @Test
    public void test() {
        System.out.println(restoreIpAddresses("25525511135"));
    }

}
