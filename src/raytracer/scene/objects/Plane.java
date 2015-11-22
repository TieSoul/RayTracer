package raytracer.scene.objects;

import raytracer.math.Point3d;
import raytracer.math.Ray;
import raytracer.math.Vector3d;
import raytracer.scene.IntersectionInfo;
import raytracer.scene.Object3D;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Thijs on 22/11/2015.
 */
public class Plane extends Object3D {
    public Vector3d normal;
    public Point3d point;

    @Override
    public IntersectionInfo intersect(Ray ray) {
        return null;
    }

    @Override
    public Color Shade(Ray r, Vector lights, Vector objects, Color bgnd) {
        return null;
    }
}
