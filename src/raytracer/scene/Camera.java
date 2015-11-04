package raytracer.scene;

import raytracer.math.Point2d;
import raytracer.math.Point3d;
import raytracer.math.Ray;
import raytracer.math.Vector3d;

import java.awt.*;

/**
 * Created by Thijs on 04/10/2015.
 */
public abstract class Camera {
    public Scene scene;
    public int width;
    public int height;
    public Point3d location;
    public Vector3d direction;
    public Color backgroundColor = Color.BLACK;
    public abstract Ray mapPoint(Point2d pixel);
}
