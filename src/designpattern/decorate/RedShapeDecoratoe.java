package designpattern.decorate;

/**
 * Created by kimvra on 2019-09-19
 */
public class RedShapeDecoratoe extends ShapeDecorator {

    public RedShapeDecoratoe(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    public void setRedBorder(Shape decoratedShape) {
        System.out.println("Border color: Red");
    }
}
