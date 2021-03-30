/**
 * Author: Safwan Hossain, hossam18, 400252391
 * Revised: 3/29/2021
 * 
 * Description: Class that handles a course using IndicatorTs and 
 LOsTs
 */
package src;
import java.util.HashMap;
import java.util.HashSet;

public class CourseT implements Measures {
    String name;
    HashMap<IndicatorT, HashSet<LOsT>> m;

    /**
     * @brief Compute the total of all the values stored in the cells.
     * @return The sum of all cells' values in the map
     */
    public CourseT(String courseName, IndicatorT[] indicators) {
        this.name = courseName;
        m = new HashMap<>();
        for (IndicatorT indicator: indicators) {
            m.put(indicator, new HashSet<LOsT>());
        }
    }

    public String getName(){
        return this.name;
    }

    public IndicatorT[] getIndicators(){
        IndicatorT[] list = new IndicatorT[m.size()];
        int i = 0;
        for (IndicatorT ind: this.m.keySet()) {
            list[i] = ind;
            i++;
        }
        return list;
    }

    public LOsT[] getLOs(IndicatorT indicator) {
        if (this.m.containsKey(indicator)) {
            return set_to_seq(this.m.get(indicator));
        }
        return new LOsT[0];
    }

    public void addLO(IndicatorT indicator, LOsT outcome) {
        if (this.m.containsKey(indicator)) {
            this.m.get(indicator).add(outcome);
        }
    }

    public void delLO(IndicatorT indicator, LOsT outcome) {
        if (this.m.containsKey(indicator)) {
            this.m.get(indicator).remove(outcome);
        }
    }

    public boolean member(IndicatorT indicator, LOsT[] outcomes) {
        if (!this.m.containsKey(indicator) && this.m.get(indicator).size() != outcomes.length) {
            return false;
        }

        for (LOsT outcome : outcomes) {
            if (!this.m.get(indicator).contains(outcome)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public double[] measures() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double[] measures(IndicatorT ind) {
        if (this.getLOs(ind).length == 0) {
            return new double[] {0, 0, 0, 0};
        }

        LOsT[] LOs = this.getLOs(ind);
        double[] measureInd = sumAllMeas(LOs);
        if (Norm.getNInd()) {
            return Services.normal(measureInd);
        }
        return measureInd;
    }

    @Override
    public double[] measures(AttributeT att) {
        if (att.getIndicators().length == 0) {
            return new double[] {0, 0, 0, 0};
        }

        IndicatorT[] indicators = att.getIndicators();
        double[] measureInd = sumAllMeas(indicators);
        if (Norm.getNAtt()) {
            return Services.normal(measureInd);
        }
        return measureInd;
    }

    private LOsT[] set_to_seq(HashSet<LOsT> set) {
        LOsT[] seq = new LOsT[set.size()];
        int i = 0;
        for (LOsT lost: set) {
            seq[i] = lost;
            i++;
        }
        return seq;
    }

    private double[] sumMeas(double[] a, double[] b) {
        double[] sum = new double[4];
        for (int i = 0; i < 4; i++) {
            sum[i] = a[i] + b[i];
        }
        return sum;
    }

    private double[] sumAllMeas(LOsT[] allMeasures) {
        double[] current = {0, 0, 0, 0};
        for (LOsT lost: allMeasures) {
            current = sumMeas(current, lost.measures());
        }
        return current;
    }

    private double[] sumAllMeas(IndicatorT[] allMeasures) {
        double[] current = {0, 0, 0, 0};
        for (IndicatorT indicator: allMeasures) {
            current = sumMeas(current, this.measures(indicator));
        }
        return current;
    }


}
