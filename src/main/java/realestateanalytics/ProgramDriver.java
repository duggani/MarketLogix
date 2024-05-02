/*
 * Ian Duggan
 * April 2024
 * Final Project: Real Estate Analytics
 * File: ProgramDriver.java
 */

package realestateanalytics;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * The Program Driver class. Used to test and illustrate various classes and their functionality.
 */
public class ProgramDriver {

  public static void main(String[] args) {

    // Populate myLinkedList and ArrayList with property info from CSV using OpenCSV
    MyLinkedList<Property> propertyList = ReadEntireCSV.readPropertiesFromCSV();
    ArrayList<Property> propertyArrayList = ArrayReadEntireCSV.readPropertiesFromCSV();

    //Testing ListingOfficeAnalysis class functionality
    System.out.println("---Testing ListingOfficeAnalysis Functionality---");
    ListingOfficeAnalysis listingOfficeAnalysis = new ListingOfficeAnalysis(propertyArrayList, "Legacy Properties Sotheby's International Realty (1095)");
    double averageDaysOnMarketForLO = listingOfficeAnalysis.calculateAverage();
    double totalSumForLO = listingOfficeAnalysis.calculateTotalSum();
    double maxClosedPriceForLO = listingOfficeAnalysis.findMax();
    double minClosedPriceForLO = listingOfficeAnalysis.findMin();

    System.out.printf("Average Days on Market for all Legacy Properties listings: %.2f\n", averageDaysOnMarketForLO);
    System.out.printf("Total value of all closed sales for Legacy Properties listings: %.2f\n", totalSumForLO);
    System.out.printf("Value of max closed sale for all Legacy Properties listings: %.2f\n", maxClosedPriceForLO);
    System.out.printf("Value of min closed sale for all Legacy Properties listings: %.2f\n", minClosedPriceForLO);

    //Testing ListingMemberAnalysis class functionality
    System.out.println("\n---Testing ListingMemberAnalysis Functionality---");
    ListingMemberAnalysis listingMemberAnalysis = new ListingMemberAnalysis(propertyArrayList, "Dennis Duggan");
    double averageDaysOnMarketForLM = listingMemberAnalysis.calculateAverage();
    double totalSumForLM = listingMemberAnalysis.calculateTotalSum();
    double maxClosedPriceForLM = listingMemberAnalysis.findMax();
    double minClosedPriceForLM = listingMemberAnalysis.findMin();

    System.out.printf("1. Average Days on Market for Dennis Duggan's Listings: %.2f\n", averageDaysOnMarketForLM);
    System.out.printf("2. Total value of all closed sales for Dennis Duggan's Listings: $%.2f\n", totalSumForLM);
    System.out.printf("3. Value of max closed sale for Dennis Duggan's listings: $%.2f\n", maxClosedPriceForLM);
    System.out.printf("4. Value of min closed sale for Dennis Duggan's listings: $%.2f\n", minClosedPriceForLM);

    // Testing ClosedPriceAnalysis class functionality
    System.out.println("\n---Testing ClosedPriceAnalysis Functionality---");

    ClosedPriceAnalysis closedPriceAnalysis = new ClosedPriceAnalysis(propertyList);
    double averageCP = closedPriceAnalysis.calculateAverage();
    double totalCP = closedPriceAnalysis.calculateTotalSum();
    double maxCP = closedPriceAnalysis.findMax();
    double minCP = closedPriceAnalysis.findMin();

    System.out.printf("1. Average Closed Price for all properties: $%.2f\n", averageCP);
    System.out.printf("2. Combined total amount for all Closed Prices in the list: $%.0f\n", totalCP);
    System.out.println("3. Max Closed Price of all properties in the list: " + maxCP);
    System.out.println("4. Min Closed Price of all properties in the list: " + minCP);

// Testing ListPriceAnalysis class functionality
    System.out.println("\n---Testing ListPriceAnalysis Functionality---");

    ListPriceAnalysis listPriceAnalysis = new ListPriceAnalysis(propertyList);
    double averageLP = listPriceAnalysis.calculateAverage();
    double totalLP = listPriceAnalysis.calculateTotalSum();
    double maxLP = listPriceAnalysis.findMax();
    double minLP = listPriceAnalysis.findMin();

    System.out.printf("1. Average List Price for all properties: $%.2f\n", averageLP);
    System.out.printf("2. Combined total amount for all List Prices in the list: $%.0f\n", totalLP);
    System.out.println("3. Max List Price of all properties in the list: " + maxLP);
    System.out.println("4. Min List Price of all properties in the list: " + minLP);

// Testing DaysOnMarketAnalysis class Functionality
    System.out.println("\n---Testing DaysOnMarketAnalysis Functionality---");

    DaysOnMarketAnalysis domAnalysis = new DaysOnMarketAnalysis(propertyList);
    double averageDOM = domAnalysis.calculateAverage();
    double maxDOM = domAnalysis.findMax();
    double minDOM = domAnalysis.findMin();
    double totalDom = domAnalysis.calculateTotalSum();

    System.out.printf("1. Average Days on Market for all properties: %.2f\n", averageDOM);
    System.out.println("2. Maximum DOM for all properties: " + maxDOM);
    System.out.println("3. Minimum DOM for all properties: " + minDOM);
    System.out.println("4. Total Days on Market for all properties: " + totalDom);

// Testing findMaxPricedProperty method in PropertyAnalysis class
    System.out.println("\n---Testing maxPricedProperty method---");
    Property maxPricedProperty = MappedPropertyAnalysis.findMaxPricedProperty(propertyList);
    System.out.println("The property with the highest list price is:");
    System.out.println("MLS Number: " + maxPricedProperty.getMlsNumber() +
                        "\nAddress: " + maxPricedProperty.getShortAddress() +
                        "\nList Price: " + maxPricedProperty.getListPrice() +
                        "\nListing Status: " + maxPricedProperty.getStatus() +
                        "\nListing Agent: " + maxPricedProperty.getListingMember() +
                        "\nListing Office: " + maxPricedProperty.getListingOffice());
    System.out.println("---End maxPricedProperty Test---");

    // Testing getPropertyByMLS in PropertyMapping class
    System.out.println("\nRetrieving a property by using the MLS number (1539576) as an identifier... ");
    PropertyMapping propertyMapping = new PropertyMapping();
    Property retrievedProperty = propertyList.get(4);
    propertyMapping.addProperty(retrievedProperty);
    Property newProperty = propertyMapping.getPropertyByMLS("1539576");
    if (retrievedProperty != null) {
      System.out.println("\nProperty retrieved -> MLS Number: " + retrievedProperty.getMlsNumber()
          + "\nList Price: " + retrievedProperty.getListPrice()
          + "\nDays on Market: " + retrievedProperty.getDaysOnMarket()
          + "\nListing Member: " + retrievedProperty.getListingMember()
          + "\nListing Office: " + retrievedProperty.getListingOffice());
    }

// Print total number of properties in the propertyList
    System.out.println("\nTotal number of properties in the list: " + propertyList.count());

// Print properties in the propertyList with List Price over $1,000,000
    System.out.println("\nNumber of properties in the list with a List Price over $1,000,000: " + propertyList.countIf(property -> property.getListPrice() >= 1000000));

    System.out.println("\nNumber of properties in the list that sold for less than $1,000,000"
        + " \nand include more than 300 feet of waterfrontage: " + propertyList.countIf(property -> property.getClosedPrice() <= 1000000 && property.getWaterFrontageAmount() > 300));

    // Testing Map functionality from MyLinkedList
//    System.out.println("\nUsing map method fron MyLinkedList to map all prices to Double and then print all prices:");
//    MyLinkedList<Double> priceList = propertyList.map(property -> property.getListPrice());
//    priceList.forEach(price -> System.out.println(price));

// Print all properties in the propertyList
    System.out.println("\nPrinting selected data for all properties in the CSV file: ");
    propertyList.forEach(property -> System.out.println(
            "MLS Number: " + property.getMlsNumber() +
            ", Address: " + property.getShortAddress() +
            ", Property Type: " + property.getPropertyType() +
            ", Property Status: " + property.getStatus() +
            ", List Price: " + property.getListPrice() +
            ", Closed Price: " + property.getClosedPrice()
    ));
  }
}
