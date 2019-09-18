package designpattern.observer;

/**
 * Created by kimvra on 2019-09-18
 */
public class HexoObserver extends Observer{

    public HexoObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("HexoObserver accept the update");
        System.out.println(this.subject.getState());
    }
}
