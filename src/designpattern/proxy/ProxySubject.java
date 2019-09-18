package designpattern.proxy;

/**
 * Created by kimvra on 2019-09-18
 */
public class ProxySubject implements Subject {
    private RealSubject realSubject;

    @Override
    public void buyMac() {
        realSubject = new RealSubject();
        realSubject.buyMac();
        pay();
    }

    private void pay() {
        System.out.println("pay money");
    }
}
