package multithread;

/**
 * Created by kimvra on 2019-03-25
 */
public class PrintOdd implements Runnable{

    Num num;

    PrintOdd(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (num.i <= 100) {
            synchronized (num) {
                if (num.flag) {
                    System.out.println("偶数--" + num.i);
                    num.i++;
                    num.flag = false;
                    num.notify();
                } else {
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
