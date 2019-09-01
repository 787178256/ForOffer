package companycode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-01
 */
public class PDD15 {
    private static List<String> list;
    private static int len;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int S = Integer.valueOf(in.nextLine());
            for (int i = 0; i < S; i++) {
                String s1 = in.nextLine();
                String s2 = in.nextLine();
                list = new ArrayList<>();
                len = s1.length();
                dfs(s1, s2, "", "", 0);
                System.out.println("{");
                for (int j = 0; j < list.size(); j++) {
                    String tmp = list.get(j);
                    for (int k = 0; k < tmp.length(); k++) {
                        if (k == 0) {
                            System.out.print(tmp.charAt(k));
                        } else {
                            System.out.print(" " + tmp.charAt(k));
                        }
                    }
                    System.out.println();
                }
                System.out.println("}");
            }
        }
    }

    private static void dfs(String s1, String s2, String res, String operator, int index) {
        if (index == len) {
            if (res.equals(s2)) {
                list.add(operator);
            }
            return;
        }
        dfs(s1, s2, res, operator + "d", index + 1);
        dfs(s1, s2, s1.charAt(index) + res, operator + "l", index + 1);
        dfs(s1, s2, res + s1.charAt(index), operator + "r", index + 1);
    }
}
