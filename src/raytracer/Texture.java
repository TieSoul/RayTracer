package raytracer;

import raytracer.math.Color;
import raytracer.math.Point2d;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thijs on 26/11/2015.
 */
public class Texture {
    BufferedImage image;
    public Texture(Color color) {
        image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        image.setRGB(0, 0, color.getRGB());
    }
    public Texture(File file) {
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Color getColor(Point2d point) {
        return new Color(image.getRGB((int)(point.x * image.getWidth()), (int)(point.y * image.getHeight())));
    }
}
