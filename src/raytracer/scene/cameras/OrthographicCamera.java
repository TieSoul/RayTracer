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

    public OrthographicCamera(double pixelSize, int width, int height, Point3d location, Point3d lookAt, Vector3d up) {
        this.pixelSize = pixelSize;
        this.width = width;
        this.height = height;
        this.location = location;
        localZ = new Vector3d(location, lookAt).normalize();
        localX = up.crossProduct(localZ);
        localY = localX.crossProduct(localZ);
    }

    @Override
    public Ray mapPoint(Point2d pixel) {
        Point3d origin = location.translate(localX.scale(pixelSize * (pixel.x - 0.5 * (width-1.0))).add(localY.scale(pixelSize * (pixel.y - 0.5 * (height - 1.0)))));
        return new Ray(origin, localZ);
    }
}
