package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-08-25
 * 3, 4.3.5.4, 2.10.3, 2.4
 * false 表示 str1 大于 str2
 * true 表示小于
 */
public class KuaiShou1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            for (int i = 0; i < m; i++) {
                String[] strings1 = in.next().split("\\.");
                String[] strings2 = in.next().split("\\.");
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
                            res = true;
                            break;
                        }
                        j++;
                    }
                }
                System.out.println(res);
            }
        }
    }
}
