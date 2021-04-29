package src;
import java.util.ArrayList;

public class Seq1D {
    ArrayList<Double> s;
    MeanCalculator meanCalculator;

    public Seq1D(ArrayList<Double> x, MeanCalculator m) {
        if (x.isEmpty()) {
            throw new IllegalArgumentException("Sequence cannot be empty");
        }
        this.s = x;
        this.meanCalculator = m;
    }

    public void setMeanCalculator(MeanCalculator m) {
        this.meanCalculator = m;
    }

    public Double mean() {
        return meanCalculator.meanCalc(this.s);
    }
}
