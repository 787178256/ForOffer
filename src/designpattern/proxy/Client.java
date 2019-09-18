package designpattern.proxy;

/**
 * Created by kimvra on 2019-09-18
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new ProxySubject();
        subject.buyMac();
    }
}
