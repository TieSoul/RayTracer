package raytracer.tracers;

import raytracer.Tracer;
import raytracer.math.Color;
import raytracer.math.Ray;
import raytracer.scene.IntersectionInfo;
import raytracer.scene.Scene;


/**
 * Created by Daan on 18-11-15.
 */
public class RayTracer extends Tracer {

    @Override
    public Color trace_ray(Scene scene, Ray ray) {
        IntersectionInfo intersect = ray.trace(scene);
        if (intersect.t != Double.POSITIVE_INFINITY) {
            return intersect.object.material.shade(scene, intersect);
        }
        return null;
    }
}
