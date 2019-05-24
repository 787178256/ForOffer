package leetcode;

/**
 * Created by kimvra on 2019-05-21
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class _0067_Add_Binary {
    public static void main(String[] args) {
        System.out.println(addBinary("0", "0"));
       // System.out.println(addBinary("1010", "1011"));
    }
    public static String addBinary(String a, String b) {
        int alen = a.length(), blen = b.length();
        StringBuilder stringBuilder = new StringBuilder();
        int k = 0;
        int i = alen - 1, j = blen - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            int sum = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(j)) + k;
            k = sum / 2;
            sum = sum % 2;
            stringBuilder.append(sum + "");
        }
        while (i >= 0) {
            int sum = Character.getNumericValue(a.charAt(i)) + k;
            k = sum / 2;
            sum = sum % 2;
            stringBuilder.append(sum + "");
            i--;
        }
        while (j >= 0) {
            int sum = Character.getNumericValue(b.charAt(j)) + k;
            k = sum / 2;
            sum = sum % 2;
            stringBuilder.append(sum + "");
            j--;
        }
        if (k != 0) {
            stringBuilder.append(k + "");
        }
        return stringBuilder.reverse().toString();
    }
}
