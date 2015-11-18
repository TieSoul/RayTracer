package raytracer.tracers;

import raytracer.scene.Surface;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Daan on 18-11-15.
 */
public class RayTracer {
    final static int CHUCKSIZE = 100;
    Vector objectList = new Vector(CHUCKSIZE, CHUCKSIZE);
    Vector lightList = new Vector(CHUCKSIZE, CHUCKSIZE);

    Surface surface = new Surface(0.8d, 0.2d, 0.9d, 0.2d, 0.4d, 0.4d, 10.0d, 0d, 0d, 1d);


}
