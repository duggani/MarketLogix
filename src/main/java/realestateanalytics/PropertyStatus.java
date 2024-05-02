/*
 * Ian Duggan
 * April 2024
 * Final Project: Real Estate Analytics
 * File: PropertyStatus.java
 */

package realestateanalytics;

/**
 * A PropertyStatus enum containing constants ACTIVE, PENDING, and CLOSED.
 */
public enum PropertyStatus {
  ACTIVE("A"),
  PENDING("P"),
  CLOSED("C");

  private final String statusCode;

  /**
   * A PropertyStatus constructor that takes in one parameter.
   * @param statusCode The status code corresponding to a PropertyStatus constant.
   */
  PropertyStatus(String statusCode) {
    this.statusCode = statusCode;
  }

  /**
   * A getter method to return the statusCode.
   * @return
   */
  public String getStatus(){
    return statusCode;
  }

  /**
   * A static method that compares the statusCode against the Property Status field from the CSV data.
   * @param text The String to be matched with the CSV field.
   * @return the PropertyStatus type
   * @throws IllegalArgumentException when the code is not recognized.
   */
  public static PropertyStatus fromCode(String text) {
    for (PropertyStatus s : PropertyStatus.values()) {
      if (s.statusCode.equalsIgnoreCase(text)) {
        return s;
      }
    }
    throw new IllegalArgumentException("Code not recognized: " + text);
  }
}
