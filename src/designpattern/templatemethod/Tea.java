package designpattern.templatemethod;

/**
 * Created by kimvra on 2019-03-15
 */
public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Tea brew");
    }

    @Override
    void addCondiments() {
        System.out.println("Tea addCondiments");
    }
}
