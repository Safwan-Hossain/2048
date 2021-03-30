/**
 * Author: Safwan Hossain, hossam18, 400252391
 * Revised: 3/29/2021
 * 
 * Description: Interface for measures methods
 */

package src;
public interface Measures {

    double[] measures() throws UnsupportedOperationException;
    double[] measures(IndicatorT ind) throws UnsupportedOperationException;
    double[] measures(AttributeT att) throws UnsupportedOperationException;

}