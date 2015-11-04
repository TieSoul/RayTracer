package raytracer;

import raytracer.math.Ray;
import raytracer.scene.Scene;

import java.awt.*;

/**
 * Created by Administrator on 4-11-2015.
 */
public abstract class Tracer {
    public abstract Color trace_ray(Scene scene, Ray ray);
}
