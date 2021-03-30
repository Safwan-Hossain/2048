/**
 * Author: Safwan Hossain, hossam18, 400252391
 * Revised: 3/29/2021
 * 
 * Description: Class for handling attributes
 */

package src;
import java.util.HashSet;

public class AttributeT {
    String name;
    HashSet<IndicatorT> s;

    public AttributeT(String attribName, IndicatorT[] indicators) {
        this.name = attribName;
        this.s = new HashSet<IndicatorT>();
        for (IndicatorT indicator: indicators) {
            s.add(indicator);
        }
    }

    public String getName() {
        return this.name;
    }

    public IndicatorT[] getIndicators() {
        IndicatorT[] indicators = new IndicatorT[this.s.size()];
        int i = 0;
        for (IndicatorT indicator: this.s) {
            indicators[i] = indicator;
            i++;
        }
        return indicators;
    }
}