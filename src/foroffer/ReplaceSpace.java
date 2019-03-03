package foroffer;

/**
 * Created by kimvra on 2019-03-02
 */
public class ReplaceSpace {
    public static String solution(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("   ");
        System.out.println(solution(stringBuffer));
    }
}
