package designpattern.observer;

/**
 * Created by kimvra on 2019-09-18
 */
public abstract class Observer {
    protected Subject subject;

    abstract void update();
}
