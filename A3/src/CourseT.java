/**
 * Author: Safwan Hossain, hossam18, 400252391
 * Revised: 3/29/2021
 *
 * Description: Class that handles a course using IndicatorTs and LOsTs.
 */
package src;
import java.util.HashMap;
import java.util.HashSet;

public class CourseT implements Measures {
    String name;
    HashMap<IndicatorT, HashSet<LOsT>> m;

    /*
     * @brief Constructor for CourseT.
     * @details Stores the indicators inside a hashmap with the indicators
     * as the keys to the hashmap. Each key is mapped with an empty hashset
     * of type LOsT.
     * @assumption The CourseT object will not be used until all the indicators
     * have been populated with learning outcomes. In otherwords  addLO() needs
     * to be called at least once for each indicator of the course.
     * @assumption If learning outcomes are removed, it is assumed that not all of
     * them will be removed before the CourseT is ueed in an aggreation calculation.
     * @param courseName name of the course
     * @param indicators list of indicators for the course
     */
    public CourseT(String courseName, IndicatorT[] indicators) {
        this.name = courseName;
        m = new HashMap<>();
        for (IndicatorT indicator: indicators) {
            m.put(indicator, new HashSet<LOsT>());
        }
    }

    /*
     * @brief gets the name of the course.
     * @return returns name of the course
     */
    public String getName(){
        return this.name;
    }

    /*
     * @brief gets the indicators of the course.
     * @details iterates through the indicators of the hashmap stored in state variable m,
     * adds the indicator at each iteration into a new array, and returns the array at the
     * end of iteration.
     * @return returns an array of the indicators in the course
     */
    public IndicatorT[] getIndicators(){
        IndicatorT[] list = new IndicatorT[m.size()];
        int i = 0;
        for (IndicatorT ind: this.m.keySet()) {
            list[i] = ind;
            i++;
        }
        return list;
    }
    /*
     * @brief gets the learning outcomes of the course.
     * @details gets the learning outcomes hashset located at the given indicator in
     * the hashmap (state variable m), and returns it as an array. Converts the hashset
     * into an array using private method set_to_seq(). If the course does not contain the
     * indicator an empty array is returned.
     * @param indicator an indicator that contains the desired learning outcomes in the hashmap.
     * @return returns an array of the learning outcomes of the course if the given indicator
     * is part of the course. Else returns an empty array.
     */
    public LOsT[] getLOs(IndicatorT indicator) {
        if (this.m.containsKey(indicator)) {
            return set_to_seq(this.m.get(indicator));
        }
        return new LOsT[0];
    }
    /*
     * @brief gets the learning outcomes of the course.
     * @details gets the learning outcomes hashset located at the given indicator in
     * the hashmap (state variable m), and returns it as an array. Converts the hashset
     * into an array using private method set_to_seq().
     * @param indicator the indicator to which the learning outcome is to be added to
     * @param outcome the learning outcome that is to be added
     */
    public void addLO(IndicatorT indicator, LOsT outcome) {
        if (this.m.containsKey(indicator)) {
            this.m.get(indicator).add(outcome);
        }
    }

    /*
     * @brief deletes a specific learning outcome from an indicator.
     * @param indicator the indicator to which the learning outcome is located in
     * @param outcome the learning outcome that is to be removed
     */
    public void delLO(IndicatorT indicator, LOsT outcome) {
        if (this.m.containsKey(indicator)) {
            this.m.get(indicator).remove(outcome);
        }
    }

    /*
     * @brief checks if a sequence of learning outcomes is in a given indicator for the course. In other words
     * if a sequence (treated like a set) of learning outcome is a member of the course at a given indicator.
     * @details Iterates through the outcomes list that is given as parameter, and for each
     * iteration, the program checks if the set that is located at the given indicator contains
     * the current learning outcome. If the indicator does not exist for the course then the program
     * returns false. If the lengths between the set located at the indicator and the array given as
     * a parameter differ, it is implied that there is an extra or missing learning outcome thus
     * returns false.
     * @param indicator the indicator that the set is located in
     * @param outcomes the sequence of learning outcomes that is to be checked for membership
     * @return if key is not found or the lengths are different between the sequence and set or
     * either set/sequence is empty returns false. Else if the sequence and sets have matching
     * values regardless of order, the program returns true. Otherwise false.
     */
    public boolean member(IndicatorT indicator, LOsT[] outcomes) {
        if (!this.m.containsKey(indicator) || this.m.get(indicator).size() != outcomes.length ||
            outcomes.length == 0) {
            return false;
        }

        for (LOsT outcome : outcomes) {
            if (!this.m.get(indicator).contains(outcome)) {
                return false;
            }
        }
        return true;
    }

