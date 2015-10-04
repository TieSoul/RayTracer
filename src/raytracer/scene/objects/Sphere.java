package raytracer.scene.objects;

import raytracer.math.Point3d;
import raytracer.math.Ray;
import raytracer.scene.IntersectionInfo;
import raytracer.scene.Object3D;

/**
 * Created by Thijs on 04/10/2015.
 */
public class Sphere extends Object3D {

    public Point3d center;
    public double radius;

    public Sphere(Point3d center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public IntersectionInfo intersect(Ray ray) {
        return null;
    }
}
