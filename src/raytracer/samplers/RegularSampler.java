package raytracer.samplers;

import raytracer.math.Point2d;

/**
 * Created by Thijs on 22/11/2015.
 */
public class RegularSampler extends Sampler {

    @Override
    public void generateSamples() {
        int n = (int) Math.sqrt(numSamples);
        for (int i = 0; i < numSets; i++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    samples.add(new Point2d(-0.5 + ((double)x)/n, -0.5 + ((double)y)/n));
                }
            }
        }
    }

    public RegularSampler(int samples) {
        numSets = 1;
        numSamples = samples;
        generateSamples();
    }
}
