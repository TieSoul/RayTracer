package raytracer.scene;

import raytracer.math.Ray;

/**
 * Created by Thijs on 04/10/2015.
 */
public class IntersectionInfo {
    public boolean hit;
    public double distance;
    public Object3D object;
    public Ray ray;
}
