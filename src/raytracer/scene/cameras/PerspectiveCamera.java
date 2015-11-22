package raytracer.scene.cameras;

import raytracer.math.Point2d;
import raytracer.math.Point3d;
import raytracer.math.Ray;
import raytracer.math.Vector3d;
import raytracer.scene.Camera;

/**
 * Created by Thijs on 05/11/2015.
 */
public class PerspectiveCamera extends Camera {
    public double planeDistance;

    public PerspectiveCamera(double pixelSize, int width, int height, Point3d location, double planeDistance, Point3d lookAt, Vector3d up) {
        this.pixelSize = pixelSize;
        this.width = width;
        this.height = height;
        this.location = location;
        this.planeDistance = planeDistance; // Distance of the plane to the camera.
        localZ = new Vector3d(location, lookAt).normalize();
        localX = up.crossProduct(localZ);
        localY = localX.crossProduct(localZ);
    }

    @Override
    public Ray mapPoint(Point2d pixel) {
        Point3d point = location.translate(localZ.scale(planeDistance))
                                .translate(localX.scale(pixelSize * (pixel.x - 0.5 * (width-1.0)))
                                        .add(localY.scale(pixelSize * (pixel.y - 0.5 * (height - 1.0)))));
        return new Ray(location, new Vector3d(location, point));
    }
}
