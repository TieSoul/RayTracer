package raytracer;

import raytracer.math.Color;
import raytracer.math.Ray;
import raytracer.math.Vector3d;
import raytracer.scene.IntersectionInfo;
import raytracer.scene.Scene;
import raytracer.scene.lights.AmbientLight;
import raytracer.scene.lights.DirectionalLight;
import raytracer.scene.lights.Light;
import raytracer.scene.lights.PointLight;

/**
 * Created by Thijs on 23/11/2015.
 */
public class Material { // a Phong material; includes Phong shading code.
    public Color color;
    public double ambientCoefficient = 0.1;
    public double diffuseCoefficient = 1.0;
    public double specularCoefficient = 0;
    public double reflectionCoefficient = 0;

    private static final double DELTA = 0.0001d;
    private static final int MAXDEPTH = 10;

    public Color shade(Scene scene, IntersectionInfo intersect, int depth) {
        Color result = Color.BLACK;
        for (Light light : scene.lights) {
            if (light instanceof AmbientLight) {
                result = result.add(color.mult(light.color).mult(ambientCoefficient));
            } else if (light instanceof DirectionalLight) {
                Vector3d lightDirection = ((DirectionalLight) light).direction.scale(-1);
                Ray shadowRay = new Ray(intersect.point.translate(lightDirection.scale(DELTA)), lightDirection);
                IntersectionInfo shadowIntersect = shadowRay.trace(scene);
                if (shadowIntersect.hit)
                    continue;

                double cosAngle = intersect.normal.dotProduct(lightDirection);
                if (cosAngle > 0) {
                    result = result.add(color.mult(light.color).mult(cosAngle * diffuseCoefficient));
                    if (specularCoefficient > 0) {
                        Vector3d r = lightDirection.scale(-1).add(intersect.normal.scale(2*cosAngle));
                        result = result.add(color.mult(light.color).mult(intersect.ray.direction.scale(-1).dotProduct(r) * specularCoefficient));
                    }
                }
            } else if (light instanceof PointLight) {
                Vector3d lightDirection = new Vector3d(intersect.point, ((PointLight) light).location).normalize();
                Ray shadowRay = new Ray(intersect.point.translate(lightDirection.scale(DELTA)), lightDirection);
                IntersectionInfo shadowIntersect = shadowRay.trace(scene);
                if (shadowIntersect.hit && shadowIntersect.t < intersect.point.getDistance(((PointLight) light).location))
                    continue;


                double cosAngle = intersect.normal.dotProduct(lightDirection);
                if (cosAngle > 0) {
                    double r = intersect.point.getDistance(((PointLight) light).location);
                    result = result.add(color.mult(light.color).mult(cosAngle * diffuseCoefficient * Math.max(0, (1 - Math.pow(r / ((PointLight) light).r, 2)))));
                }
                if (specularCoefficient > 0) {
                    Vector3d r = lightDirection.scale(-1).add(intersect.normal.scale(2*intersect.normal.dotProduct(lightDirection)));
                    result = result.add(color.mult(light.color).mult(intersect.ray.direction.scale(-1).dotProduct(r) * specularCoefficient));
                }
            }
            // TODO: Phong specular lighting.
        }

        if (reflectionCoefficient > 0 && depth < MAXDEPTH) {
            Vector3d normalComponent = intersect.normal.scale(intersect.ray.direction.dotProduct(intersect.normal));
            Vector3d newDirection = intersect.ray.direction.subtract(normalComponent.scale(2));
            Ray newRay = new Ray(intersect.point.translate(newDirection.scale(DELTA)), newDirection);
            IntersectionInfo newIntersect = newRay.trace(scene);
            if (newIntersect.hit) {
                result = result.add(newIntersect.object.material.shade(scene, newIntersect, depth + 1).mult(color).mult(reflectionCoefficient));
            } else {
                result = result.add(scene.camera.backgroundColor.mult(color).mult(reflectionCoefficient));
            }
        }

        return result.clamp();
    }

    public Material(Color color) {
        this.color = color;
    }
}
