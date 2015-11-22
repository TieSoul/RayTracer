package raytracer.samplers;

import raytracer.math.Point2d;

import java.util.Random;

/**
 * Created by Thijs on 22/11/2015.
 */
public class RandomSampler extends Sampler {
    private Random random = new Random();
    @Override
    public void generateSamples() {
        for (int _ = 0; _ < numSets * numSamples; _++) {
            samples.add(new Point2d(-0.5 + random.nextDouble(), -0.5 + random.nextDouble()));
        }
    }
    public RandomSampler(int samples) {
        numSets = 100;
        numSamples = samples;
        generateSamples();
    }
}
