/*
 * Ian Duggan
 * April 2024
 * Final Project: Real Estate Analytics
 * File: Property.java
 */

package realestateanalytics;

import com.opencsv.bean.CsvBindByName;

/**
 * The Property class. A Properties contains the following attributes: mlsNuumber, shortAddress, streetNumber, streetName, streetType, town, propertyType,
 * status, listDate, listPrice, listPricePerSquare, pendingDate, closedDate, closedPrice, closedPerSquare, daysOnMarket, finishedSquareTotal,
 * lotSizeAcres, yearBuilt, numberBedrooms, numberRooms, garage, listingMember, listingOffice, sellingMember, sellingOffice, waterView, waterFrontage,
 * waterFrontageAmount, waterFrontDeep, waterFrontTidal, fullTaxAmount, hasBarn, buyersZipCode.
 */
public class Property {

  @CsvBindByName(column = "Listing Number", required = true)
  private String mlsNumber;

  @CsvBindByName(column = "Short Address", required = true)
  private String shortAddress;

  @CsvBindByName(column = "Street #", required = true)
  private String streetNumber;

  @CsvBindByName(column = "Street Name", required = true)
  private String streetName;

  @CsvBindByName(column = "Street Type")
  private String streetType;

  @CsvBindByName(column = "Town", required = true)
  private String town;

  @CsvBindByName(column = "Property Type", required = true)
  private PropertyType propertyType;

  @CsvBindByName(column = "Status", required = true)
  private String status;

  @CsvBindByName(column = "List Date", required = true)
  private String listDate;

  @CsvBindByName(column = "List Price", required = true)
  private double listPrice;

  @CsvBindByName(column = "List Price/SqFt", required = true)
  private double listPricePerSquare;

  @CsvBindByName(column = "Pending Date")
  private String pendingDate;

  @CsvBindByName(column = "Closed Date")
  private String closedDate;

  @CsvBindByName(column = "Closed Price")
  private double closedPrice;

  @CsvBindByName(column = "Sold Price/SqFt")
  private double closedPricePerSquare;

  @CsvBindByName(column = "Days On Market", required = true)
  private double daysOnMarket;

  @CsvBindByName(column = "SqFt Finished Total")
  private double finishedSquareTotal;

  @CsvBindByName(column = "Lot Size Acres +/-")
  private double lotSizeAcres;

  @CsvBindByName(column = "Year Built")
  private int yearBuilt;

  @CsvBindByName(column = "# Bedrooms")
  private int numberBedrooms;

  @CsvBindByName(column = "# Rooms")
  private int numberRooms;

  @CsvBindByName(column = "Garage")
  private String garage;

  @CsvBindByName(column = "Listing Member", required = true)
  private String listingMember;

  @CsvBindByName(column = "Listing Office", required = true)
  private String listingOffice;

  @CsvBindByName(column = "Selling Member")
  private String sellingMember;

  @CsvBindByName(column = "Selling Office")
  private String sellingOffice;

  @CsvBindByName(column = "Water Info: Water View")
  private String waterView;

  @CsvBindByName(column = "Water Info: Water Frontage")
  private String waterFrontage;

  @CsvBindByName(column = "Water Info: Waterfront Amount")
  private double waterFrontageAmount;

  @CsvBindByName(column = "Recreational Water: Waterfront Deep")
  private String waterfrontDeep;

  @CsvBindByName(column = "Recreational Water: Waterfront Tidal")
  private String waterfrontTidal;

  @CsvBindByName(column = "Full Tax Amount $", required = true)
  private double fullTaxAmount;

  @CsvBindByName(column = "Other Structures: Barn")
  private String hasBarn;

  @CsvBindByName(column = "Sold Info: Buyer's Zip Code")
  private int buyersZipCode;

  // Getters

  public String getMlsNumber() {
    return mlsNumber;
  }

  public String getShortAddress() {
    return shortAddress;
  }

  public String getStreetNumber() {
    return streetNumber;
  }

  public String getStreetName() {
    return streetName;
  }

  public String getStreetType() {
    return streetType;
  }

  public String getTown() {
    return town;
  }

  public PropertyType getPropertyType() {
    return propertyType;
  }

  public String getStatus() {
    return status;
  }

  public String getListDate() {
    return listDate;
  }

  public double getListPrice() {
    return listPrice;
  }

  public double getListPricePerSquare() {
    return listPricePerSquare;
  }

  public String getPendingDate() {
    return pendingDate;
  }

  public String getClosedDate() {
    return closedDate;
  }

  public double getClosedPrice() {
    return closedPrice;
  }

