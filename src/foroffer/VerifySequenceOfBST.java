package foroffer;

/**
 * Created by kimvra on 2019-03-10
 */
public class VerifySequenceOfBST {
    public boolean solution(int[] sequence) {
        int len = sequence.length;
        if (len == 0) {
            return false;
        }
        if (len == 1) {
            return true;
        }
        int end = len - 1;
        return judge(sequence, 0, end);
    }

    private boolean judge(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int i = start;
        while (sequence[i] < sequence[end]) {
            ++i;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[start]) {
                return false;
            }
        }
        return judge(sequence, start, i - 1) && judge(sequence, i, end - 1);
    }
}
