package raytracer.scene.lights;

import raytracer.math.Color;
import raytracer.math.Point3d;

/**
 * Created by Administrator on 24-11-2015.
 */
public class PointLight extends Light {
    public Point3d location;
    public double r;
    public PointLight(Point3d location, double r) {
        color = Color.WHITE;
        this.location = location;
        this.r = r;
    }
}
