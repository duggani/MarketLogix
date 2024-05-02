/*
 * Ian Duggan
 * April 2024
 * Final Project: Real Estate Analytics
 * File: TestMappedPropertyAnalysis.java
 */

package realestateanalytics;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestMappedPropertyAnalysis {

  private PropertyMapping propertyMapping;
  private MappedPropertyAnalysis analysis;

  Property p1;
  Property p2;
  Property p3;

  @Before
  public void setUp() {
    this.propertyMapping = new PropertyMapping();
    MyLinkedList<Property> testProperties = new MyLinkedList<>();

    p1 = new Property();
    p1.setMlsNumber("1234");
    p1.setShortAddress("123 Winnie St");
    p1.setListPrice(550000);
    p1.setClosedPrice(565000);
    p1.setClosedPricePerSquare(245);
    testProperties.add(p1);

    p2 = new Property();
    p2.setMlsNumber("5678");
    p2.setShortAddress("456 Bert St");
    p2.setListPrice(450000);
    p2.setClosedPrice(425000);
    p2.setClosedPricePerSquare(221);
    testProperties.add(p2);

    p3 = new Property();
    p3.setMlsNumber("9101");
    p3.setShortAddress("789 Fallon St");
    p3.setListPrice(725000);
    p3.setClosedPrice(725000);
    p3.setClosedPricePerSquare(310);
    testProperties.add(p3);

    this.propertyMapping.setAllProperties(testProperties);
    this.analysis = new MappedPropertyAnalysis(propertyMapping);
  }

  @Test
  public void testCalculateAverageListPriceInRange() {
    double expectedAverage = 575000;
    double actualAverage = analysis.calculateAverageInRange(400000, 750000, property -> property.getListPrice());
    assertEquals(expectedAverage, actualAverage, .01);
  }

  @Test
  public void testCalculateClosedPriceInRange() {
    double expectedAverage = 571666.66666;
    double actualAverage = analysis.calculateAverageInRange(400000, 750000, property -> property.getClosedPrice());
    assertEquals(expectedAverage, actualAverage, .01);
  }

  @Test
  public void testCalculateAverageListPriceWithoutRange() {
    double expectedAverage = 575000;
    double actualAverage = analysis.calculateAverage(propertyMapping.getAllProperties(),property -> property.getListPrice());
    assertEquals(expectedAverage, actualAverage, .01);
  }

  @Test
  public void testCalculateAverageClosedPriceWithoutRange() {
    double expectedAverage = 571666.6666;
    double actualAverage = analysis.calculateAverage(propertyMapping.getAllProperties(),property -> property.getClosedPrice());
    assertEquals(expectedAverage, actualAverage, .01);
  }

  @Test
  public void testCalculateAveragePricePerSquare() {
    double expectedAverage = 258.6666;
    double actualAverage = analysis.calculateAverage(propertyMapping.getAllProperties(), property -> property.getClosedPricePerSquare());
    assertEquals(expectedAverage, actualAverage, .01);
  }
}
