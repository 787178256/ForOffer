package designpattern.strategey;

/**
 * Created by kimvra on 2019-02-23
 */
public class Client {
    public static void main(String[] args) {
        Duck duck = new Duck();
        QuackBehavior quackBehavior = new Quack();
        duck.setBehavior(quackBehavior);
        duck.perform();

        QuackBehavior quackBehavior1 = new SQuack();
        duck.setBehavior(quackBehavior1);
        duck.perform();
    }
}
