package companycode;


/**
 * Created by kimvra on 2019-08-17
 * HG[3|B[2|CA]]F
 * A[3|B][2|C]
 */
public class Tencent04 {

    private static String decodeStr(String str) {
        if (null == str || str.length() == 0) {
            return str;
        }
        int n = str.length();
        int i = str.indexOf('[');
        int j = str.lastIndexOf(']');
        if (i < 0 || i >= n) {
            return str;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(str, 0, i);
        int num = Integer.parseInt(str.substring(i + 1, str.indexOf('|')));
        for (int u = 0; u < num; ++u) {
            String next = str.substring(str.indexOf('|') + 1, j);
            builder.append(decodeStr(next));
        }
        builder.append(str, j + 1, n);
        return builder.toString();
    }

}
