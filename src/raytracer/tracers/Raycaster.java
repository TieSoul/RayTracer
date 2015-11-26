package raytracer.tracers;

import raytracer.Tracer;
import raytracer.math.Color;
import raytracer.math.Ray;
import raytracer.scene.IntersectionInfo;
import raytracer.scene.Scene;


/**
 * Created by Thijs on 4-11-2015.
 */
public class Raycaster extends Tracer {

    @Override
    public Color trace_ray(Scene scene, Ray ray) {
        IntersectionInfo intersect = ray.trace(scene);
        if (intersect.t != Double.POSITIVE_INFINITY) return intersect.object.material.getColor(intersect);
        return null;
    }
}
