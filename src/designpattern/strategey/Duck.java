package designpattern.strategey;

/**
 * Created by kimvra on 2019-02-23
 */
public class Duck {

    private QuackBehavior behavior;

    public void perform() {
        if (behavior != null) {
            behavior.quack();
        }
    }

    public void setBehavior(QuackBehavior behavior) {
        this.behavior = behavior;
    }
}
