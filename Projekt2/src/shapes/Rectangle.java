/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

/**
 * Axis aligned rectangle centered on the origin with sides of length a (x) and
 * b (y).
 *
 * @author Michal Szura
 */
public class Rectangle implements Shape {

    float a;//Border X
    float b;//Border Y

    public Rectangle(float a, float b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean contains(float x, float y) {
        if ((x >= (-a / 2)) && (x <= (a / 2)) && (y >= (-b / 2)) && (y <= (b / 2))) {
            return true;
        }
        return false;
    }
}
