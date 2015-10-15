package raytracer.scene.objects;

import raytracer.math.Point3d;
import raytracer.math.Ray;
import raytracer.math.Vector3d;
import raytracer.scene.IntersectionInfo;
import raytracer.scene.Object3D;

import java.awt.*;

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
        this.sqrRadius = radius * radius;
        this.color = Color.WHITE;
    }

    public Sphere(Point3d center, double radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.sqrRadius = radius * radius;
        this.color = color;
    }

    //check if the ray intersects the spere
    @Override
    //actually needs to return a double
    public IntersectionInfo intersect(Ray ray) {
        //method missing

        Point3d p = ray.origin;
        Vector3d u = ray.direction;
        Vector3d v = new Vector3d(center, p);
        double t;
        Vector3d normal;
        Point3d intersection;
        boolean incoming;

        //double a = ray.direction.dotProduct(ray.direction);
        double b = 2*(v.dotProduct(u));
        double c = v.dotProduct(v) - sqrRadius;
        double discriminant = b*b - 4*c;


        //return -1 when there isnt even an intersection
        if (discriminant < 0) {
            return new IntersectionInfo(ray, this);
        }

        double discSqrt = Math.sqrt(discriminant);
        double dMin = (-b - discSqrt)/2;
        double dPlus = (-b + discSqrt)/2;

        //if sphere is behind the ray
        if (dMin < 0 && dPlus < 0) {
            return new IntersectionInfo(ray, this);
        }

        //if origin of the ray is inside the sphere
        if (dMin < 0 && dPlus > 0){
            t = dPlus;
            intersection = ray.getEnd(t);
            normal = new Vector3d(intersection, center);
            incoming = false;
        } else {
            t = dMin;
            intersection = ray.getEnd(t);
            normal = new Vector3d(center, intersection);
            incoming = true;
        }

        return new IntersectionInfo(ray, this, normal, intersection, incoming);
    }


}
