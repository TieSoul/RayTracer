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
    public double sqrRadius;

    public Sphere(Point3d center, double radius) {
        this.center = center;
        this.radius = radius;
        double sqrRadius = radius * radius;
    }

    //check if the ray intersects the spere
    @Override
    public IntersectionInfo intersect(Ray ray) {
        double x = center.x - ray.origin.x;
        double y = center.y - ray.origin.y;
        double z = center.z - ray.origin.z;
        double v = ray.direction.dotProduct(x, y, z);

        //check if the ray intersects
        //double t = sqrRadius
        return null;
    }
}
