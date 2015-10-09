package raytracer.scene.objects;

import raytracer.math.Point3d;
import raytracer.math.Ray;
import raytracer.math.Vector3d;
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

        //Vector3d L = ray.origin.subtract....;
        double a = ray.direction.dotProduct(ray.direction);
        double b = 2*(ray.direction.dotProduct(L));
        double c = (L.dotProduct(L)) - sqrRadius;

        double discriminant = b*b - 4*a*c;

        if (discriminant < 0)
            return -1;

        double discSqrt = Math.sqrt(discriminant);
        double q;

        if (b < 0){
            q = (-b - discSqrt)/2;
        } else {
            q = (-b + discSqrt)/2;
        }
        return null;
    }


}
