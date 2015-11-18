package raytracer.scene;

import raytracer.math.Vector3d;

/**
 * Created by Daan on 18-11-15.
 */
public class Light {
    public static final int AMBIENT = 0;
    public static final int DIRECTIONAL = 1;
    public static final int POINT = 2;

    public int lightType;
    public Vector3d lvec;   // light vector

    public double ir, ig, ib;

    public Light(int type, Vector3d v, double r, double g, double b){
        lightType = type;
        ir = r;
        ig = g;
        ib = b;
        if (type != AMBIENT){
            lvec = v;
            if (type == DIRECTIONAL){
                lvec.normalize();
            }
        }
    }
}
