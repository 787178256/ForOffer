package multithread;

/**
 * Created by kimvra on 2019-03-29
 */
public class CusThread implements Runnable {

    private Num num;

    private int threadNo;

    private int threadNum;

    private String out;

    public CusThread(int threadNo, Num num, int threadNum, String out) {
        this.threadNo = threadNo;
        this.num = num;
        this.threadNum = threadNum;
        this.out = out;
    }


    @Override
    public void run() {
        while (num.i < 30) {
            synchronized (num) {
                if (num.i % threadNum == threadNo) {
                    //System.out.println("thread" + threadNo + "---" + num.i);
                    System.out.println(out);
                    num.i++;
                    num.notifyAll();
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
