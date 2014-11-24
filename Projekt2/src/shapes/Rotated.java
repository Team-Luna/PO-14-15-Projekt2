/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 * Shape shape rotated  by angle counterclockwise around point (x,y)
 * @author student
 */
public class Rotated extends Location implements Shape {

    public Rotated(float x, float y, float angle, Shape shape) {       
        setX((float) (x*Math.cos(angle) - y*Math.sin(angle)));
        setY((float) (x*Math.sin(angle) + y*Math.cos(angle)));
    }

    @Override
    public boolean contains(float x, float y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
