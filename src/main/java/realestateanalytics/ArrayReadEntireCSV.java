/*
 * Ian Duggan
 * April 2024
 * Final Project: Real Estate Analytics
 * File: ArrayReadEntireCSV.java
 */

package realestateanalytics;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * ArrayReadEntireCSV class is used to read in data from a CSV file using OpenCSV. Data is parsed and mapped to Java Beans
 * then added to an ArrayList.
 */
public class ArrayReadEntireCSV {

  /**
   * A readPropertiesFromCSV constructor that takes no parameters. Reads in CSV data using OpenCSV, parses and maps the data to Java Beans
   * and then adds them to an ArrayList.
   * @return A new instance of an ArrayList filled with the parsed data.
   */
  public static ArrayList<Property> readPropertiesFromCSV() {
    String filePath = "/Users/ianduggan/Desktop/Code/IdeaProjects/RealEstateAnalytics/RealEstateAnalytics/src/main/resources/BrunsHarpsAllStatusResLand.csv";
    ArrayList<Property> propertyList = new ArrayList<>();

    try {
      new CsvToBeanBuilder<Property>(new FileReader(filePath))
          .withType(Property.class).build().parse().forEach(property -> propertyList.add(property));

    } catch (IOException e) {
      System.out.println("An I/O error has occured" + e.getMessage());
    }
    return propertyList;
  }
}
