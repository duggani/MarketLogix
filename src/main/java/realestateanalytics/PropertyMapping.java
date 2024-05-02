/*
 * Ian Duggan
 * April 2024
 * Final Project: Real Estate Analytics
 * File: PropertyMapping.java
 */

package realestateanalytics;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * The PropertyMapping class which contains a propertiesByMLS and allProperties attributes.
 */
public class PropertyMapping {

  private Map<String, Property> propertiesByMLS;
  private MyLinkedList<Property> allProperties;

  /**
   * A PropertyMapping constructor that takes no parameters.
   */
  public PropertyMapping() {
    this.propertiesByMLS = new HashMap<>();
    this.allProperties = new MyLinkedList<>();
  }

  /**
   * An addProperty method that takes in a property parameter and adds it to the HashMap and LinkedList.
   * In the HashMap key/value paris are created with the MLS number used as the key and the property object is used as the value.
   * @param property the Property object to be added.
   */
  public void addProperty(Property property) {
    propertiesByMLS.put(property.getMlsNumber(), property);
    allProperties.add(property);
  }

  /**
   * A method that takes in a String which is used to locate the corresponding key in the HashMap.
   * @param mlsNumber The MLS number of the property to be found in the map.
   * @return returns the property object that has been located in the list.
   */
  public Property getPropertyByMLS(String mlsNumber) {
    return propertiesByMLS.get(mlsNumber);
  }

  /**
   * A method that filters the property list based on a given price range. Takes in a high and low range for filtering.
   * Utilizes the Function interface to take in Property objects and map data to a Double as dictated by the filter.
   * @param minPrice The low range of the price range to be filtered.
   * @param maxPrice The high range of the price range to be filtered.
   * @param metricSelector The specific metric (data field) identifying the data to be analyzed.
   * @return The filtered list within the specified price range for the metric (data field) given.
   */
  public MyLinkedList<Property> filterByPriceRange(double minPrice, double maxPrice,
      Function<Property, Double> metricSelector) {
    MyLinkedList<Property> filteredList = new MyLinkedList<>();
    allProperties.forEach(property -> {
      if (metricSelector.apply(property) >= minPrice
          && metricSelector.apply(property) <= maxPrice) {
        filteredList.add(property);
      }
    });
    return filteredList;
  }

  /**
   * Creates a complete list for all properties in this mapping.
   *
   * @param properties The properties to be included in the list.
   */
  public void setAllProperties(MyLinkedList<Property> properties) {
    this.allProperties = new MyLinkedList<>();
    if (properties != null) {
      properties.forEach(property -> this.allProperties.add(property));
    }
  }

  /**
   * Retrieves all properties.
   * @return A MyLinkedList object containing all properties.
   */
  public MyLinkedList<Property> getAllProperties() {
    return this.allProperties;
  }
}
