/*
 * Ian Duggan
 * April 2024
 * Final Project: Real Estate Analytics
 * File: ReadEntireCSV.java
 */

package realestateanalytics;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;

/**
 * ReadEntireCSV class utilizes Maven's OpenCSV framework to read in CSV data and Map data to Java Beans.
 */
public class ReadEntireCSV {

  /**
   * A static method that reads in CSV data using OpenCSV. The data is parsed and mapped to Java Beans
   * and added to a custom LinkedList.
   * @return a new MyLinkedList object containing the parsed CSV data.
   */
  public static MyLinkedList<Property> readPropertiesFromCSV() {
      String filePath = "/Users/ianduggan/Desktop/Code/IdeaProjects/RealEstateAnalytics/RealEstateAnalytics/src/main/resources/BrunsHarpsAllStatusResLand.csv";
      MyLinkedList<Property> propertyList = new MyLinkedList<>();

      try {
      new CsvToBeanBuilder<Property>(new FileReader(filePath))
          .withType(Property.class).build().parse().forEach(property -> propertyList.add(property));

    } catch (IOException e) {
      System.out.println("An I/O error has occurred" + e.getMessage());
    }
    return propertyList;
  }
}

/*
Citations for use of Maven's OpenCSV
- Reference citations in report entries #'s 1-12
 */