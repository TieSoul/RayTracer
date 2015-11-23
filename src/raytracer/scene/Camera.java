package raytracer.scene;

import raytracer.math.*;


/**
 * Created by Thijs on 04/10/2015.
 */
public abstract class Camera {
    public Vector3d localX;
    public Vector3d localY;
    public Vector3d localZ;
    public double pixelSize;
    public Scene scene;
    public int width;
    public int height;
    public Point3d location;
    public Vector3d lookAt;
    public Vector3d up;
    public Color backgroundColor = Color.BLACK;
    public abstract Ray mapPoint(Point2d pixel);
}
