package raytracer.tracers;

import raytracer.Tracer;
import raytracer.math.Ray;
import raytracer.scene.IntersectionInfo;
import raytracer.scene.Object3D;
import raytracer.scene.Scene;

import java.awt.*;

/**
 * Created by Administrator on 4-11-2015.
 */
public class Raycaster extends Tracer {

    @Override
    public Color trace_ray(Scene scene, Ray ray) {
        IntersectionInfo min_intersect = new IntersectionInfo(ray, null, null, Double.POSITIVE_INFINITY, false);
        for (Object3D object : scene.objects) {
            IntersectionInfo intersect = object.intersect(ray);
            if (intersect.hit && intersect.t < min_intersect.t) min_intersect = intersect;
        }
        if (min_intersect.t != Double.POSITIVE_INFINITY) return min_intersect.object.color;
        return null;
    }
}
