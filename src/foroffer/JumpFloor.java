package foroffer;

/**
 * Created by kimvra on 2019-03-03
 */
public class JumpFloor {
    public int solution(int target) {
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return solution(target - 1) + solution(target - 2);
        }
    }
}
