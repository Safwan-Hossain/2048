/**
 * Author: Safwan Hossain, hossam18, 400252391
 * Revised: 3/29/2021
 * 
 * Description: Class that handles norm aggregation algorithm configurations
 */

package src;
public class Norm {
    static boolean normLOs;
    static boolean normInd;
    static boolean normAtt;

    public static void setNorms(boolean nLOs, boolean nInd, boolean nAtt) {
        normLOs = nLOs;
        normInd = nInd;
        normAtt = nAtt;
    }

    public static boolean getNLOs() {
        return normLOs;
    }

    public static boolean getNInd() {
        return normInd;
    }

    public static boolean getNAtt() {
        return normAtt;
    }

    public static void setNLOs(boolean nLOs) {
        normLOs = nLOs;
    }

    public static void setNInd(boolean nInd) {
        normInd = nInd;
    }

    public static void setNAtt(boolean nAtt) {
        normAtt = nAtt;
    }
}