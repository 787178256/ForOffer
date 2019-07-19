package leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Created by kimvra on 2019-07-17
 */
public class _0239_Max_Sliding_Window {
    private int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        int[] res = new int[len - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (Integer o1, Integer o2)-> (o2 - o1));
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res[0] = queue.peek();
        for (int i = 1; i <= len - k; i++) {
            queue.remove(nums[i - 1]);
            queue.add(nums[i + k - 1]);
            res[i] = queue.peek();
        }
        return res;
    }

    private int[] WindowSolution(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        Window window = new Window();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                window.pop(nums[i - k + 1]);
                res[i - k + 1] = window.max();
            }
        }
        return res;
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(3,(Integer o1, Integer o2)-> (o2 - o1));
        queue.add(1);
        queue.add(3);
        System.out.println(queue.peek());
        queue.add(2);
        System.out.println(queue.peek());
        queue.add(4);
        System.out.println(queue.peek());
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(WindowSolution(nums, 3)));
    }
}
class Window {
    private ArrayDeque<Integer> deque = new ArrayDeque<>();

    public int max() {
        return deque.getFirst();
    }

    public void push(int n) {
        while (!deque.isEmpty() && deque.getLast() <= n) {
            deque.removeLast();
        }
        deque.push(n);
    }

    public void pop(int n) {
        if (!deque.isEmpty() && deque.getFirst() == n) {
            deque.removeFirst();
        }
    }
}

class W {
    private ArrayDeque<Integer> deque;

    public void push(int num) {
        if (deque.isEmpty()) {
            deque.push(num);
        }
        while (!deque.isEmpty() && num > deque.getLast()) {
            deque.removeLast();
        }
        deque.push(num);
    }

    public void pop(int num) {
        if (!deque.isEmpty() && deque.getFirst() == num) {
            deque.removeFirst();
        }
    }

    public int max() {
        return deque.getFirst();
    }
}
