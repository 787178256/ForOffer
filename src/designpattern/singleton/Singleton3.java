package designpattern.singleton;

/**
 * Created by kimvra on 2019-02-22
 */

// 懒汉模式，线程安全，但是效率很低
public class Singleton3 {

    private Singleton3() {

    }

    private static Singleton3 instance = null;

    public synchronized static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
