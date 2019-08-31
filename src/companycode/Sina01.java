package companycode;

import org.junit.Test;

/**
 * Created by kimvra on 2019-08-31
 */
public class Sina01 {
    private String getMinVersion(String[] list) {
        String res = list[0];
        for (int i = 1; i < list.length; i++) {
            if (!func(res, list[i])) {
                res = list[i];
            }
        }
        return res;
    }

    private boolean func(String str1, String str2) {
        String[] strings1 = str1.split("\\.");
        String[] strings2 = str2.split("\\.");
        boolean res = false;
        int j = 0;
        while (j < strings1.length && j < strings2.length) {
            int a = Integer.valueOf(strings1[j]);
            int b = Integer.valueOf(strings2[j]);
            if (a < b) {
                res = true;
                break;
            }
            j++;
        }
        if (res == false) {
            while (j < strings2.length) {
                int t = Integer.valueOf(strings2[j]);
                if (t != 0) {
                    res = false;
                    break;
                }
                j++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        String[] strings = {"3", "4.3.5.4", "2.10.3", "2.4"};
        System.out.println(getMinVersion(strings));
    }
}
