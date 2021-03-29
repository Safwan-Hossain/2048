/**
 * @File: Services.java
 * @Author: Safwan Hossain, Hossam18, 400252391
 * @Date: March.29th, 2021
 * @Description: 
 */

package src;

public class Services {

    public static double[] normal(double[] v) {
        double[] seq = new double[v.length];
        double sum = sum(v);

        for (int i = 0; i < v.length; i++) {
            seq[i] = v[i]/sum;
        }
        return seq;
    }

    private static double sum(double[] x) {
        double sum = 0;
        for (double num: x) {
            sum += num;
        }
        return sum;
    }

}

