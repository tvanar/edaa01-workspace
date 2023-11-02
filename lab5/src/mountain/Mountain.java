package mountain;

import java.util.HashMap;
import java.util.Map;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {

    private Point a, b, c;
    private double deviation;
    private Map<Side, Point> cache = new HashMap<>();

    /**
     * Constructs a
     * 
     * @param point (a,b,c) Stating points of the triangle
     * @param alpha the angle of the turtle
     */
    public Mountain(Point a, Point b, Point c, double deviation) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.deviation = deviation;
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
        fractalLine(turtle, order, a, b, c);
    }

    /*
     * Reursive method: Draws a recursive line of the triangle.
     */
    private void fractalLine(TurtleGraphics turtle, int order, Point a, Point b, Point c) {
        turtle.moveTo(this.a.getX(), this.a.getY());
        if (order == 0) {
            drawTriangle(turtle, a, b, c);
        } else {
            deviation = deviation / 2;

            Point x = midPoint(a, b); // vänster mitt
            Side s1 = new Side(a, b); // reciprok sida
            Point y = midPoint(b, c); // höger mitt
            Side s2 = new Side(b, c); // --||--
            Point z = midPoint(a, c); // botten mitt
            Side s3 = new Side(a, c); // --||--
            fractalLine(turtle, order - 1, a, x, z);
            fractalLine(turtle, order - 1, x, b, y);
            fractalLine(turtle, order - 1, z, y, c);
            fractalLine(turtle, order - 1, x, y, z);
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
                (int) Math.round(((a.getY() + b.getY()) / 2) + RandomUtilities.randFunc(deviation)));
    }

}
