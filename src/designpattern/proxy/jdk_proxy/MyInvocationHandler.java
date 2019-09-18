package designpattern.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by kimvra on 2019-09-18
 */
public class MyInvocationHandler implements InvocationHandler {

    Subject realSubject;

    MyInvocationHandler(Subject subject) {
        this.realSubject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用代理类");
        if (method.getName().equals("speak")) {
            method.invoke(realSubject, args);
            System.out.println("调用的是卖书的方法");
        } else {
            method.invoke(realSubject, args);
            System.out.println("调用的是讲话的方法");
        }
        return null;
    }
}
