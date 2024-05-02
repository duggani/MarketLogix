/*
 * Ian Duggan
 * April 2024
 * Final Project: Real Estate Analytics
 * File: ClosedPriceAnalysis.java
 */
package realestateanalytics;

/**
 * A ClosedPriceAnalysis class that extends AbstractPropertyAnalysis and implements IPropertyAnalysis interface.
 */
public class ClosedPriceAnalysis extends AbstractPropertyAnalysis implements IPropertyAnalysis{

  /**
   * A ClosedPropertyAnalysis constructor that takes one parameter.
   * @param properties An instance of MyLinkedList containing the Property objects to be analyzed.
   */
  public ClosedPriceAnalysis(MyLinkedList<Property> properties){
    super(properties);
  }

  /**
   * Calculates the average Closed Price of all closed properties in the list. Averages only
   * properties that have a Closed "C" status.
   *
   * @return The average Closed Price based on all Closed properties in the list.
   */
  @Override
  public double calculateAverage() {
    return average(property -> "C".equalsIgnoreCase(property.getStatus()) ? property.getClosedPrice() : null);
  }

  /**
   * Calculates the total sum of combined Closed Prices in the list.
   *
   * @return The total sum of Combined Closed Prices in the list.
   */
  @Override
  public double calculateTotalSum() {
    return totalSum(property -> property.getClosedPrice());
  }

  /**
   * Finds and returns the max Closed Price for all Closed Prices in the list of properties.
   *
   * @return the max Closed Price out of all properties in the list.
   */
  @Override
  public double findMax() {
    return findMax(property -> property.getClosedPrice());
  }

  /**
   * Finds and returns min the Closed Price for all Closed properties in the list. Searches only properties
   * that have a Closed "C" status.
   *
   * @return the min Closed Price for all Closed Prices in the list in the form of a double.
   */
  @Override
  public double findMin() {
    return findMin(property -> "C".equalsIgnoreCase(property.getStatus()) ? property.getClosedPrice() : null);
  }

}