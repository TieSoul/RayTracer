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
    //actually needs to return a double
    public IntersectionInfo intersect(Ray ray) {

        //Vector3d L = ray.origin.subtract....;
        double a = ray.direction.dotProduct(ray.direction);
        double b = 2*(ray.direction.dotProduct(L));
        double c = (L.dotProduct(L)) - sqrRadius;

        double discriminant = b*b - 4*a*c;


        //return -1 when there isnt even an intersection
        if (discriminant < 0)
            return -1;

        double discSqrt = Math.sqrt(discriminant);
        double d;

        if (b < 0){
            d = (-b - discSqrt)/2;
        } else {
            d = (-b + discSqrt)/2;
        }

        double t1 = d/a;
        double t2 = c/d;

        if (t1 > t2){
            double temporary = t0;
            t1 = t2;
            t2 = temporary;
        }

        if (t2 < 0)
            return -1;

        if (t1 < 0)
            t = t2;
        else
            t = t1;

        return t;
    }


}
