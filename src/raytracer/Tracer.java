package raytracer;

import raytracer.math.Color;
import raytracer.math.Ray;
import raytracer.scene.Scene;


/**
 * Created by Thijs on 4-11-2015.
 */
public abstract class Tracer {
    public abstract Color trace_ray(Scene scene, Ray ray);
}
