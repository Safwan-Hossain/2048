package src;
import java.util.ArrayList;

public class QuadraticMean implements MeanCalculator{

    @Override
    public Double meanCalc(ArrayList<Double> v) {
        Double sum = 0.0;
        for (Double x: v) {
            sum += x * x;
        }
        return Math.sqrt(sum / v.size());
    }
}
