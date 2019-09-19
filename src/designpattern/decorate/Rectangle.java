package designpattern.decorate;

/**
 * Created by kimvra on 2019-09-19
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
