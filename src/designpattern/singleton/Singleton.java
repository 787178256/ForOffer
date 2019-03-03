package designpattern.singleton;

/**
 * Created by kimvra on 2019-02-22
 */

//懒汉模式(单线程模式下安全，多线程情况下不安全)
public class Singleton {
    private Singleton() {

    }

    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
