package companycode;

/**
 * Created by kimvra on 2019-03-15
 */
public class Alibaba01 {
    public static boolean solution(String string) {
        if (string == null || string.length() <= 2) {
            return false;
        }
        int a = Character.getNumericValue(string.charAt(0));
        int b = Character.getNumericValue(string.charAt(1));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a).append(b);
        int slen = stringBuilder.toString().length();
        while (slen < string.length()) {
            int sum = a + b;
            stringBuilder.append(sum);
            a = b;
            b = sum;
            slen = stringBuilder.toString().length();
        }
        return stringBuilder.toString().equals(string);
    }

    public static void main(String[] args) {
        System.out.println(solution("2912"));
    }
}
