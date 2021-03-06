/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.util.Iterator;
import visitor.Visitator;

/**
 * Axis aligned ellipse centered on the origin with semi-axes of length a (x)
 * and b (y).
 *
 * @author Michal Szura
 */
public class Ellipse implements Shape, Iterable<Shape> {

    float a;//X Radius
    float b;//Y Radius

    public Ellipse(float a, float b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean contains(float x, float y) {
        double part1 = Math.pow(x, 2) / Math.pow(a, 2);
        double part2 = Math.pow(y, 2) / Math.pow(b, 2);
        if ((part1 + part2) <= 1) {
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
        return "Ellipse(" + a + "," + b + ")|";
    }

    @Override
    public Iterator<Shape> iterator() {
        return new ShapeIterator(this);
    }

    @Override
    public String toDebugString() {
        return "Ellipse(" + a + "," + b + ")";
    }
}
