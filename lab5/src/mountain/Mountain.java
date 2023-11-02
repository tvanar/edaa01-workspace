package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {

    private Point a, b, c;

    /**
     * Constructs a
     * 
     * @param point
     * @param alpha the angle of the turtle
     */
    public Mountain(Point a, Point b, Point c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
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
        turtle.moveTo(a.getX(), a.getY());
        fractalLine(turtle, order);
    }

    /*
     * Reursive method: Draws a recursive line of the triangle.
     */
    private void fractalLine(TurtleGraphics turtle, int order) {
        if (order == 0) {
            turtle.forwardTo(b.getX(), b.getY());
            turtle.forwardTo(c.getX(), c.getX());
            turtle.forwardTo(a.getX(), a.getY());
        } else {
            fractalLine(turtle, order - 1);
        }
    }

}
