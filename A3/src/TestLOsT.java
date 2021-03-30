/**
 * Author: Safwan Hossain, hossam18, 400252391
 * Revised: 3/29/2021
 * 
 * Description: Class that tests LOsT.java
 */
package src;
public class LOsT implements Measures{
    String name;
    int n_blw;
    int n_mrg;
    int n_mts;
    int n_exc;

    public LOsT(String topic, int nblw, int nmrg, int nmts, int nexc) {

        if (nblw < 0 || nmts < 0 || nmrg < 0 || nexc < 0) {
            throw new IllegalArgumentException("Numbers cannot be less than 0");
        }
        if (nblw == 0 && nmts == 0 && nmrg == 0 && nexc == 0) {
            throw new IllegalArgumentException("All numbers cannot be 0");
        }

        this.name = topic;
        this.n_blw = nblw;
        this.n_mrg = nmrg;
        this.n_mts = nmts;
        this.n_exc = nexc;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(LOsT o) {
        return this.name.equals(o.getName());
    }

    @Override
    public double[] measures() {
        if (!Norm.getNLOs()) {
            return new double[] { this.n_blw, this.n_mrg, this.n_mts, this.n_exc };
        }
        return Services.normal(new double[] { this.n_blw, this.n_mrg, this.n_mts, this.n_exc });
    }

    @Override
    public double[] measures(IndicatorT ind) {
        throw new UnsupportedOperationException("Invalid input");
    }

    @Override
    public double[] measures(AttributeT att) {
        throw new UnsupportedOperationException("Invalid input");
    }
}