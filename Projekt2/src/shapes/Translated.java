/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 * Shape shape translated by vector (x,y)
 *
 * @author Michal Szura
 */
public class Translated implements Shape {

    Shape shape;
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
}
