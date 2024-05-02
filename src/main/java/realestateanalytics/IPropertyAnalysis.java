/*
 Name: Ian Duggan
 Assignment: Final Project
 Date: April 2024
 File: IPropertyAnalysis.java
 */

package realestateanalytics;

/**
 * The IPropertyAnalysis interface that lists the methods that must be implemented in all classes
 * that implement this interface.
 */
public interface IPropertyAnalysis {

  /**
   * Calculates the average value for a given field/
   * @return The average value for all values of the specified field in the list.
   */
  double calculateAverage();

  /**
   * Calculates the total sum of all values for a given field.
   * @return The total sum of all values within a given field in the form of a double.
   */
  double calculateTotalSum();

  /**
   * Finds and returns the max value for a given field.
   * @return the max value for the given field in the form of a double.
   */
  double findMax();

  /**
   * Finds and returns the min value for a given field.
   * @return the max value for the given field in the form of a double.
   */
  double findMin();

}
