/*
 Name: Ian Duggan
 Assignment: Final Project
 Date: 4-6-24
 File: ListingOfficeAnalysis.java
 */

package realestateanalytics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The ListingOfficeAnalysis class that implements the IPropertyAnalysis interface. Contains a properties and officeName attributes.
 */
public class ListingOfficeAnalysis implements IPropertyAnalysis{

  private ArrayList<Property> properties;
  private String officeName;

  /**
   * A ListingOfficeAnalysis constructor that takes in two parameters.
   * @param properties An ArrayList where the Property objects will be stored.
   * @param officeName A string representing the name of the Listing Office for all properties in the list.
   */
  public ListingOfficeAnalysis(ArrayList<Property> properties, String officeName){
    this.properties = properties;
    this.officeName = officeName;
  }

  /**
   * Calculates the average Days on Market for all listings within the specified Listing Office.
   *
   * @return The average Days on Market for all listings belonging to the specified Listing Office.
   */
  @Override
  public double calculateAverage() {
    Predicate<Property> filter = property -> officeName.equalsIgnoreCase(property.getListingOffice());
    return properties.stream().filter(filter).mapToDouble(Property -> Property.getDaysOnMarket()).average().orElse(0);
  }

  /**
   * Calculates the total sum of all closed sales for the specified Listing Office.
   *
   * @return The total sum of all closed sales for the specified Listing Office.
   */
  @Override
  public double calculateTotalSum() {
  Predicate<Property> filter = property -> officeName.equalsIgnoreCase(property.getListingOffice()) && "C".equalsIgnoreCase(property.getStatus());
  return properties.stream().filter(filter).mapToDouble(Property -> Property.getClosedPrice()).sum();
  }

  /**
   * Finds and returns the max value for a given field.
   *
   * @return the max value for the given field in the form of a double.
   */
  @Override
  public double findMax() {
    Predicate<Property> filter = property -> officeName.equalsIgnoreCase(property.getListingOffice());
    return properties.stream().filter(filter).mapToDouble(Property -> Property.getClosedPrice()).max().orElse(Double.NEGATIVE_INFINITY);
  }

  /**
   * Finds and returns the minimum closed sale for all properties sold by the specified Listing Office.
   *
   * @return the min closed sale value for all properties sold by the specified Listing Office.
   */
  @Override
  public double findMin() {
    Predicate<Property> filter = property -> officeName.equalsIgnoreCase(property.getListingOffice() );
    return properties.stream().filter(filter).mapToDouble(Property -> Property.getClosedPrice()).min().orElse(Double.POSITIVE_INFINITY);
  }

}
