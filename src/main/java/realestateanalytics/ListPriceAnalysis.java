/*
 Name: Ian Duggan
 Assignment: Final Project
 Date: 4-6-24
 File: ListPriceAnalysis.java
 */

package realestateanalytics;

/**
 * The ListPriceAnalysis class that extends AbstractPropertyAnalysis and implements the IPropertyAnalysis interface.
 */
public class ListPriceAnalysis extends AbstractPropertyAnalysis implements IPropertyAnalysis{

  /**
   * The ListPriceAnalysis constructor that takes one parameter.
   * @param properties
   */
  public ListPriceAnalysis(MyLinkedList<Property> properties){
    super(properties);
  }

  /**
   * Calculates the average List Price of all properties in the list.
   *
   * @return The average List Price based on all properties in the list.
   */
  @Override
  public double calculateAverage() {
    return average(property -> property.getListPrice());
  }

  /**
   * Calculates the total sum of combined List Prices in the list.
   *
   * @return The total sum of Combined List Prices in the list.
   */
  @Override
  public double calculateTotalSum() {
    return totalSum(property -> property.getListPrice());
  }

  /**
   * Finds and returns the max List Price for all List Prices in the list of properties.
   *
   * @return the max List Price out of all properties in the list.
   */
  @Override
  public double findMax() {
    return findMax(property -> property.getListPrice());
  }

  /**
   * Finds and returns the min value for a given field.
   *
   * @return the max value for the given field in the form of a double.
   */
  @Override
  public double findMin() {
    return findMin(property -> property.getListPrice());
  }

}
