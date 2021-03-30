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

public class TestCourseT
{
    IndicatorT[] indicators;
    CourseT c;
    LOsT l1;
    LOsT l2;
    LOsT l3;
    LOsT l4;
    LOsT[] s1;
    LOsT[] s2;

    @Before
    public void setUp() {
        indicators = new IndicatorT[]{IndicatorT.assumpt, IndicatorT.awarePEO, IndicatorT.desPrinciples};
        c = new CourseT("c1", indicators);

        l1 = new LOsT("", 1, 1, 1, 1);
        l2 = new LOsT("", 2, 13, 31, 21);
        l3 = new LOsT("", 2, 53, 31, 21);
        l4 = new LOsT("", 4, 5, 4, 3);

        s1 = new LOsT[]{l1, l2, l3};
        s2 = new LOsT[]{l4};

        c.addLO(IndicatorT.assumpt, l1);
        c.addLO(IndicatorT.assumpt, l2);
        c.addLO(IndicatorT.assumpt, l3);
        c.addLO(IndicatorT.awarePEO, l4);
    }
    @After
    public void tearDown() {
        IndicatorT[] indicators = null;
        CourseT c = null;
        LOsT l1 = null;
        LOsT l2 = null;
        LOsT l3 = null;
        LOsT l4 = null;
        LOsT[] s1 = null;
        LOsT[] s2 = null;
    }

    @Test
    public void testGetName() {
        IndicatorT[] indicators = {IndicatorT.assumpt, IndicatorT.awarePEO, IndicatorT.desPrinciples};
        CourseT c1 = new CourseT("", indicators);
        CourseT c1Copy = new CourseT("", indicators);
        CourseT c2 = new CourseT("name", indicators);
        CourseT c2Copy = new CourseT("name", indicators);
        CourseT c3 = new CourseT("Name", indicators);

        assertEquals(c1.getName(), c1Copy.getName());
        assertEquals(c2.getName(), c2Copy.getName());
        assertNotEquals(c2.getName(), c3.getName());
    }

    @Test
    public void testGetIndicators() {
        IndicatorT[] indicators = {IndicatorT.assumpt, IndicatorT.awarePEO, IndicatorT.desPrinciples};
        CourseT c1 = new CourseT("c1", indicators);

        IndicatorT[] indicators2 = {};
        CourseT c2 = new CourseT("c2", indicators2);

        IndicatorT[] indicators3 = {IndicatorT.assumpt };
        CourseT c3 = new CourseT("c3", indicators3);

        assertTrue(hasSameValues(indicators, c1.getIndicators()));
        assertTrue(hasSameValues(indicators2, c2.getIndicators()));
        assertTrue(hasSameValues(indicators3, c3.getIndicators()));

        assertFalse(hasSameValues(indicators3, c2.getIndicators()));
        assertFalse(hasSameValues(indicators, c3.getIndicators()));


    }

    @Test
    public void testGetLOs() {

        assertTrue(hasSameValues(s1, c.getLOs(IndicatorT.assumpt)));
        assertTrue(hasSameValues(s2, c.getLOs(IndicatorT.awarePEO)));
        assertTrue(hasSameValues(new LOsT[0], c.getLOs(IndicatorT.math)));

    }

    @Test
    public void testAddLO() {

        assertTrue(contains(l1, c.getLOs(IndicatorT.assumpt)));
        assertTrue(contains(l2, c.getLOs(IndicatorT.assumpt)));
        assertTrue(contains(l3, c.getLOs(IndicatorT.assumpt)));
        assertFalse(contains(l4, c.getLOs(IndicatorT.assumpt)));
        assertTrue(contains(l4, c.getLOs(IndicatorT.awarePEO)));
        assertFalse(contains(l1, c.getLOs(IndicatorT.awarePEO)));
    }

    @Test
    public void testDelLO() {
        // shows existence
        assertTrue(contains(l1, c.getLOs(IndicatorT.assumpt)));
        assertTrue(contains(l2, c.getLOs(IndicatorT.assumpt)));
        assertTrue(contains(l3, c.getLOs(IndicatorT.assumpt)));
        assertTrue(contains(l4, c.getLOs(IndicatorT.awarePEO)));

        c.delLO(IndicatorT.assumpt, l1);
        c.delLO(IndicatorT.assumpt, l2);
        c.delLO(IndicatorT.assumpt, l3);
        c.delLO(IndicatorT.awarePEO, l4);
        c.delLO(IndicatorT.awarePEO, l4);

        // shows deletion
        assertFalse(contains(l1, c.getLOs(IndicatorT.assumpt)));
        assertFalse(contains(l2, c.getLOs(IndicatorT.assumpt)));
        assertFalse(contains(l3, c.getLOs(IndicatorT.assumpt)));
        assertFalse(contains(l4, c.getLOs(IndicatorT.awarePEO)));

    }

