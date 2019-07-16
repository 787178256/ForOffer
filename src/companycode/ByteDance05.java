package companycode;

/**
 * Created by kimvra on 2019-07-16
 * 单例模式
 */
public class ByteDance05 {

    private static ByteDance05 byteDance05 = new ByteDance05();

    private ByteDance05() {

    }

    public ByteDance05 getSing() {
        return byteDance05;
    }
}

class Singleton {

    private static Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class Singleton1 {

    private volatile static Singleton1 instance = null;

    private Singleton1() {

    }

    public Singleton1 getInstance() {
        if (instance == null) {
            synchronized (Singleton1.class) {
                if (instance == null) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}

class Singleton2 {

    private Singleton2() {

    }

    public Singleton2 getInstance() {
        return ENUM.INSTANCE.getInstance();
    }

    enum ENUM{
        INSTANCE;

        private Singleton2 instance;

        ENUM() {
            instance = new Singleton2();
        }

        Singleton2 getInstance() {
            return instance;
        }
    }
}
