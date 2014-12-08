/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;
import visitor.ShapePrintVisitor;

/**
 *
 * @author student
 */
public class YYTest {

    @Test
    public void testContains() throws Exception {
        Shape a = new Rectangle(6, 12);
        Shape b = new Translated(3, 0, a);
        Shape c = new Ellipse(6, 6);
        Shape d = new Ellipse(7, 7);
        Shape e = new Intersection(b, c);
        Shape f = new Difference(d, e);
        Shape g = new Ellipse(3, 3);
        Shape h = new Translated(0, 3, g);
        Shape i = new Union(f, h);
        Shape j = new Ellipse(3, 3);
        Shape k = new Translated(0, -3, j);
        Shape l = new Difference(i, k);
        Shape m = new Ellipse(1, 1);
        Shape n = new Translated(0, -3, m);
        Shape o = new Union(l, n);
        Shape p = new Ellipse(1, 1);
        Shape r = new Translated(0, 3, p);
        Shape s = new Difference(o, r);
        Shape t = new Ellipse(12, 8);
        Shape u = new Rotated(0, 0, (float) Math.PI / 6, t);
        Shape yy = new Rotated(0, 0, (float) Math.PI, s);

        Shape test = new Difference(u, yy);

        assertTrue(test.contains(-0.05539f, -2.936f));
        assertTrue(test.contains(-6.112f, -6.85f));
        assertTrue(test.contains(0.01846f, -3.6f));
        assertTrue(test.contains(4.376f, 8.069f));
        assertTrue(test.contains(8.438f, 0.9786f));

        assertFalse(test.contains(2.825f, -0.3508f));
        assertFalse(test.contains(7.626f, -7.884f));
        assertFalse(test.contains(0.09232f, 3.047f));
        assertFalse(test.contains(-6.629f, 1.496f));
        assertFalse(test.contains(-0.277f, -5.004f));
        assertFalse(test.contains(-2.049f, -3.674f));

    }

    @Test
    public void testContainsChaos() throws Exception {

        Shape yy = new Rotated(0, 0, (float) Math.PI,
                new Difference(
                        new Union(
                                new Difference(
                                        new Union(
                                                new Difference(
                                                        new Ellipse(7, 7),
                                                        new Intersection(
                                                                new Translated(3, 0, new Rectangle(6, 12)),
                                                                new Ellipse(6, 6)
                                                        )
                                                ),
                                                new Translated(0, 3, new Ellipse(3, 3))
                                        ),
                                        new Translated(0, -3, new Ellipse(3, 3))
                                ),
                                new Translated(0, -3, new Ellipse(1, 1))
                        ),
                        new Translated(0, 3, new Ellipse(1, 1))
                )
        );

        Shape test = new Difference(
                new Rotated(0, 0, (float) Math.PI / 6, new Ellipse(12, 8)),
                yy);

        assertTrue(test.contains(-0.05539f, -2.936f));
        assertTrue(test.contains(-6.112f, -6.85f));
        assertTrue(test.contains(0.01846f, -3.6f));
        assertTrue(test.contains(4.376f, 8.069f));
        assertTrue(test.contains(8.438f, 0.9786f));

        assertFalse(test.contains(2.825f, -0.3508f));
        assertFalse(test.contains(7.626f, -7.884f));
        assertFalse(test.contains(0.09232f, 3.047f));
        assertFalse(test.contains(-6.629f, 1.496f));
        assertFalse(test.contains(-0.277f, -5.004f));
        assertFalse(test.contains(-2.049f, -3.674f));

    }

    @Test
    public void testPrinting() throws Exception {
        Shape a = new Rectangle(6, 12);
        Shape b = new Translated(3, 0, a);
        Shape c = new Ellipse(6, 6);
        Shape d = new Ellipse(7, 7);
        Shape e = new Intersection(b, c);
        Shape f = new Difference(d, e);
        Shape g = new Ellipse(3, 3);
        Shape h = new Translated(0, 3, g);
        Shape i = new Union(f, h);
        Shape j = new Ellipse(3, 3);
        Shape k = new Translated(0, -3, j);
        Shape l = new Difference(i, k);
        Shape m = new Ellipse(1, 1);
        Shape n = new Translated(0, -3, m);
        Shape o = new Union(l, n);
        Shape p = new Ellipse(1, 1);
        Shape r = new Translated(0, 3, p);
        Shape s = new Difference(o, r);
        Shape t = new Ellipse(12, 8);
        Shape u = new Rotated(0, 0, (float) Math.PI / 6, t);
        Shape yy = new Rotated(0, 0, (float) Math.PI, s);

        Shape test = new Difference(u, yy);

        test.accept(new ShapePrintVisitor());
        System.out.println("--------------");
        i.accept(new ShapePrintVisitor());
    }

    @Test
    public void testIterator() throws Exception {
        Shape a = new Rectangle(6, 12);
        Shape b = new Translated(3, 0, a);
        Shape c = new Ellipse(6, 6);
        Shape d = new Ellipse(7, 7);
        Shape e = new Intersection(b, c);
        Shape f = new Difference(d, e);
        Shape g = new Ellipse(3, 3);
        Shape h = new Translated(0, 3, g);
        Shape i = new Union(f, h);
        Shape j = new Ellipse(3, 3);
        Shape k = new Translated(0, -3, j);
        Shape l = new Difference(i, k);
        Shape m = new Ellipse(1, 1);
        Shape n = new Translated(0, -3, m);
        Shape o = new Union(l, n);
        Shape p = new Ellipse(1, 1);
        Shape r = new Translated(0, 3, p);
        Shape s = new Difference(o, r);
        Shape t = new Ellipse(12, 8);
        Shape u = new Rotated(0, 0, (float) Math.PI / 6, t);
        Shape yy = new Rotated(0, 0, (float) Math.PI, s);

        Shape test = new Difference(u, yy);

        System.out.println("#_#_#_#_#_#_#_#_#_#_#_#");
        i.accept(new ShapePrintVisitor());
        System.out.println("------Iterator--------");
        Iterator<Shape> it = i.iterator();
        while (it.hasNext()) {
            Shape sh = it.next();
            System.out.println(sh.toDebugString());
        }
    }
}
