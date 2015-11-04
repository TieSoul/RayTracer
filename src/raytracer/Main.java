package raytracer;

import raytracer.math.Point2d;
import raytracer.math.Point3d;
import raytracer.scene.Scene;
import raytracer.scene.cameras.OrthographicCamera;

/**
 * Created by Thijs on 04/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        OrthographicCamera camera = new OrthographicCamera(constructScene(), 0.1, 20, 20, new Point3d(0, 0, 0));
        System.out.println(camera.mapPoint(new Point2d(20, 20)));
    }
    public static Scene constructScene() {
        return null; // make scene construction code here later.
    }
}
