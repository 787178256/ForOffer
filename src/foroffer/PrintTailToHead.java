package foroffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-03-02
 */
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
public class PrintTailToHead {
    public static ArrayList<Integer> solution(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        func(list, listNode);
        return list;
    }

    public static void func(ArrayList<Integer> list, ListNode listNode) {
        if (listNode != null) {
            func(list, listNode.next);
            list.add(listNode.val);
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        System.out.println(solution(listNode));
    }
}
