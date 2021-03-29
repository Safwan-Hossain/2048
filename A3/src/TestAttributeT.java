/**
 * Author:
 * Revised:
 *
 * Description:
 */

package src;

import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestAttributeT
{

    @Test
    public void testGetName()
    {
        IndicatorT[] SE2AA4_indicators = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt};
        AttributeT att = new AttributeT("name", SE2AA4_indicators);
        AttributeT att2 = new AttributeT("Name", SE2AA4_indicators);
        assertTrue(att.getName().equals("name"));
        assertFalse(att.getName().equals("Name"));
        assertTrue(att2.getName().equals("Name"));

    }

    @Test
    public void testGetIndicators()
    {
        IndicatorT[] i1 = new IndicatorT[] {};
        IndicatorT[] i2 = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt,
                IndicatorT.awarePEO, IndicatorT.desPrinciples};
        IndicatorT[] i3 = new IndicatorT[] {IndicatorT.math};

        AttributeT att = new AttributeT("name", i1);
        AttributeT att2 = new AttributeT("Name", i2);
        AttributeT att3 = new AttributeT("Name", i3);


        IndicatorT[] indicators = att2.getIndicators();

        // checks to see if both arrays have same values regardless of order
        boolean allAreIn = true;
        for (IndicatorT indicator2: i2) {
            boolean isIn = false;
            for (IndicatorT indicator: indicators) {
                if (indicator == indicator2) {
                    isIn = true;
                }
            }
            if (!isIn) { allAreIn = false; }
        }
        //tests if two arrays of above 0 length are same without order
        assertTrue(allAreIn);

        // tests for 0 length array
        assertTrue(att.getIndicators().length == 0);

        // tests for 1 length array
        assertTrue(att3.getIndicators().length == 1 && att3.getIndicators()[0] == i3[0]);

    }
}
