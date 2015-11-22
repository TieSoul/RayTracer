package raytracer.scene;

/**
 * Created by Daan on 18-11-15.
 * This class isnt our own but it helps us to show the working of shaders
 * Source: http://groups.csail.mit.edu/graphics/classes/6.837/F98/Lecture20/RayTrace.java
 *
 */
public class Surface {
    /*
    public double ir, ig, ib;       //surface color
    public double ka, kd, ks, ns;   //phong model constants
    public double kt, kr, nt;
    private static final double TINY = 0.001d;
    private static final double I255 = 0.0392156d;  // 1/255

    public Surface(double rval, double gval, double bval, double a, double d, double s, double n, double r, double t, double index){
        ir = rval;
        ig = gval;
        ib = bval;
        ka = a;
        kd = d;
        ks = s;
        ns = n;
        kr = r*I255;
        kt = t;
        nt = index;
    }

    public Color Shade(Vector3d p, Vector3d n, Vector3d v, Vector lights, Vector objects, Color bgnd){
        Enumeration lightSources = lights.elements();

        float r = 0;
        float g = 0;
        float b = 0;

        while (lightSources.hasMoreElements()){
            Light light = (Light) lightSources.nextElement();
            if (light.lightType == Light.AMBIENT){
                r += ka*ir*light.ir;
                g += ka*ig*light.ig;
                b += ka*ib*light.ib;
            }else {
                Vector3d l;
                if (light.lightType == Light.POINT){
                    l = new Vector3d(light.lvec.x - p.x, light.lvec.y - p.y, light.lvec.z - p.z);
                    l.normalize();

                } else {
                    l = new Vector3d(-light.lvec.x, -light.lvec.y, -light.lvec.z);
                }

                //check if point on surface is in shadow
                Point3d place = new Point3d(p.x + TINY*l.x, p.y + TINY*l.y, p.z + TINY*l.z);
                Ray shadowR = new Ray(place, l);

                //if shadowR hits object then break
                if (shadowR.trace(objects))
                    break;

                double lambert = Vector3d.dotProduct(n, l);
                if (lambert > 0){
                    if (kd > 0){
                        double diffuse = kd*lambert;
                        r += diffuse*ir*light.ir;
                        g += diffuse*ig*light.ig;
                        b += diffuse*ib*light.ib;
                    }
                    if (ks > 0){
                        lambert *= 2;
                        double spec = v.dotProduct(lambert*n.x - l.x, lambert*n.y - l.y, lambert*n.z - l.z);
                        if (spec > 0){
                            spec = ks*Math.pow(spec, ns);
                            r += spec*light.ir;
                            g += spec*light.ig;
                            b += spec*light.ib;
                        }
                    }
                }
            }
        }

        // calculate illumination due to reflection
        if(kr > 0){
            double t = v.dotProduct(n);
            if (t > 0){
                t*= 2;
                Vector3d reflect = new Vector3d(t*n.x - v.x, t*n.y - v.y, t*n.z - v.z);
                Point3d place = new Point3d(p.x + TINY*reflect.x, p.y + TINY*reflect.y, p.z + TINY*reflect.z);

                Ray reflectedRay = new Ray(place, reflect);
                if (reflectedRay.trace(objects)){
                    Color rcolor = reflectedRay.Shade(lights, objects, bgnd);
                    r += kr*rcolor.getRed();
                    g += kr*rcolor.getGreen();
                    b += kr*rcolor.getBlue();
                } else {
                    r += kr*bgnd.getRed();
                    g += kr*bgnd.getGreen();
                    b += kr*bgnd.getBlue();
                }
            }
        }

        //code for refraction

        r = (r > 1f) ? 1f : r;
        g = (g > 1f) ? 1f : r;
        b = (b > 1f) ? 1f : b;


        return new Color(r, g, b);
    }
    */
}
