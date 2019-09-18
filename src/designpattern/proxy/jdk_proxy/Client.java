package designpattern.proxy.jdk_proxy;

import java.lang.reflect.Proxy;

/**
 * Created by kimvra on 2019-09-18
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(subject);
        Subject proxy = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, invocationHandler);
        proxy.sellBooks();
        proxy.speak();
    }
}
