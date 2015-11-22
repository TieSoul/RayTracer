package raytracer.math;

/**
 * Created by Thijs on 04/10/2015.
 */
public class Point2d {
    public double x, y;
    public Point2d(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point2d add(Point2d point) {
        return new Point2d(x + point.x, y + point.y);
    }
}
