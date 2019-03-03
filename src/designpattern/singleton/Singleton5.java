package designpattern.singleton;

/**
 * Created by kimvra on 2019-02-22
 */

//利用enum的绝对单例实现单利模式，推荐用这种方式
public class Singleton5 {

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        return SingleEnum.INSTANCE.getInstance();
    }

    private enum SingleEnum {
        INSTANCE;

        private Singleton5 instance = null;

        SingleEnum() {
            instance = new Singleton5();
        }

        public Singleton5 getInstance() {
            return instance;
        }
    }
}
