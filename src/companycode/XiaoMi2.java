package companycode;

/**
 * Created by kimvra on 2019-09-11
 */
public class XiaoMi2 {
    private static String func(String[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            String[] strings = input[i].split(" ");
            for (int j = 0; j < strings.length - 1; j++) {
                if (Integer.valueOf(strings[0]) == 0) {
                    for (int k = j; k < strings.length - 1; k++) {
                        strings[k] = strings[k + 1];
                    }
                    strings[strings.length -1] = 0 + "";
                    j--;
                    continue;
                }
                int l = 1;
                while (j + l < strings.length && Integer.valueOf(strings[j + l]) == 0){
                    l++;
                }
                if (j + l == strings.length){
                    l--;
                }
                if (strings[j].equals(strings[j + l])) {
                    int k1 = Integer.valueOf(strings[j]);
                    k1 = k1 * 2;
                    strings[j] = k1 + "";

                    for (int k = j + 1; k < strings.length - 1; k++) {
                        strings[k] = strings[k + 1];
                    }
                    strings[strings.length - 1] = 0 + "";

                }
            }
            for (int j = 0 ; j < strings.length - 1; j++) {
                stringBuilder.append(strings[j] + " ");
            }
            stringBuilder.append(strings[strings.length - 1]).append("\n");
        }
        return stringBuilder.toString();
    }

    private static void solution(String[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            String[] strings = input[i].split(" ");
            for (int j = 1; j < strings.length; j++) {
                int k = j - 1;
                while (k > 0 && strings[k].equals("0")) {
                    k--;
                }
                if (strings[k].equals(strings[j])) {
                    strings[k] = Integer.valueOf(strings[k]) + Integer.valueOf(strings[k]) + "";
                } else {
                    strings[k] = strings[j];
                }
                strings[j] = "0";
                stringBuilder.append(strings[k] + " ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        String[] input = {"0 0 2 4", "0 2 2 2", "0 4 2 2", "8 8 2 2"};
        solution(input);
    }
}
