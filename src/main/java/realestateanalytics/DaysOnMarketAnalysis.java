/*
 Name: Ian Duggan
 Assignment: Final Project
 Date: April 2024
 File: DaysOnMarketAnalysis.java
 */

package realestateanalytics;

/**
 * A DaysOnMarketAnalysis class that extends AbstractPropertyAnalysis and implements the IPropertyAnalysis interface.
 */
public class DaysOnMarketAnalysis extends AbstractPropertyAnalysis implements IPropertyAnalysis {

  /**
   * A DaysOnMarketAnalysis constructor that takes in one parameter.
   * @param properties takes in an instance of MyLinkedList containing property objects for analysis.
   */
  public DaysOnMarketAnalysis(MyLinkedList<Property> properties){
    super(properties);
  }

  /**
   * Calculates the average days on market for all Property objects in the list.
   * @return the average DOM for all properties in the list.
   */
  @Override
  public double calculateAverage(){
    return average(property -> property.getDaysOnMarket());
  }

  /**
   * Calculates the total sum of all Days On Market for all properties in the list.
   * @return the total combined DOM for all properties in the list.
   */
  @Override
  public double calculateTotalSum(){
    return totalSum(property -> property.getDaysOnMarket());
  }

  /**
   * Find the max value in the Days on Market field and returns the value.
   * @return the max Days on Market value in the property list.
   */
  @Override
  public double findMax() {
   return findMax(property -> property.getDaysOnMarket());
  }

  /**
   * Finds the minimum value for Days On Market compared across all properties in the list.
   * @return
   */
  @Override
  public double findMin() {
  return findMin(property -> property.getDaysOnMarket());
  }

}
