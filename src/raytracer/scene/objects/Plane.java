package raytracer.scene.objects;

import raytracer.Material;
import raytracer.math.Color;
import raytracer.math.Point3d;
import raytracer.math.Ray;
import raytracer.math.Vector3d;
import raytracer.scene.IntersectionInfo;
import raytracer.scene.Object3D;

/**
 * Created by Thijs on 22/11/2015.
 */
public class Plane extends Object3D {
    public Vector3d normal;
    public Point3d point;

    public Plane(Point3d point, Vector3d normal) {
        this.point = point;
        this.normal = normal;
        material = new Material(Color.WHITE);
    }

    public Plane(Point3d point, Vector3d normal, Color color) {
        this.point = point;
        this.normal = normal;
        material = new Material(color);
    }

    @Override
    public IntersectionInfo intersect(Ray ray) {
        double t = new Vector3d(point).subtract(new Vector3d(ray.origin)).dotProduct(normal) / ray.direction.dotProduct(normal);
        if (t > 0.0001) {
            Point3d intersection = ray.getEnd(t);
            Vector3d intersectVec = normal;
            if (normal.dotProduct(ray.direction.scale(-1)) < 0) intersectVec = normal.scale(-1);
            return new IntersectionInfo(ray, this, intersectVec, intersection, true);
        }
        return new IntersectionInfo(ray, this);
    }
}
