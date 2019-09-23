package companycode;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-09-23
 */
public class Cisco {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        s = s.replaceAll("\"", "");
        int startIndex = s.indexOf('<'), endIndex = s.indexOf('>');
        s = s.substring(0, startIndex) + s.substring(endIndex + 1);
        if (!s.contains("%22")) {
            System.out.println(s);
            return;
        }
        startIndex = s.indexOf("%22");
        endIndex = s.lastIndexOf("%22");
        s = s.substring(startIndex + 3, endIndex);
        System.out.println(s);
    }
}
