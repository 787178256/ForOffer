package designpattern.strategey;

/**
 * Created by kimvra on 2019-02-23
 */
public class Quack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("this is quack behavior");
    }
}
