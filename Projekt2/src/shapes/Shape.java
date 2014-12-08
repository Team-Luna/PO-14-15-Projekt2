package shapes;

import java.util.Iterator;
import visitor.Visitator;

/**
 *
 * @author Michal Szura
 */
public interface Shape {

    public boolean contains(float x, float y);

    void accept(Visitator v);

    public String print();
    
    public String toDebugString();

    public Iterator<Shape> iterator();
}
