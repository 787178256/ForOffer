package designpattern.proxy.jdk_proxy;

/**
 * Created by kimvra on 2019-09-18
 */
public class RealSubject implements Subject {
    @Override
    public void speak() {
        System.out.println("speak");
    }

    @Override
    public void sellBooks() {
        System.out.println("sell");
    }
}
