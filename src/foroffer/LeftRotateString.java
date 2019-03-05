package foroffer;

/**
 * Created by kimvra on 2019-03-05
 */
public class LeftRotateString {
    public static String solution(String str, int n) {
        int len = str.length();
        if (len == 0) {
            return "";
        }
        n = n % len;
        String s = str.substring(n);
        s = s + str.substring(0, n);
        return s;
    }
}
