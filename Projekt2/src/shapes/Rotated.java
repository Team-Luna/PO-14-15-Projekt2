package shapes;

import visitor.Visitator;

/**
 * Shape shape rotated by angle counterclockwise around point (x,y)
 *
 * @author Michal Szura
 */
public class Rotated implements Shape {

    Shape shape;
    float pointX;
    float pointY;
    float angle;

    public Rotated(float x, float y, float angle, Shape shape) {
        this.shape = shape;
        this.pointX = x;
        this.pointY = y;
        this.angle = angle;
    }

    @Override
    public boolean contains(float x, float y) {
        float newX = (float) (pointX + (x - pointX) * Math.cos(-angle) - (y - pointY) * Math.sin(-angle));
        float newY = (float) (pointY + (x - pointX) * Math.sin(-angle) + (y - pointY) * Math.cos(-angle));
        return shape.contains(newX, newY);
    }

    @Override
    public void accept(Visitator v) {
        v.visit(this);
    }

    @Override
    public String print() {
        return ">Rotated(" + pointX + "," + pointY + "," + angle + ") \n" + shape.print();
    }
}
