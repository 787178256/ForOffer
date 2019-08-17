package companycode;


/**
 * Created by kimvra on 2019-08-17
 */
public class Tencent06 {
    private int func(int[] work, int [] exercise, int n) {
        int[] dp1 = new int[n];//选择去工作
        int[] dp2 = new int[n];//选择去上班
        dp1[0] = work[0];
        dp2[0] = exercise[0];
        for (int i = 1; i < n; i++) {
            // 选择去上班
            if (work[i - 1] == 0) {
                dp1[i] = Math.max(dp1[i - 1], dp2[i - 1]) + work[i];
            } else {
                dp1[i] = dp2[i - 1] + work[i];
            }

            //选择去健身
            if (exercise[i - 1] == 0) {
                dp2[i] = Math.max(dp2[i - 1], dp1[i - 1]) + exercise[i];
            } else {
                dp2[i] = dp1[i - 1] + exercise[i];
            }
        }
        return n - Math.max(dp1[n - 1], dp2[n - 1]);
    }
}
