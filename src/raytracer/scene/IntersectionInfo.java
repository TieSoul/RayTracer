package raytracer.scene;

import raytracer.math.Point3d;
import raytracer.math.Ray;
import raytracer.math.Vector3d;

/**
 * Created by Thijs on 04/10/2015.
 */
public class IntersectionInfo {
    public boolean hit;
    public Object3D object;
    public double t;
    public Vector3d normal;
    public Point3d point;
    public Ray ray;
    public boolean incoming;
    
    public IntersectionInfo(Ray ray, Object3D object) {
        hit = false;
        this.ray = ray;
        this.object = object;
    }

    public IntersectionInfo(Ray ray, Object3D object, Vector3d normal, double t, boolean incoming ){
        hit = true;
        this.ray = ray;
        this.object = object;
        if (normal != null) this.normal = normal.normalize();
        this.t = t;
        this.point = ray.getEnd(t);
        this.incoming = incoming;
    }

    public IntersectionInfo(Ray ray, Object3D object, Vector3d normal, Point3d intersection, boolean incoming){
        hit = true;
        this.ray = ray;
        this.object = object;
        this.normal = normal.normalize();
        //?
        this.t = new Vector3d(ray.origin, intersection).getLength();
        //
        this.point = ray.getEnd(t);
        this.incoming = incoming;
    }
}
