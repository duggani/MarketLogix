/*
 Name: Ian Duggan
 Assignment: Final Project
 Date: 4-6-24
 File: MappedPropertyAnalysis.java
 */

package realestateanalytics;

import java.util.function.Function;

/**
 * The MappedPropertyAnalysis class that contains a propertyMapping attribute.
 */
public class MappedPropertyAnalysis {
  private PropertyMapping propertyMapping;

  /**
   * A MappedPropertyAnalysis constructor that takes in one parameter.
   * @param propertyMapping An instance of the PropertyMapping object used to take in Property objects and
   *                        map them prior to filtering.
   */
  public MappedPropertyAnalysis(PropertyMapping propertyMapping) {
    this.propertyMapping = propertyMapping;
  }

  /**
   * Calculates the average of a given metric for a set of properties within a given list.
   * @param properties The properties that will be used/included in the calculation.
   * @param metricSelector The specified metric for the desired average.
   * @return A double representing the average sum for the specified metric in the property list.
   */
  public double calculateAverage(MyLinkedList<Property> properties, Function<Property, Double> metricSelector) {
    if (properties.count() == 0) return 0;

    double[] total = {0};
    properties.forEach(property -> {
      total[0] += metricSelector.apply(property);
    });
    return total[0] / properties.count();
  }

  /**
   * Calculates the average sum for a group of properties in a given price range,
   * based on a specified metric (list price, closed price, sq ft, etc.) passed as a parameter.
   * @param minPrice The minimum price of the range to be calculated.
   * @param maxPrice The maximum price of the range to be calculated.
   * @param metricSelector The desired metric to be used in the calculation.
   * @return A double representing the average sum of the specified metric in the given range.
   */
  public double calculateAverageInRange(double minPrice, double maxPrice, Function<Property, Double> metricSelector) {
    MyLinkedList<Property> filteredProperties = propertyMapping.filterByPriceRange(minPrice, maxPrice, metricSelector);
    double[] total = { 0 };
    int[] count = { 0 };

    filteredProperties.forEach(property -> {
      total[0] += metricSelector.apply(property);
      count[0]++;
    });
    // make sure at least one property value was considered in the calculations
    //and then calculate average, else return 0
    if (count[0] > 0) {
      return total[0] / count[0];
    } else {
      return 0;
    }
  }

  /**
   * A static Utility method that finds the property in the list with the maximum list price.
   * @param properties A linked list containing Property objects.
   * @return The property with the highest list price.
   */
  public static Property findMaxPricedProperty(MyLinkedList<Property> properties) {
    if (properties.isEmpty()){
      return null;
    }
    Property maxPricedProperty = properties.get(0);
    int numberOfProperties = properties.count();

    for (int i = 1; i <numberOfProperties; i++) {
      Property currentProperty = properties.get(i);
      if (currentProperty.getListPrice() > maxPricedProperty.getListPrice()) {
        maxPricedProperty = currentProperty;
      }
    }
    return maxPricedProperty;
  }
}