    @Test
    public void testMember() {
        assertTrue(c.member(IndicatorT.assumpt, s1));
        assertTrue(c.member(IndicatorT.awarePEO, s2));
        assertTrue(c.member(IndicatorT.awarePEO, s2));
        assertFalse(c.member(IndicatorT.assumpt, s2));
        assertFalse(c.member(IndicatorT.ideaGeneration, s2));
        assertFalse(c.member(IndicatorT.desPrinciples, new LOsT[0]));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMeasures() {
        c.measures();
    }

    @Test
    public void testMeasuresUsingInd() {
        double[] arr = {0, 0, 0, 0};
        assertTrue(equals(arr, c.measures(IndicatorT.desPrinciples)));
        assertTrue(equals(arr, c.measures(IndicatorT.ideaGeneration)));

        Norm.setNorms(true, true, true);
        double[] measureInd = sumAllMeas(c.getLOs(IndicatorT.assumpt));
        assertTrue(equals(Services.normal(measureInd), c.measures(IndicatorT.assumpt)));

        Norm.setNorms(true, false, true);
        assertTrue(equals(measureInd, c.measures(IndicatorT.assumpt)));
    }

    @Test
    public void testMeasuresUsingAtt() {
        AttributeT att = new AttributeT("name", indicators);
        double[] calculated = c.measures(new AttributeT("", new IndicatorT[0]));
        double[] expected = {0, 0, 0, 0};
        assertTrue(equals(calculated, expected));

        Norm.setNorms(true, true, true);
        double[] measureInd = sumAllMeas(att.getIndicators(), c);
        assertTrue(equals(Services.normal(measureInd), c.measures(att)));

        Norm.setNorms(true, true, false);
        measureInd = sumAllMeas(att.getIndicators(), c);
        assertTrue(equals(measureInd, c.measures(att)));
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
    public void testSumAllMeasUsingLost() {
        double[] service_l1 = Services.normal(new double[] {1,1,1,1});
        double[] service_l2 = Services.normal(new double[] {2,13,31,21});
        double[] service_l3 = Services.normal(new double[] {2,53,31,21});
        double[] service_l4 = Services.normal(new double[] {4,5,4,3});

        double[] sum = {9, 72, 67, 46};
        double[] service_sum = sumMeas(sumMeas(sumMeas(service_l1, service_l2), service_l3), service_l4);

        LOsT[] lost = {l1, l2, l3, l4};
        Norm.setNorms(false, false, false);
        assertTrue(equals(sum, sumAllMeas(lost)));
        Norm.setNorms(true, false, false);
        assertTrue(equals(service_sum, sumAllMeas(lost)));

    }

    @Test
    public void testSumAllMeasUsingInd() {

        Norm.setNorms(false, false, false);
        double[] service_sum = sumMeas(c.measures(indicators[0]), c.measures(indicators[1]));
        service_sum = sumMeas(service_sum, c.measures(indicators[2]));

        assertTrue(equals(service_sum, sumAllMeas(indicators, c)));
        Norm.setNorms(true, false, false);

        service_sum = sumMeas(c.measures(indicators[0]), c.measures(indicators[1]));
        service_sum = sumMeas(service_sum, c.measures(indicators[2]));

        assertTrue(equals(service_sum, sumAllMeas(indicators, c)));
    }
    private boolean hasSameValues(IndicatorT[] a1, IndicatorT[] a2) {
        if (a1.length != a2.length) {
            return false;
        }

        for (IndicatorT ind1: a1) {
            Boolean isIn = false;
            for (IndicatorT ind2 : a2) {
                if (ind1 == ind2) {
                    isIn = true;
                }
            }
            if (!isIn) {
                return false;
            }
        }
        return true;
    }

    private boolean hasSameValues(LOsT[] a1, LOsT[] a2) {
        if (a1.length != a2.length) {
            return false;
        }

        for (LOsT ind1: a1) {
            Boolean isIn = false;
            for (LOsT ind2 : a2) {
                if (ind1 == ind2) {
                    isIn = true;
                }
            }
            if (!isIn) {
                return false;
            }
        }
        return true;
    }

    private boolean contains(LOsT target, LOsT[] a) {
        for (LOsT lost: a) {
            if (target == lost) {
                return true;
            }
        }
        return false;
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

    private double[] sumAllMeas(IndicatorT[] allMeasures, CourseT c) {
        double[] current = {0, 0, 0, 0};
        for (IndicatorT indicator: allMeasures) {
            current = sumMeas(current, c.measures(indicator));
        }
        return current;
    }
}