  public double getClosedPricePerSquare() {
    return closedPricePerSquare;
  }

  public double getDaysOnMarket() {
    return daysOnMarket;
  }

  public double getFinishedSquareTotal() {
    return finishedSquareTotal;
  }

  public double getLotSizeAcres() {
    return lotSizeAcres;
  }

  public int getYearBuilt() {
    return yearBuilt;
  }

  public int getNumberBedrooms() {
    return numberBedrooms;
  }

  public int getNumberRooms() {
    return numberRooms;
  }

  public String getGarage() {
    return garage;
  }

  public String getListingMember() {
    return listingMember;
  }

  public String getListingOffice() {
    return listingOffice;
  }

  public String getSellingMember() {
    return sellingMember;
  }

  public String getSellingOffice() {
    return sellingOffice;
  }

  public String getWaterView() {
    return waterView;
  }

  public String getWaterFrontage() {
    return waterFrontage;
  }

  public double getWaterFrontageAmount() {
    return waterFrontageAmount;
  }

  public String getWaterfrontDeep() {
    return waterfrontDeep;
  }

  public String getWaterfrontTidal() {
    return waterfrontTidal;
  }

  public double getFullTaxAmount() {
    return fullTaxAmount;
  }

  public String getHasBarn() {
    return hasBarn;
  }

  public int getBuyersZipCode() {
    return buyersZipCode;
  }

  // Setters

  public void setMlsNumber(String mlsNumber) {
    this.mlsNumber = mlsNumber;
  }

  public void setShortAddress(String shortAddress) {
    this.shortAddress = shortAddress;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public void setStreetType(String streetType) {
    this.streetType = streetType;
  }

  public void setTown(String town) {
    this.town = town;
  }

  public void setPropertyType(String propertyType) {
    this.propertyType = PropertyType.fromCode(propertyType);
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setListDate(String listDate) {
    this.listDate = listDate;
  }

  public void setListPrice(double listPrice) {
    this.listPrice = listPrice;
  }

  public void setListPricePerSquare(double listPricePerSquare) {
    this.listPricePerSquare = listPricePerSquare;
  }

  public void setPendingDate(String pendingDate) {
    this.pendingDate = pendingDate;
  }

  public void setClosedDate(String closedDate) {
    this.closedDate = closedDate;
  }

  public void setClosedPrice(double closedPrice) {
    this.closedPrice = closedPrice;
  }

  public void setClosedPricePerSquare(double closedPricePerSquare) {
    this.closedPricePerSquare = closedPricePerSquare;
  }

  public void setDaysOnMarket(double daysOnMarket) {
    this.daysOnMarket = daysOnMarket;
  }

  public void setFinishedSquareTotal(double finishedSquareTotal) {
    this.finishedSquareTotal = finishedSquareTotal;
  }

  public void setLotSizeAcres(double lotSizeAcres) {
    this.lotSizeAcres = lotSizeAcres;
  }

  public void setYearBuilt(int yearBuilt) {
    this.yearBuilt = yearBuilt;
  }

  public void setNumberBedrooms(int numberBedrooms) {
    this.numberBedrooms = numberBedrooms;
  }

  public void setNumberRooms(int numberRooms) {
    this.numberRooms = numberRooms;
  }

  public void setGarage(String garage) {
    this.garage = garage;
  }

  public void setListingMember(String listingMember) {
    this.listingMember = listingMember;
  }

  public void setListingOffice(String listingOffice) {
    this.listingOffice = listingOffice;
  }

  public void setSellingMember(String sellingMember) {
    this.sellingMember = sellingMember;
  }

  public void setSellingOffice(String sellingOffice) {
    this.sellingOffice = sellingOffice;
  }

  public void setWaterView(String waterView) {
    this.waterView = waterView;
  }

  public void setWaterFrontage(String waterFrontage) {
    this.waterFrontage = waterFrontage;
  }

  public void setWaterFrontageAmount(double waterFrontageAmount) {
    this.waterFrontageAmount = waterFrontageAmount;
  }

  public void setWaterfrontDeep(String waterfrontDeep) {
    this.waterfrontDeep = waterfrontDeep;
  }

  public void setWaterfrontTidal(String waterfrontTidal) {
    this.waterfrontTidal = waterfrontTidal;
  }

  public void setFullTaxAmount(double fullTaxAmount) {
    this.fullTaxAmount = fullTaxAmount;
  }

  public void setHasBarn(String hasBarn) {
    this.hasBarn = hasBarn;
  }

  public void setBuyersZipCode(int buyersZipCode) {
    this.buyersZipCode = buyersZipCode;
  }

}
