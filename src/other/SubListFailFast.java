package other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kimvra on 2019-03-12
 */
public class SubListFailFast implements Runnable {

    private static List<Integer> list = new ArrayList<>();

    @Override
    public void run() {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
