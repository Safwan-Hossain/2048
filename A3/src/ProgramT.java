/**
 * Author: Safwan Hossain, hossam18, 400252391
 * Revised: 3/29/2021
 * 
 * Description: Class for handling a set of courses of type CourseT
 */
package src;
import java.util.HashSet;

public class ProgramT extends HashSet<CourseT> implements Measures {

    @Override
    public double[] measures() {
        throw new UnsupportedOperationException("Invalid input");
    }

    @Override
    public double[] measures(IndicatorT ind) {
        throw new UnsupportedOperationException("Invalid input");
    }

    @Override
    public double[] measures(AttributeT att) {
        return sumAllMeas(this, att);
    }

    private double[] sumMeas(double[] a, double[] b) {
        double[] sum = new double[4];
        for (int i = 0; i < 4; i++) {
            sum[i] = a[i] + b[i];
        }
        return sum;
    }

    private double[] sumAllMeas(ProgramT allMeasures, AttributeT att) {
        double[] current = {0, 0, 0, 0};
        for (CourseT course: allMeasures) {
            current = sumMeas(current, course.measures(att));
        }
        return current;
    }


}