package shapes;

import visitor.Visitator;

/**
 * Intersection of two shapes
 *
 * @author Michal Szura
 */
public class Intersection implements Shape {

    Shape a;
    Shape b;

    public Intersection(Shape shape1, Shape shape2) {
        this.a = shape1;
        this.b = shape2;
    }

    @Override
    public boolean contains(float x, float y) {
        if (a.contains(x, y) && b.contains(x, y)) {
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
        if (a instanceof Rectangle || a instanceof Ellipse) {
            return ">Intersection \n" + a.print().replace("|", "") + "\n" + b.print() + "+";
        }
        return ">Intersection \n" + a.print() + "\n" + b.print() + "+";
    }
}
