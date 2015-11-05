package raytracer;

import com.sun.javafx.iio.ImageStorage;
import raytracer.math.Point2d;
import raytracer.math.Point3d;
import raytracer.math.Vector3d;
import raytracer.scene.Camera;
import raytracer.scene.Object3D;
import raytracer.scene.Scene;
import raytracer.scene.cameras.OrthographicCamera;
import raytracer.scene.objects.Sphere;
import raytracer.tracers.Raycaster;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Thijs on 04/10/2015.
 */
public class Main {
    public static int IMAGE_WIDTH = 400;
    public static int IMAGE_HEIGHT = 400;
    public static double PIXEL_SIZE = 0.01;
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
    }
    public static Scene constructScene() {
        ArrayList<Object3D> objects = new ArrayList<>();
        objects.add(new Sphere(new Point3d(0, 0, 2), 1, Color.RED));
        objects.add(new Sphere(new Point3d(0, 0, 5), 1, Color.YELLOW));
        Camera camera = new OrthographicCamera(PIXEL_SIZE, IMAGE_WIDTH, IMAGE_HEIGHT, new Point3d(0, 0, 0));
        Tracer tracer = new Raycaster();
        return new Scene(objects, camera, tracer);
    }
}
