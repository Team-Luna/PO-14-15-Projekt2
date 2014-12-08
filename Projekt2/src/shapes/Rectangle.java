package shapes;

import java.util.Iterator;
import visitor.Visitator;

/**
 * Axis aligned rectangle centered on the origin with sides of length a (x) and
 * b (y).
 *
 * @author Michal Szura
 */
public class Rectangle implements Shape, Iterable<Shape> {

    float a;//Border X
    float b;//Border Y

    public Rectangle(float a, float b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean contains(float x, float y) {
        if ((x >= (-a / 2)) && (x <= (a / 2)) && (y >= (-b / 2)) && (y <= (b / 2))) {
            return true;
        }
        return false;
    }

    @Override
    public void accept(Visitator v) {
        v.visit(this);
    }

    @Override
    public String print() {
        return "Rectangle(" + a + "," + b + ")|";
    }

    @Override
    public Iterator<Shape> iterator() {
        return new ShapeIterator(this);
    }

    @Override
    public String toDebugString() {
        return "Rectangle(" + a + "," + b + ")";
    }
}
