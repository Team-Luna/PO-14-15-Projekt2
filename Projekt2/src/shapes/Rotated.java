/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 * Shape shape rotated by angle counterclockwise around point (x,y)
 *
 * @author Michal Szura
 */
public class Rotated implements Shape {

    Shape shape;
    float pointX;
    float pointY;
    float angle;

    public Rotated(float x, float y, float angle, Shape shape) {
        this.shape = shape;
        this.pointX = x;
        this.pointY = y;
        this.angle = angle;
    }

    @Override
    public boolean contains(float x, float y) {
//        (x*Math.cos(angle) - y*Math.sin(angle));
//        (x*Math.sin(angle) + y*Math.cos(angle));
        float newX = (float) (pointX + (x-pointX)*Math.cos(-angle) - (y-pointY)*Math.sin(-angle));
        float newY = (float) (pointY + (x-pointX)*Math.sin(-angle) + (y-pointY)*Math.cos(-angle));
        return shape.contains(newX, newY);
    }
}
