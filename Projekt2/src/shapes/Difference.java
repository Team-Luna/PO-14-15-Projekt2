/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 * Difference of two shapes
 *
 * @author Michal Szura
 */
public class Difference implements Shape {

    Shape a;
    Shape b;

    public Difference(Shape shape1, Shape shape2) {
        this.a = shape1;
        this.b = shape2;
    }

    @Override
    public boolean contains(float x, float y) {
        if (a.contains(x, y) && !b.contains(x, y)) {
            return true;
        }
        return false;
    }
}
