package designpattern.templatemethod;

/**
 * Created by kimvra on 2019-03-15
 */
public class Coffee extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Coffee brew");
    }

    @Override
    void addCondiments() {
        System.out.println("Coffee addCondiments");
    }
}
