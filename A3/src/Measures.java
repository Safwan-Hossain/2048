/**
 * @File: IndicatorT.java
 * @Author: Safwan Hossain, Hossam18, 400252391
 * @Date: March.29th, 2021
 * @Description: 
 */

package src;
public interface Measures {

    double[] measures() throws UnsupportedOperationException;
    double[] measures(IndicatorT ind) throws UnsupportedOperationException;
    double[] measures(AttributeT att) throws UnsupportedOperationException;

}