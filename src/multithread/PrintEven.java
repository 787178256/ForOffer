package multithread;

/**
 * Created by kimvra on 2019-03-25
 */
public class PrintEven implements Runnable{

    Num num;

    PrintEven(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (num.i <= 100) {
            synchronized (num) {
                if (num.flag) {
                    try {
                        num.wait();
                    } catch (Exception e) {

                    }
                } else {
                    System.out.println("奇数-----" + num.i);
                    num.i++;
                    num.flag = true;
                    num.notify();
                }
            }
        }
    }
}
