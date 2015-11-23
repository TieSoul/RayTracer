package raytracer.scene.lights;

import raytracer.math.Color;
import raytracer.math.Vector3d;

/**
 * Created by Thijs on 23/11/2015.
 */
public class DirectionalLight extends Light {
    public Vector3d direction;
    public DirectionalLight(Vector3d direction) {
        this.direction = direction.normalize();
        color = Color.WHITE;
    }
}
