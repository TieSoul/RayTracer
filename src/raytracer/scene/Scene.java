package raytracer.scene;

import raytracer.Tracer;

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
        this.tracer = tracer;
    }

    public void addObject(Object3D object) {
        objects.add(object);
    }

    public void render(BufferedImage image) {

    }
}
