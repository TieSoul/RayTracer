package raytracer.scene.lights;

import raytracer.math.Color;

/**
 * Created by Thijs on 22/11/2015.
 */
public class AmbientLight extends Light {
    public AmbientLight() {
        color = Color.WHITE;
    }
    public AmbientLight(Color color) {
        this.color = color;
    }
}
