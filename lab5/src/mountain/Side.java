package mountain;

public class Side {
    private Point a, b;

    public Side(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int hashCode() {
        return a.hashCode() + b.hashCode();
    }

    @Override
	public boolean equals(Object obj) {
		if (obj instanceof Side) {
			Side s = (Side) obj;
			return (a.equals(s.a) || b.equals(s.b)) || (a.equals(s.b) || b.equals(s.b));
		} else {
			return false;
		}
	}

    public Point getPointa() {
        return a;
    }

    public Point getPointb() {
        return b;
    }
}
