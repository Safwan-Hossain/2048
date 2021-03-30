/**
 * Author: Safwan Hossain, hossam18, 400252391
 * Revised: 3/29/2021
 * 
 * Description: Class for usefule services for other modules
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

