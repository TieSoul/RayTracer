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
    public Texture texture;
    public double textureSize = 1.0;
    public double ambientCoefficient = 0.1;
    public double diffuseCoefficient = 1.0;
    public double specularCoefficient = 0;
    public double reflectionCoefficient = 0;
    public double specularExponent = 20;

    private static final double DELTA = 0.0001d;
    private static final int MAXDEPTH = 10;

    public Color getColor(IntersectionInfo intersect) {
        return texture.getColor(intersect.object.getTexturePoint(intersect.point));
    }

    public Color shade(Scene scene, IntersectionInfo intersect, int depth) {
        Color color = getColor(intersect);
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
                        Vector3d r = lightDirection.scale(-1).add(intersect.normal.scale(2*intersect.normal.dotProduct(lightDirection)));
                        double specular = intersect.ray.direction.scale(-1).dotProduct(r);
                        if (specular > 0)
                            result = result.add(color.mult(light.color).mult(Math.pow(specular, specularExponent) * specularCoefficient));
                    }
                }
            } else if (light instanceof PointLight) {
                Vector3d lightDirection = new Vector3d(intersect.point, ((PointLight) light).location).normalize();
                Ray shadowRay = new Ray(intersect.point.translate(lightDirection.scale(DELTA)), lightDirection);
                IntersectionInfo shadowIntersect = shadowRay.trace(scene);
                if (shadowIntersect.hit && shadowIntersect.t < intersect.point.getDistance(((PointLight) light).location))
                    continue;


                double cosAngle = intersect.normal.dotProduct(lightDirection);
                double d = intersect.point.getDistance(((PointLight) light).location);
                double lightStrength = Math.max(0, (1 - Math.pow(d / ((PointLight) light).r, 2)));
                if (cosAngle > 0) {
                    result = result.add(color.mult(light.color).mult(cosAngle * diffuseCoefficient * lightStrength));
                }
                if (specularCoefficient > 0) {
                    Vector3d r = lightDirection.scale(-1).add(intersect.normal.scale(2*intersect.normal.dotProduct(lightDirection)));
                    double specular = intersect.ray.direction.scale(-1).dotProduct(r);
                    if (specular > 0)
                        result = result.add(color.mult(light.color).mult(Math.pow(specular, specularExponent) * specularCoefficient * lightStrength));
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
        texture = new Texture(color);
    }

    public Material(Texture texture) {
        this.texture = texture;
    }
}
