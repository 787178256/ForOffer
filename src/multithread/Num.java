package multithread;

/**
 * Created by kimvra on 2019-03-25
 */
public class Num {
    int i = 1;
    boolean flag = false;


    public static void main(String[] args) {
        Num num = new Num();
        PrintEven printEven = new PrintEven(num);
        PrintOdd printOdd = new PrintOdd(num);
        new Thread(printEven).start();
        new Thread(printOdd).start();
    }
}
