package designpattern.proxy;

/**
 * Created by kimvra on 2019-09-18
 */
public class RealSubject implements Subject {
    @Override
    public void buyMac() {
        System.out.println("I want to buy a mac");
    }
}
