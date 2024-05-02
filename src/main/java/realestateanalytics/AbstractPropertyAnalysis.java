/*
 Name: Ian Duggan
 Assignment: Final Project
 Date: April 2024
 File: AbstractPropertyAnalysis.java
 */

package realestateanalytics;
import java.util.function.Function;

/**
 * AbstractPropertyAnalysis abstract class contains attributes propertyMapping and properties. An abstract class that contains the
 * methods and logic that will be used to perform analytical operations in the subclasses that extend it.
 */
public abstract class AbstractPropertyAnalysis implements IPropertyAnalysis {

  protected PropertyMapping propertyMapping;
  protected MyLinkedList<Property> properties;

  /**
   * An AbstractPropertyAnalysis constructor that takes 1 parameter.
   * @param properties An instance of MyLinkedList that accepts Property as the type.
   */
  public AbstractPropertyAnalysis(MyLinkedList<Property> properties) {
    this.properties = properties;
  }

  /**
   * Returns the average value for a range of values as dictated by the metricSelector. Contains logic to ensure
   * that values included in calculation are not null. This is necessary due to fact that Active and Pending properties
   * have an empty Closed Price field in the CSV data.
   * @param metricSelector The particular metric that will be averaged.
   * @return A double that represents the average of all the values of that particular metric.
   */
  protected double average(Function<Property, Double> metricSelector) {
    int size = properties.count();
    if (size == 0)
      return 0;

    double sum = 0;
    int validCount = 0;
    for (int i = 0; i < size; i++) {
      Double value = metricSelector.apply(properties.get(i));
      if (value != null) {
        sum += value;
        validCount++;
      }
    }
    if (validCount > 0) {
      return sum / validCount;
    } else {
      return 0;
    }
  }

  /**
   * A totalSum method that calculates the total sum of elements as dictated by the supplied metricSelector. Utilizes the Function
   * interface to take in Property object data and map to Double.
   * @param metricSelector The metric to be calculated.
   * @return The total sum of the selected metric values.
   */
  protected double totalSum(Function<Property, Double> metricSelector) {
    double sum = 0;
    for (int i = 0; i < properties.count(); i++) {
      Property property = properties.get(i);
      sum += metricSelector.apply(property);
    }
    return sum;
  }

  /**
   * Finds and returns the max value for a given metric/field. Utilizes the Function
   * interface to take in Property object data and map to Double.
   * @return A double representing the max value for the given field.
   */
  protected double findMax(Function<Property, Double> metricSelector) {
    double max = Double.NEGATIVE_INFINITY;
    for (int i = 0; i < properties.count(); i++) {
      double value = metricSelector.apply(properties.get(i));
      if (value > max) {
        max = value;
      }
    }
    return max;
  }

  /**
   * Finds and returns the min value for a given field. Contains logic to ensure
   * that values included in calculation are not null. This is necessary due to fact that Active and Pending properties
   * have an empty Closed Price field in the CSV data. Utilizes the Function interface to take in Property data and map to Double.
   * @return the min value for the given field in the form of a double.
   */
  protected double findMin(Function<Property, Double> metricSelector) {
    Double min = null;
    for (int i = 0; i < properties.count(); i++){
      Double value = metricSelector.apply(properties.get(i));
      if (value != null && (min == null || value < min)) {
        min = value;
      }
    }
    return min != null ? min : 0;
  }
}

/*
Citations for use of Double class and Ternary Operator
[37] Oracle, “Double (Java Platform SE 8 ),” docs.oracle.com. https://docs.oracle.com/javase/8/docs/api/java/lang/Double.html
[38] J. Cook, “Check for null Before Calling Parse in Double.parseDouble,” Baeldung, Jan. 08, 2024. https://www.baeldung.com/java-check-null-parse-double
[39]Diancecht, “checking if double is null - Java - Tek-Tips,” www.tek-tips.com, Nov. 04, 2004. https://www.tek-tips.com/viewthread.cfm?qid=946213 (accessed Apr. 15, 2024).
[40]“Java.Lang.Double Class in Java,” GeeksforGeeks, Mar. 27, 2017. https://www.geeksforgeeks.org/java-lang-double-class-java/# (accessed Apr. 15, 2024).
[41]“Java Ternary Operator with Examples,” GeeksforGeeks, Nov. 25, 2019. https://www.geeksforgeeks.org/java-ternary-operator-with-examples/
[42]S. Srivastava, “Ternary Operator in Java,” Jan. 08, 2024.
 */