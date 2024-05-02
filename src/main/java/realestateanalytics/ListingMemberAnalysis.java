/*
 Name: Ian Duggan
 Assignment: Final Project
 Date: 4-6-24
 File: ListingMemberAnalysis.java
 */

package realestateanalytics;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * The ListingMemberAnalysis class that implements IPropertyAnalysis. Contains a memberName and properties attributes.
 */
public class ListingMemberAnalysis implements IPropertyAnalysis{
  private ArrayList<Property> properties;
  private String memberName;

  /**
   * A ListingMemberAnalysis constructor that takes in two parameters.
   * @param properties An instance of ArrayList where the Property objects to be analyzed will be stored.
   * @param memberName A String representing the listing member of properties in the list.
   */
  public ListingMemberAnalysis(ArrayList<Property> properties, String memberName){
    this.properties = properties;
    this.memberName = memberName;
  }

  /**
   * Calculates the average Days on Market across a specified Listing Member's listings.
   * @return The average Days on Market for the specified Listing Member's listings.
   */
  @Override
  public double calculateAverage(){
    Predicate<Property> filter = property -> memberName.equalsIgnoreCase(property.getListingMember());
    return properties.stream().filter(filter).mapToDouble(Property ->Property.getDaysOnMarket()).average().orElse(0);

  }

  /**
   * Calculates the total dollar value of all closed properties for the specified Listing Member.
   *
   * @return The total sum of all closed sales for the specified Listing Member.
   */
  @Override
  public double calculateTotalSum() {
    Predicate<Property> filter = property -> memberName.equalsIgnoreCase(property.getListingMember()) && "C".equalsIgnoreCase(property.getStatus());
    return properties.stream().filter(filter).mapToDouble(Property -> Property.getClosedPrice()).sum();
  }

  /**
   * Finds and returns the max Closed Price for the specified Listing Member.
   *
   * @return the max Closed Price for the specified Listing Member.
   */
  @Override
  public double findMax() {
    Predicate<Property> filter = property -> memberName.equalsIgnoreCase(property.getListingMember());
    return properties.stream().filter(filter).mapToDouble(Property -> Property.getClosedPrice()).max().orElse(Double.NEGATIVE_INFINITY);
  }

   /**
   * Finds and returns the min Closed Price for the specified Listing Member.
   *
   * @return the min Closed Price for the specified Listing Member.
   */
  @Override
  public double findMin() {
    Predicate<Property> filter = property -> memberName.equalsIgnoreCase(property.getListingMember());
    return properties.stream().filter(filter).mapToDouble(Property -> Property.getClosedPrice()).min().orElse(Double.POSITIVE_INFINITY);
  }


}
