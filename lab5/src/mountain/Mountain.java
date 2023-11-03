package mountain;

import java.util.HashMap;
import java.util.Map;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {

    private Point a, b, c;
    private double dev;
    private Map<Side, Point> map;

    /**
     * Constructs a
     * 
     * @param point (a,b,c) Stating points of the triangle
     * @param alpha the angle of the turtle
     */
    public Mountain(Point a, Point b, Point c, double dev) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.dev = dev;
        map = new HashMap<>();
    }

    /**
     * Returns the title
     * 
     * @return the title
     */
    @Override
    public String getTitle() {
        return "Mountain";
    }

    /**
     * Draws the fractal.
     * 
     * @param turtle the turtle graphic object
     */
    @Override
    public void draw(TurtleGraphics turtle) {
        fractalLine(turtle, order, a, b, c, dev);
    }

    /*
     * Reursive method: Draws a recursive line of the triangle.
     */
    private void fractalLine(TurtleGraphics turtle, int order, Point a, Point b, Point c, double dev) {
        Point x;
        Point y;
        Point z;
        if (order == 0) {
            drawTriangle(turtle, a, b, c);
        } else {
            Side ab = new Side(a, b);
            Side bc = new Side(b, c);
            Side ca = new Side(c, a);
            if (!map.containsKey(ab)) {
                x = midPoint(a, b);
                map.put(ab, x);
            } else {
                x = map.get(ab);
            } if (!map.containsKey(bc)) {
                y = midPoint(b, c);
                map.put(bc, y);
            } else {
                y = map.get(bc);
            } if (!map.containsKey(ca)) {
                z = midPoint(c, a);
                map.put(ca,z);
            } else {
                z = map.get(ca);
            }

                // x = midPoint(a, b); // vänster mitt
                // Side s12 = new Side(a, b); // reciprok sida
                // y = midPoint(b, c); // höger mitt
                // Side s23 = new Side(b, c); // --||--
                // z = midPoint(a, c); // botten mitt
                // Side s31 = new Side(a, c); // --||-- 
            
            fractalLine(turtle, order - 1, a, x, z, dev / 2);
            fractalLine(turtle, order - 1, x, b, y, dev / 2);
            fractalLine(turtle, order - 1, z, y, c, dev / 2);
            fractalLine(turtle, order - 1, x, y, z, dev / 2);
        }
    }

    /**
     * Draws a triangle
     * 
     * @param Point corners a,b,c
     */
    private void drawTriangle(TurtleGraphics turtle, Point a, Point b, Point c) {
        turtle.moveTo(a.getX(), a.getY());
        turtle.forwardTo(b.getX(), b.getY());
        turtle.forwardTo(c.getX(), c.getY());
        turtle.forwardTo(a.getX(), a.getY());

    }

    /**
     * Calculates the midpoint between two points
     * 
     * @param Point  a
     * @param Point  b
     * @param Double deviationiation
     * @return Point inbetween a and b
     */
    private Point midPoint(Point a, Point b) {
        return new Point(Math.round((a.getX() + b.getX()) / 2),
                (int) Math.round(((a.getY() + b.getY()) / 2) + RandomUtilities.randFunc(dev)));
    }

}
