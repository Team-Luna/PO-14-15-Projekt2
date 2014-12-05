package visitor;

import shapes.Difference;
import shapes.Ellipse;
import shapes.Intersection;
import shapes.Rectangle;
import shapes.Rotated;
import shapes.Translated;
import shapes.Union;

/**
 *
 * @author Michał Szura
 */
public interface Visitator {

    void visit(Difference v);

    void visit(Ellipse v);

    void visit(Intersection v);

    void visit(Rectangle v);

    void visit(Rotated v);

    void visit(Translated v);

    void visit(Union v);
}
