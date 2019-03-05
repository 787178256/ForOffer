package foroffer;

/**
 * Created by kimvra on 2019-03-05
 */
public class ReverseSentence {
    public String solution(String str) {
        if (str.trim().equals("")) {
            return str;
        }
        String[] strings = str.split(" ");
        String s = "";
        for (int i = strings.length - 1; i >= 0; i--) {
            s = s + strings[i];
            if (i > 0) {
                s = s + " ";
            }
        }
        return s;
    }
}
