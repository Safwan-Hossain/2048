package src;
import java.util.ArrayList;

public class HarmonicMean implements MeanCalculator {

    @Override
    public Double meanCalc(ArrayList<Double> v) {
        Double sum = 0.0;
        for (Double x: v) {
            sum += 1 / x;
        }
        return v.size() / sum;
    }
}
