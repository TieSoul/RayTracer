package raytracer.math;

/**
 * Created by Thijs on 04/10/2015.
 */
public class Vector3d {
    public double x, y, z;

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3d(Point3d point) {
        this.x = point.x;
        this.y = point.y;
        this.z = point.z;
    }

    public Vector3d(Point3d from, Point3d to) {
        this.x = to.x - from.x;
        this.y = to.y - from.y;
        this.z = to.z - from.z;
    }

    public Vector3d normalize() { // makes length of vector 1 with the same direction.
        return null;
    }

    public Vector3d add(Vector3d vector) {
        return null;
    }

    public double dotProduct(Vector3d B) {
        return (x*B.x + y*B.y + z*B.y);
    }

    public Vector3d crossProduct(Vector3d vector) {
        return null;
    }

    public Vector3d subtract(Vector3d vector) {
        return null;
    }

    public Vector3d scale(double d) {
        return null;
    }

    public double getLength() {
        return Math.sqrt(x+x + y*y + z*z);
    }
}
