package raytracer.math;

/**
 * Created by Thijs on 23/11/2015.
 */
public class Color {
    public double red;
    public double green;
    public double blue;
    public Color(int rgb) {
        red = ((rgb >> 16) & 0xFF)/255.0;
        green = ((rgb >> 8) & 0xFF)/255.0;
        blue = (rgb & 0xFF)/255.0;
    }
    public Color(double red, double green, double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    public Color(int red, int green, int blue) {
        this.red = red/255.0;
        this.green = green/255.0;
        this.blue = blue/255.0;
    }
    public Color add(Color other) {
        return new Color(red + other.red, green + other.green, blue + other.blue);
    }
    public Color mult(Color other) {
        return new Color(red * other.red, green * other.green, blue * other.blue);
    }
    public Color mult(double c) {
        return new Color(red * c, green * c, blue * c);
    }
    public Color divide(double c) {
        return new Color(red / c, green / c, blue / c);
    }
    public Color clamp() {
        return new Color(red > 1 ? 1.0 : red, green > 1 ? 1.0 : green, blue > 1 ? 1.0 : blue);
    }
    public int getRGB() {
        return (((int)(red*255) << 16) + ((int)(green*255) << 8) + (int)(blue*255));
    }

    public static final Color WHITE = new Color(1.0, 1.0, 1.0);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color BLUE = new Color(0, 0, 1.0);
    public static final Color RED = new Color(1.0, 0, 0);
    public static final Color GREEN = new Color(0, 1.0, 0);
    public static final Color MAGENTA = new Color(1.0, 0, 1.0);
    public static final Color YELLOW = new Color(1.0, 1.0, 0);
    public static final Color CYAN = new Color(0, 1.0, 1.0);
    public static final Color SILVER = new Color(0.753,0.753,0.753);
}
