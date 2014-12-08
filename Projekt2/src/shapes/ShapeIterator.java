/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.OperationNotSupportedException;

/**
 *
 * @author Michał Szura
 */
class ShapeIterator implements Iterator<Shape> {

    private Shape current;
    private boolean hasOtherBranch;
    private Stack<Shape> stack;

    public ShapeIterator(Shape myShape) {
        this.current = myShape;
        this.hasOtherBranch = false;
        this.stack = new Stack();
        init();
    }

    private void init() {
        if (current instanceof Rotated || current instanceof Translated || current instanceof Ellipse || current instanceof Rectangle) {
            hasOtherBranch = false;
        } else {
            hasOtherBranch = true;
        }
    }

    @Override
    public boolean hasNext() {
        if ((current instanceof Ellipse || current instanceof Rectangle) && hasOtherBranch) {// Leaf with other leafs
            return true;
        }
        if (current instanceof Rotated || current instanceof Translated) {//Branch
            return true;
        }
        if (current instanceof Difference || current instanceof Intersection || current instanceof Union) {//Continue traverse
            return true;
        }
        if ((current instanceof Ellipse || current instanceof Rectangle) && !hasOtherBranch) {//End of tree
            return false;
        }
        try {
            throw new OperationNotSupportedException();
        } catch (OperationNotSupportedException ex) {
            Logger.getLogger(ShapeIterator.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Shape next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if ((current instanceof Ellipse || current instanceof Rectangle) && hasOtherBranch) {// Leaf with other leafs
            Shape peek = stack.peek();
            if (peek instanceof Difference) {
                Difference object = (Difference) stack.pop();
                if (stack.empty()) {
                    hasOtherBranch = false;
                }
                current = object.b;
                return current;
            }
            if (peek instanceof Intersection) {
                Intersection object = (Intersection) stack.pop();
                if (stack.empty()) {
                    hasOtherBranch = false;
                }
                current = object.b;
                return current;
            }
            if (peek instanceof Union) {
                Union object = (Union) stack.pop();
                if (stack.empty()) {
                    hasOtherBranch = false;
                }
                current = object.b;
                return current;
            }
            try {
                throw new OperationNotSupportedException();
            } catch (OperationNotSupportedException ex) {
                Logger.getLogger(ShapeIterator.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        if (current instanceof Rotated || current instanceof Translated) {//Branch
            if (current instanceof Rotated) {
                Rotated object = (Rotated) current;
                current = object.shape;
                return current;
            }
            if (current instanceof Translated) {
                Translated object = (Translated) current;
                current = object.shape;
                return current;
            }
        }
        if (current instanceof Difference || current instanceof Intersection || current instanceof Union) {//Continue traverse
            hasOtherBranch = true;
            if (current instanceof Difference) {
                Difference object = (Difference) current;
                stack.add(object);
                current = object.a;
                return current;
            }
            if (current instanceof Intersection) {
                Intersection object = (Intersection) current;
                stack.add(object);
                current = object.a;
                return current;
            }
            if (current instanceof Union) {
                Union object = (Union) current;
                stack.add(object);
                current = object.a;
                return current;
            }
        }
        try {
            throw new OperationNotSupportedException();
        } catch (OperationNotSupportedException ex) {
            Logger.getLogger(ShapeIterator.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void remove() {
        try {
            throw new OperationNotSupportedException();

        } catch (OperationNotSupportedException ex) {
            Logger.getLogger(ShapeIterator.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
