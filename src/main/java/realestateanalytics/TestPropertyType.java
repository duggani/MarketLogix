/*
 * Ian Duggan
 * April 2024
 * Final Project: Real Estate Analytics
 * File: TestPropertyType.java
 */

package realestateanalytics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestPropertyType {

  @Test
  public void testSetPropertyTypeResidential() {
    Property property = new Property();
    property.setPropertyType("Residential");
    assertEquals(PropertyType.RESIDENTIAL, property.getPropertyType());
  }

  @Test
  public void testSetPropertyTypeLand() {
    Property property = new Property();
    property.setPropertyType("Land");
    assertEquals(PropertyType.LAND, property.getPropertyType());
  }

  @Test
  public void testSetPropertyInvalidType() {
    Property property = new Property();
    try {
      property.setPropertyType("Commercial");
      fail("IllegalArgumentException expected");
    } catch (IllegalArgumentException e){
      assertEquals("Unrecognized property type: Commercial", e.getMessage());
    }
  }

}
