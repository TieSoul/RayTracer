package raytracer.scene.cameras;

import raytracer.math.Point2d;
import raytracer.math.Point3d;
import raytracer.math.Ray;
import raytracer.math.Vector3d;
import raytracer.scene.Camera;
import raytracer.scene.Scene;

import java.awt.*;

/**
 * Created by Administrator on 4-11-2015.
 */
public class OrthographicCamera extends Camera {
    public double pixelSize;

    /**
     * @param pixelSize the physical width/height of a pixel on the orthographic plane
     * @param width the width of the plane in pixels
     * @param height the height of the plane in pixels
     * @param location the location of the top left of the plane
     */
    public OrthographicCamera(Scene scene, double pixelSize, int width, int height, Point3d location) {
        this.scene = scene;
        this.pixelSize = pixelSize;
        this.width = width;
        this.height = height;
        this.location = location;
    }

    @Override
    public Ray mapPoint(Point2d pixel) {
        Point3d origin = location;
        origin = origin.translate(new Vector3d(pixel.x*pixelSize, pixel.y * pixelSize, 0));
        return new Ray(origin, new Vector3d(0, 0, 1));
    }
}
