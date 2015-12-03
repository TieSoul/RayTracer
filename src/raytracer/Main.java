package raytracer;

import raytracer.math.Point3d;
import raytracer.math.Vector3d;
import raytracer.samplers.RegularSampler;
import raytracer.scene.Camera;
import raytracer.scene.Object3D;
import raytracer.scene.Scene;
import raytracer.scene.cameras.PerspectiveCamera;
import raytracer.scene.lights.AmbientLight;
import raytracer.scene.lights.Light;
import raytracer.scene.lights.PointLight;
import raytracer.scene.objects.Plane;
import raytracer.scene.objects.Sphere;
import raytracer.tracers.RayTracer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Thijs on 04/10/2015.
 */
public class Main {

    public static int IMAGE_WIDTH = 1000;
    public static int IMAGE_HEIGHT = 1000;
    public static double PIXEL_SIZE = 0.005;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Scene scene = constructScene();
        BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        frame.getContentPane().add(new JLabel(new ImageIcon(image)));
        frame.setSize(image.getHeight() + frame.getSize().height, image.getWidth() + frame.getSize().width);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        scene.render(image, frame);
        File outFile = new File("image.png");
        try {
            ImageIO.write(image, "png", outFile);
        } catch (Exception e) {
            System.err.println(e.getMessage()); // print any IO errors to stderr.
        }
    }
    public static Scene constructScene() {
        ArrayList<Object3D> objects = new ArrayList<Object3D>();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Sphere reflectiveSphere = new Sphere(new Point3d(2*x - 10, -1, 2 * y - 10), 1);
                reflectiveSphere.material.reflectionCoefficient = 1.0;
                reflectiveSphere.material.specularCoefficient = 1.0;
                reflectiveSphere.material.diffuseCoefficient = 0.4;
                reflectiveSphere.material.ambientCoefficient = 0.0;
                objects.add(reflectiveSphere);
            }
        }
        Sphere reflectiveSphere = new Sphere(new Point3d(0, 2, 0), 1);
        reflectiveSphere.material.reflectionCoefficient = 1.0;
        reflectiveSphere.material.specularCoefficient = 1.0;
        reflectiveSphere.material.diffuseCoefficient = 0.4;
        reflectiveSphere.material.ambientCoefficient = 0.0;
        objects.add(reflectiveSphere);
        Texture planeTexture = new Texture(new File("checkerboard.png"));
        objects.add(new Plane(new Point3d(0, -2, 0), new Vector3d(0, 1, 0), planeTexture));
        Camera camera = new PerspectiveCamera(PIXEL_SIZE, IMAGE_WIDTH, IMAGE_HEIGHT, new Point3d(10, 5, -1), 5, new Point3d(0, 0, 0), new Vector3d(0, 1, 0));
        Tracer tracer = new RayTracer();
        ArrayList<Light> lights = new ArrayList<Light>();
        lights.add(new AmbientLight());
        lights.add(new PointLight(new Point3d(0, 5, 0), 20));
        Scene scene = new Scene(objects, lights, camera, tracer);
        scene.sampler = new RegularSampler(16);
        return scene;
    }
}
