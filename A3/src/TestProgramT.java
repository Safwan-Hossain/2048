/**
 * Author: Safwan Hossain, hossam18, 400252391
 * Revised: 3/29/2021
 * 
 * Description: Class that tests ProgramT.java
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;

public class TestProgramT
{
    IndicatorT[] indicators;
    IndicatorT[] indicators2;
    AttributeT att;
    AttributeT att2;
    AttributeT att3;
    CourseT c;
    CourseT c2;
    LOsT l1;
    LOsT l2;
    LOsT l3;
    LOsT l4;
    LOsT l5;
    LOsT l6;
    LOsT[] s1;
    LOsT[] s2;
    LOsT[] s3;

    @Before
    public void setUp() {
        indicators = new IndicatorT[]{IndicatorT.assumpt, IndicatorT.awarePEO, IndicatorT.desPrinciples};
        indicators2 = new IndicatorT[]{IndicatorT.math, IndicatorT.desProcess, IndicatorT.estOutcomes};
        c = new CourseT("c1", indicators);
        c2 = new CourseT("c2", indicators2);

        att = new AttributeT("", new IndicatorT[] {IndicatorT.assumpt, IndicatorT.awarePEO, IndicatorT.desPrinciples, IndicatorT.math});
        att2 = new AttributeT("", new IndicatorT[] {});
        att3 = new AttributeT("", new IndicatorT[] {IndicatorT.desPrinciples, IndicatorT.math});

        l1 = new LOsT("", 1, 1, 1, 1);
        l2 = new LOsT("", 2, 13, 31, 21);
        l3 = new LOsT("", 2, 53, 31, 21);
        l4 = new LOsT("", 4, 5, 4, 3);
        l5 = new LOsT("", 5, 43, 1, 2);
        l6 = new LOsT("", 4, 1, 5, 3);

        s1 = new LOsT[]{l1, l2, l3};
        s2 = new LOsT[]{l4};
        s3 = new LOsT[]{l5, l6};

        c.addLO(IndicatorT.assumpt, l1);
        c.addLO(IndicatorT.assumpt, l2);
        c.addLO(IndicatorT.assumpt, l3);
        c.addLO(IndicatorT.awarePEO, l4);

        c2.addLO(IndicatorT.math, l5);
        c2.addLO(IndicatorT.math, l6);
    }
    @After
    public void tearDown() {
        IndicatorT[] indicators = null;
        IndicatorT[] indicators2 = null;
        AttributeT att = null;
        AttributeT att2 = null;
        AttributeT att3 = null;
        CourseT c = null;
        CourseT c2 = null;
        LOsT l1 = null;
        LOsT l2 = null;
        LOsT l3 = null;
        LOsT l4 = null;
        LOsT l5 = null;
        LOsT l6 = null;
        LOsT[] s1 = null;
        LOsT[] s2 = null;
        LOsT[] s3 = null;

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMeasures()
    {
        ProgramT p = new ProgramT();
        p.measures();
        
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMeasuresUsingInd()
    {
        ProgramT p = new ProgramT();
        p.measures(IndicatorT.assumpt);
    }

    @Test
    public void testMeasuresUsingAtt()
    {
        ProgramT p = new ProgramT();
        p.add(c);
        p.add(c2);

        assertTrue(equals(p.measures(att), sumAllMeas(p, att)));
        assertTrue(equals(p.measures(att2), sumAllMeas(p, att2)));
        assertFalse(equals(p.measures(att), sumAllMeas(p, att2)));
        assertTrue(equals(p.measures(att3), sumAllMeas(p, att3)));

    }

    @Test
    public void testSumMeas() {
        double[] d1 = {1, 0, 0, 0};
        double[] d2 = {1, 4, 5, 4};
        double[] d3 = {0, 0.01, 20.30, 10.3};
        double[] d4 = {4, 3, 1.5, 0};

        double[] sum12 = {2, 4, 5, 4};
        double[] sum34 = {4, 3.01,21.80, 10.3};

        assertTrue(equals(sum12, sumMeas(d1, d2)));
        assertTrue(equals(sum34, sumMeas(d3, d4)));
    }

    @Test
    public void testSumAllMeas() {
        ProgramT p = new ProgramT();
        p.add(c);
        p.add(c2);
        double[] current = {0, 0, 0, 0};
        for (CourseT course: p) {
            current = sumMeas(current, course.measures(att));
        }
        assertTrue(equals(current, sumAllMeas(p, att)));

        current = new double[] {0, 0, 0, 0};
        for (CourseT course: p) {
            current = sumMeas(current, course.measures(att2));
        }
        assertTrue(equals(current, sumAllMeas(p, att2)));

        current = new double[] {0, 0, 0, 0};
        for (CourseT course: p) {
            current = sumMeas(current, course.measures(att3));
        }
        assertTrue(equals(current, sumAllMeas(p, att3)));
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
    private boolean equals(double[] a1, double[] a2) {
        if (a1.length != a2.length) {
            return false;
        }
        for (int i = 0; i < a1.length; i++) {
            if (!doublesAreEqual(a1[i], a2[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean doublesAreEqual(double a, double b) {
        return Math.abs(a - b) <= 0.000001;
    }


}
