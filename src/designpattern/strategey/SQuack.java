package designpattern.strategey;

/**
 * Created by kimvra on 2019-02-23
 */
public class SQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("this is SQuack behavior");
    }
}
