package raytracer.math;

/**
 * Created by Thijs on 04/10/2015.
 */
public class Point3d {
    public double x, y, z;

    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getDistance(Point3d point) {
        return 0;
    }

    public Point3d translate(Vector3d vector) {
        return null;
    }
}
