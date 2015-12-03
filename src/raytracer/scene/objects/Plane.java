package raytracer.scene.objects;

import raytracer.Material;
import raytracer.Texture;
import raytracer.math.*;
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
        this.material = new Material(Color.WHITE);
    }

    public Plane(Point3d point, Vector3d normal, Color color) {
        this.point = point;
        this.normal = normal;
        this.material = new Material(color);
    }

    public Plane(Point3d point, Vector3d normal, Texture texture) {
        this.point = point;
        this.normal = normal;
        this.material = new Material(texture);
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

    @Override
    public Point2d getTexturePoint(Point3d point) {
        Vector3d localZ = normal;
        Vector3d helpVector = new Vector3d(1, 0, 0);
        if (normal.x == helpVector.x) helpVector = new Vector3d(0, 1, 0);
        Vector3d localY = helpVector.crossProduct(localZ);
        Vector3d localX = localZ.crossProduct(localY);
        double xComponent = localX.dotProduct(new Vector3d(point).subtract(new Vector3d(this.point)));
        double yComponent = localY.dotProduct(new Vector3d(point).subtract(new Vector3d(this.point)));

        xComponent = (xComponent % material.textureSize) / material.textureSize;
        yComponent = (yComponent % material.textureSize) / material.textureSize;
        if (xComponent < 0) xComponent = 1 + xComponent;
        if (yComponent < 0) yComponent = 1 + yComponent;
        return new Point2d(xComponent, yComponent);
    }
}
