package designpattern.singleton;

/**
 * Created by kimvra on 2019-02-22
 */

// 使用volatile禁止指令重排
public class Singleton4 {

    private Singleton4() {

    }

    private volatile static Singleton4 instance = null;

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
