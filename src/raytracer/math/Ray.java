package raytracer.math;

public class Ray {
    public Point3d origin;
    public Vector3d direction;
    public double t;

    public Ray(Point3d origin, Vector3d direction) {
        this.origin = origin;
        this.direction = direction.normalize();
    }
}
