package shapes;

import java.util.Iterator;
import visitor.Visitator;

/**
 * Shape shape translated by vector (x,y)
 *
 * @author Michal Szura
 */
public class Translated implements Shape, Iterable<Shape> {

    public Shape shape;
    float transX;
    float transY;

    public Translated(float x, float y, Shape shape) {
        this.transX = x;
        this.transY = y;
        this.shape = shape;
    }

    @Override
    public boolean contains(float x, float y) {
        return shape.contains(x - transX, y - transY);
    }

    @Override
    public void accept(Visitator v) {
        v.visit(this);
    }

    @Override
    public String print() {
        return ">Translated(" + transX + "," + transY + ")\n" + shape.print();
    }
    
    @Override
    public Iterator<Shape> iterator() {
        return new ShapeIterator(this);
    }

    @Override
    public String toDebugString() {
        return "Translated";
    }
}
