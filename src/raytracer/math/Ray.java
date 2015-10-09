package raytracer.math;

public class Ray {
    public Point3d origin;
    public Vector3d direction;
    public double t;

    public Ray(Point3d origin, Vector3d direction) {
        this.origin = origin;
        this.direction = direction.normalize();
    }


    public Point3d getEnd(double t){
        return origin.translate(direction.scale(t));
        // ? origin + (direction vector * t)
    }

    public Point3d getEnd(){
        return getEnd(this.t);
    }
}
