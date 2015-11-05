package raytracer.math;

/**
 * Created by Thijs and Daan on 04/10/2015.
 */
public class Vector3d {
    public double x, y, z;

    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    //?
    public Vector3d(Point3d point) {
        this.x = point.x;
        this.y = point.y;
        this.z = point.z;
    }
    //?


    public Vector3d(Point3d from, Point3d to) {
        this.x = to.x - from.x;
        this.y = to.y - from.y;
        this.z = to.z - from.z;
    }
/*
    public void normalizeSelf() { // makes length of vector 1 with the same direction.
        double t = x*x + y*y + z*z;
        if(t != 0 && t != 1) t = (1 / Math.sqrt(t));
        x *= t;
        y *= t;
        z *= t;

    }
*/
    public Vector3d normalize(){
        double t = x*x + y*y + z*z;
        if (t != 0 && t != 1) t = (1 / Math.sqrt(t));
        return new Vector3d(x*t, y*t, z*t);
    }

    public Vector3d add(Vector3d vector) {
        return new Vector3d(x+vector.x, y+vector.y, z+vector.z);
    }

    public double dotProduct(Vector3d B) {
        return (x*B.x + y*B.y + z*B.z);
    }

    //for the IntersectionInfo
    public double dotProduct(double Bx, double By, double Bz){
        return (x*Bx + y*By + z*Bz);
    }

    public Vector3d crossProduct(Vector3d B) {
        return new Vector3d(y*B.z - z*B.y, z*B.x - x*B.z, x*B.y - y*B.x);
    }

    //substract vector v1 from v..
    public Vector3d subtract(Vector3d v1) {
        return new Vector3d(this.x - v1.x, this.y - v1.y, this.z - v1.z);
        //return v2;
    }

    public Vector3d scale(double d) {
        return new Vector3d(this.x*d, this.y*d, this.z*d);
        //return v2;

        //this.x*d, this.y*d, this.z*d

    }

    public double getLength() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public String toString() {
        return "Vector3d: (" + x + ", " + y + ", " + z + ")";
    }
}
