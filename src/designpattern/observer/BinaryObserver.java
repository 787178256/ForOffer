package designpattern.observer;

/**
 * Created by kimvra on 2019-09-18
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("BinaryObserver accept update");
        System.out.println(this.subject.getState());
    }
}
