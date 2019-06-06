package other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-06-06
 * 每隔7个删除一个，求最后剩下的那个
 * 约瑟夫环
 */
public class Ring {
    private static int solution(List<Integer> list) {
        int i = 0;
        while (list.size() > 1) {
            i = (i + 3) % list.size();
            list.remove(i);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(solution(list));
    }
}
