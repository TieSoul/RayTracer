package raytracer;

import raytracer.math.Color;
import raytracer.math.Ray;
import raytracer.math.Vector3d;
import raytracer.scene.IntersectionInfo;
import raytracer.scene.Scene;
import raytracer.scene.lights.AmbientLight;
import raytracer.scene.lights.DirectionalLight;
import raytracer.scene.lights.Light;

/**
 * Created by Thijs on 23/11/2015.
 */
public class Material { // a Phong material; includes Phong shading code.
    public Color color;
    public double ambientCoefficient = 0.1;
    public double diffuseCoefficient = 1.0;
    public double specularCoefficient = 0;

    private static final double DELTA = 0.0001d;

    public Color shade(Scene scene, IntersectionInfo intersect) {
        Color result = Color.BLACK;
        for (Light light : scene.lights) {
            if (light instanceof AmbientLight) {
                result = result.add(color.mult(light.color).mult(ambientCoefficient));
            } else if (light instanceof DirectionalLight) {
                Vector3d lightDirection = ((DirectionalLight) light).direction.scale(-1);
                Ray shadowRay = new Ray(intersect.point.translate(lightDirection.scale(DELTA)), lightDirection);
                if (shadowRay.trace(scene).hit)
                    continue;

                double cosAngle = intersect.normal.dotProduct(lightDirection);
                if (cosAngle > 0) {
                    result = result.add(color.mult(light.color).mult(cosAngle * diffuseCoefficient));
                }
            } // TODO: Phong specular lighting, point lights.
        }
        return result.clamp();
    }

    public Material(Color color) {
        this.color = color;
    }
}
