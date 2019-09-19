package designpattern.decorate;

/**
 * Created by kimvra on 2019-09-19
 */
public class Client {
    public static void main(String[] args) {
        Shape cycle = new Cycle();
        ShapeDecorator redCircle = new RedShapeDecoratoe(new Cycle());
        ShapeDecorator redRectangle = new RedShapeDecoratoe(new Rectangle());
        cycle.draw();
        redCircle.draw();
        redRectangle.draw();
    }
}
