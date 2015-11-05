package raytracer.scene.cameras;

import raytracer.math.Point2d;
import raytracer.math.Point3d;
import raytracer.math.Ray;
import raytracer.math.Vector3d;
import raytracer.scene.Camera;

/**
 * Created by Administrator on 4-11-2015.
 */
public class OrthographicCamera extends Camera {

    public OrthographicCamera(double pixelSize, int width, int height, Point3d location) {
        this.pixelSize = pixelSize;
        this.width = width;
        this.height = height;
        this.location = location;
    }

    @Override
    public Ray mapPoint(Point2d pixel) {
        Point3d origin = new Point3d(pixelSize * (pixel.x - 0.5 * (width-1.0)), pixelSize * (pixel.y - 0.5 * (height - 1.0)), 0);
        return new Ray(origin, new Vector3d(0, 0, 1));
    }
}
