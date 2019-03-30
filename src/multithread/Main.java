package multithread;

import java.util.Scanner;

/**
 * Created by kimvra on 2019-03-29
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int threadNum = in.nextInt();
        Num num = new Num();
        num.i = 0;
        for (int i = 0; i < threadNum; i++) {
            new Thread(new CusThread(i, num, threadNum)).start();
        }
    }
}
