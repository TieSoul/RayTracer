package raytracer.samplers;

import raytracer.math.Point2d;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Thijs on 22/11/2015.
 */
public abstract class Sampler {
    public int numSamples;
    public int numSets;
    protected int jump = 0;
    protected int count = 0;
    protected Random random = new Random();
    public ArrayList<Point2d> samples = new ArrayList<Point2d>();
    public Point2d sampleUnitSquare() {
        if (count == numSamples) {
            count = 0;
            jump = random.nextInt(numSets);
        }

        return samples.get(jump * numSamples + (count++));
    }
    public abstract void generateSamples();
}
