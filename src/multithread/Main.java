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
//        for (int i = 0; i < threadNum; i++) {
//            new Thread(new CusThread(i, num, threadNum, "A")).start();
//        }
        new Thread(new CusThread(0, num, 3, "A")).start();
        new Thread(new CusThread(1, num, 3, "B")).start();
        new Thread(new CusThread(2, num, 3, "C")).start();
    }
}