    /*
     * @brief CourseT does not have any measures.
     * @throw unsupported operation exception. This operation is not supported by this module.
     */
    @Override
    public double[] measures() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    /*
     * @brief Gets the measures for all learning outcomes of a given indicator.
     * @detail returns the sum between the common indices of each measure such that each sum can be
     * represented as {a[0] + b[0], a[1] + b[1], a[2] + b[2], a[3] + b[3]}.
     * @param ind the indicator that contains all the desired learning outcomes
     * @return If there are no learning otucomes for the given indicator return an array filled with zeros.
     * Else if Norm.getNInd() is true then returns the normal of the sum of all the
     * learning outcomes' values for the given indicator. Else if Norm.getNInd() is false return
     * the sum of all the learning outcomes' values for the given indicator.
     *
     */
    @Override
    public double[] measures(IndicatorT ind) {
        if (this.getLOs(ind).length == 0) {
            return new double[] {0, 0, 0, 0};
        }

        LOsT[] LOs = this.getLOs(ind);
        double[] measureInd = sumAllMeas(LOs);
        if (Norm.getNInd()) {
            return Services.normal(measureInd);
        }
        return measureInd;
    }
    /*
     * @brief Gets the measures for all the indicators of a given attribute.
     * @detail returns the sum between the common indices of each measure such that each sum can be
     * represented as {a[0] + b[0], a[1] + b[1], a[2] + b[2], a[3] + b[3]}.
     * @param att the attribute that contains all the desired indicators.
     * @return If there are no indicators for the given attribute return an array filled with zeros.
     * Else if Norm.getNAtt() is true then returns the normal of the sum of all the
     * indicators' values for the given attribute. Else if Norm.getNAtt() is false return
     * the sum of all the indicators' values for the given attribute.
     */
    @Override
    public double[] measures(AttributeT att) {
        if (att.getIndicators().length == 0) {
            return new double[] {0, 0, 0, 0};
        }

        IndicatorT[] indicators = att.getIndicators();
        double[] measureInd = sumAllMeas(indicators);
        if (Norm.getNAtt()) {
            return Services.normal(measureInd);
        }
        return measureInd;
    }
    /*
     * @brief converts a hashset into an array.
     * @details iterates through a hashset and at each iteration the
     * current item is added to an array. at the end of iteration the array
     * is returned.
     * @param set the set that is to be converted.
     * @return an array filled with all the values of a set.
     */
    private LOsT[] set_to_seq(HashSet<LOsT> set) {
        LOsT[] seq = new LOsT[set.size()];
        int i = 0;
        for (LOsT lost: set) {
            seq[i] = lost;
            i++;
        }
        return seq;
    }

    /*
     * @brief adds the values of the common indices between two double arrays each of length four.
     * @details adds the values such that the returned array is equivalent to
     * {a[0] + b[0], a[1] + b[1], a[2] + b[2], a[3] + b[3]}.
     * @param a the first array that is to be added.
     * @param b the second array that is to be added.
     * @return an array of length four that is the sum of the values of common indices
     * between the two given arrays.
     */
    private double[] sumMeas(double[] a, double[] b) {
        double[] sum = new double[4];
        for (int i = 0; i < 4; i++) {
            sum[i] = a[i] + b[i];
        }
        return sum;
    }
    /*
     * @brief returns the sum of all measures in a given sequence of learning outcomes
     * @details iterates through the sequence, at the first iteration gets the sum of the 
     * first measure with an identity sequence. Then that sum is summed with the next measure
     * using sumMeas() until iteration is finished. Then the sum is returned.
     * @param allMeasures the sequence that contains the learning outcomes for the measures
     * @return all the sum between common indices for the measures of all the given learning outcomes.
     */
    private double[] sumAllMeas(LOsT[] allMeasures) {
        double[] current = {0, 0, 0, 0};
        for (LOsT lost: allMeasures) {
            current = sumMeas(current, lost.measures());
        }
        return current;
    }

    /*
     * @brief returns the sum of all measures in a given sequence of indicators
     * @details iterates through the sequence, at the first iteration gets the sum of the
     * first measure with an identity sequence. Then that sum is summed with the next measure
     * using sumMeas() until iteration is finished. Then the sum is returned.
     * @param allMeasures the sequence that contains the indicators for the measures
     * @return all the sum between common indices for the measures of all the given indicators.
     */
    private double[] sumAllMeas(IndicatorT[] allMeasures) {
        double[] current = {0, 0, 0, 0};
        for (IndicatorT indicator: allMeasures) {
            current = sumMeas(current, this.measures(indicator));
        }
        return current;
    }



}
