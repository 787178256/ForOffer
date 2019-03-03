package designpattern.singleton;

/**
 * Created by kimvra on 2019-02-22
 */

//饿汉模式
public class Sinleton2 {

    private Sinleton2() {

    }

    private static Sinleton2 instance = new Sinleton2();

    public static Sinleton2 getInstance() {
        return instance;
    }
}
