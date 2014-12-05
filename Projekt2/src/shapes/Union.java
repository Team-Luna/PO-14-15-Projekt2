package shapes;

import visitor.Visitator;

/**
 * Union of two shapes
 *
 * @author Michal Szura
 */
public class Union implements Shape {

    Shape a;
    Shape b;

    public Union(Shape shape1, Shape shape2) {
        this.a = shape1;
        this.b = shape2;
    }

    @Override
    public boolean contains(float x, float y) {
        if (a.contains(x, y) || b.contains(x, y)) {
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
            return ">Union \n" + a.print().replace("|", "") + " \n" + b.print() + "+";
        }
        return ">Union \n" + a.print() + " \n" + b.print() + "+";
    }
}
