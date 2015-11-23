package raytracer.scene;

import raytracer.Material;
import raytracer.math.Ray;

/**
 * Created by Thijs on 04/10/2015.
 */
public abstract class Object3D {
    public abstract IntersectionInfo intersect(Ray ray);
    public Material material;

}
