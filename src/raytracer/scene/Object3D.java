package raytracer.scene;

import raytracer.math.Ray;

import java.awt.*;

/**
 * Created by Thijs on 04/10/2015.
 */
public abstract class Object3D {
    public abstract IntersectionInfo intersect(Ray ray);
    public Color color;
}
