package leetcode;

/**
 * Created by kimvra on 2019-08-30
 */
public class _0086_Partition {
    private ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode highList = new ListNode(-1);
        ListNode highTemp = highList;
        ListNode lowList = new ListNode(-1);
        ListNode lowTemp = lowList;
        while (head != null) {
            if (head.val < x) {
                lowTemp.next = head;
                lowTemp = lowTemp.next;
            } else {
                highTemp.next = head;
                highTemp = highTemp.next;
            }
            head = head.next;
        }
        highTemp.next = null;
        lowTemp.next = highList.next;
        return lowList.next;
    }

    private ListNode func(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode more = new ListNode(-1);
        ListNode moreHead = more;
        ListNode less = new ListNode(-1);
        ListNode lessHead = less;

        while (head != null){
            if(head.val < x){
                less.next = head;
                less = less.next;
            }else {
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }
        more.next = null;  //这步不要忘记，不然链表就出现环了
        less.next = moreHead.next;
        return lessHead.next;
    }
}
