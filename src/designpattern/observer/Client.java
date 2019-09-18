package designpattern.observer;

/**
 * Created by kimvra on 2019-09-18
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new Subject();
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        HexoObserver hexoObserver = new HexoObserver(subject);
        subject.setState(1);
        subject.setState(2);
    }
}
