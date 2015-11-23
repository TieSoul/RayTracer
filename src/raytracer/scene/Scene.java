package raytracer.scene;

import raytracer.Tracer;
import raytracer.math.Color;
import raytracer.math.Point2d;
import raytracer.samplers.RegularSampler;
import raytracer.samplers.Sampler;
import raytracer.scene.lights.Light;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Thijs on 04/10/2015.
 */
public class Scene {
    public ArrayList<Object3D> objects;
    public ArrayList<Light> lights;
    public Camera camera;
    public Tracer tracer;
    public Sampler sampler = new RegularSampler(1);

    public Scene(Camera camera, Tracer tracer) {
        objects = new ArrayList<Object3D>();
        lights = new ArrayList<Light>();
        this.camera = camera;
        camera.scene = this;
        this.tracer = tracer;
    }

    public Scene(ArrayList<Object3D> objects, Camera camera, Tracer tracer) {
        this.objects = objects;
        lights = new ArrayList<Light>();
        this.camera = camera;
        camera.scene = this;
        this.tracer = tracer;
    }

    public Scene(ArrayList<Object3D> objects, ArrayList<Light> lights, Camera camera, Tracer tracer) {
        this.objects = objects;
        this.lights = lights;
        this.camera = camera;
        camera.scene = this;
        this.tracer = tracer;
    }

    public void addObject(Object3D object) {
        objects.add(object);
    }

    public void addLight(Light light) {
        lights.add(light);
    }

    public void render(BufferedImage image, JFrame frame) {
        for (int y = 0; y < camera.height; y++) {
            for (int x = 0; x < camera.width; x++) {
                Color color = new Color(0, 0, 0);
                for (int i = 0; i < sampler.numSamples; i++) {
                    Point2d sampledPoint = sampler.sampleUnitSquare();
                    Color newColor = tracer.trace_ray(this, camera.mapPoint(new Point2d(x, y).add(sampledPoint)));
                    if (newColor != null) {
                        color = color.add(newColor);
                    } else {
                        color = color.add(camera.backgroundColor);
                    }
                }
                color = color.divide(sampler.numSamples);
                image.setRGB(x, y, color.getRGB());
                frame.repaint();
            }
        }
        
    }
}
