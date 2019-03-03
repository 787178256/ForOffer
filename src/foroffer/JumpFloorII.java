package foroffer;

/**
 * Created by kimvra on 2019-03-03
 */
public class JumpFloorII {
    public int solution(int target) {
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * solution(target - 1);
        }
    }
}
