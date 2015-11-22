package raytracer.tracers;

import raytracer.Tracer;
import raytracer.math.Ray;
import raytracer.scene.IntersectionInfo;
import raytracer.scene.Scene;

import java.awt.*;

/**
 * Created by Thijs on 4-11-2015.
 */
public class Raycaster extends Tracer {

    @Override
    public Color trace_ray(Scene scene, Ray ray) {
        IntersectionInfo intersect = ray.trace(scene);
        if (intersect.t != Double.POSITIVE_INFINITY) return intersect.object.color;
        return null;
    }
}
