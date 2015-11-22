package raytracer.math;

import raytracer.scene.IntersectionInfo;
import raytracer.scene.Object3D;
import raytracer.scene.Scene;

import java.awt.*;
import java.util.Vector;

public class Ray {
    public static final double MAX_T = Double.MAX_VALUE;
    public Point3d origin;
    public Vector3d direction;
    public double t;
    Object3D object;

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

    public String toString() {
        return "Ray: (" + origin.x + ", " + origin.y + ", " + origin.z + ") + t(" + direction.x + ", " + direction.y + ", " + direction.z + ")";
    }

    public IntersectionInfo trace(Scene scene){
        IntersectionInfo min_intersect = new IntersectionInfo(this, null, null, Double.POSITIVE_INFINITY, false);
        for (Object3D object : scene.objects) {
            IntersectionInfo intersect = object.intersect(this);
            if (intersect.hit && intersect.t < min_intersect.t) {
                min_intersect = intersect;
            }
        }
        return min_intersect;
    }

    public Color Shade(Vector lights, Vector objects, Color bgnd){
        return object.Shade(this, lights, objects, bgnd);
    }
}
