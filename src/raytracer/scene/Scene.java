package raytracer.scene;

import raytracer.Tracer;
import raytracer.math.Point2d;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thijs on 04/10/2015.
 */
public class Scene {
    public ArrayList<Object3D> objects;
    public Camera camera;
    public Tracer tracer;

    public Scene(ArrayList<Object3D> objects, Camera camera, Tracer tracer) {
        this.objects = objects;
        this.camera = camera;
        camera.scene = this;
        this.tracer = tracer;
    }

    public void addObject(Object3D object) {
        objects.add(object);
    }

    public void render(BufferedImage image, JFrame frame) {
        for (int y = 0; y < camera.height; y++) {
            for (int x = 0; x < camera.width; x++) {
                Color color = tracer.trace_ray(this, camera.mapPoint(new Point2d(x, y)));
                if (color == null) color = camera.backgroundColor;
                image.setRGB(x, y, color.getRGB());
                frame.repaint();
            }
        }
        
    }
}
