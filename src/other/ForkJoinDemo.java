package other;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by kimvra on 2019-03-06
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {

    private final int threshold = 5;

    private int first;

    private int last;

    public ForkJoinDemo(int first, int lase) {
        this.first = first;
        this.last = last;
    }


    @Override
    protected Integer compute() {
        int result = 0;
        if (last - first < threshold) {
            for (int i = first; i <= last; i++) {
                result += i;
            }
        } else {
            int mid = first + (last - first) / 2;
            ForkJoinDemo leftTask = new ForkJoinDemo(first, mid);
            ForkJoinDemo rightTask = new ForkJoinDemo(mid + 1, last);
            leftTask.fork();
            rightTask.fork();
            result = leftTask.join() + rightTask.join();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(0, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future result = forkJoinPool.submit(forkJoinDemo);
        System.out.println(result.get());
    }
}
