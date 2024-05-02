/*
 * Ian Duggan
 * April 2024
 * Final Project: Real Estate Analytics
 * File: PropertyType.java
 */

package realestateanalytics;

/**
 * A PropertyType enum containing constants RESIDENTIAL and LAND.
 */
public enum PropertyType {
  RESIDENTIAL("Residential"),
  LAND("Land");

  private final String type;

  /**
   * A PropertyType constructor that takes one parameter.
   * @param type The PropertyStatus type.
   */
  PropertyType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  /**
   * A static method that compares the type code against the CSV field for Property Type.
   * @param text The string that the CSV field data will be compared against.
   * @return Returns the PropertyType constant as dictated by the matched code.
   * @throws IllegalArgumentException when the type is not recognized.
   */
  public static PropertyType fromCode(String text) {
    for (PropertyType t : PropertyType.values()) {
      if (t.type.equalsIgnoreCase(text)) {
        return t;
      }
    }
    throw new IllegalArgumentException("Unrecognized property type: " + text);
  }

}
