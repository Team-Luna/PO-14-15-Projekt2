package shapes;

import visitor.Visitator;

/**
 *
 * @author Michal Szura
 */
public interface Shape {

    public boolean contains(float x, float y);

    void accept(Visitator v);

    public String print();
}
