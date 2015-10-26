package raytracer.scene;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thijs on 04/10/2015.
 */
public class Scene {
    public ArrayList<Object3D> objects;
    public Camera camera;

    public Scene(ArrayList<Object3D> objects, Camera camera) {
        this.objects = objects;
        this.camera = camera;
    }

    public void addObject(Object3D object) {
        objects.add(object);
    }
}
