package raytracer.scene;

import raytracer.math.Point2d;

import java.awt.*;

/**
 * Created by Thijs on 04/10/2015.
 */
public abstract class Camera {
    public int width;
    public int height;
    public abstract Color shootRay(Point2d pixel);
}
