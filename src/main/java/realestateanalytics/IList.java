/*
 Name: Ian Duggan
 Assignment: Final Project
 Date: 4-6-24
 File: IList.java
 */

package realestateanalytics;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

/**
 * The realestateanalytics.IList<T> interface containing abstract methods.
 * 
 * @param <T> A generic type T
 */
public interface IList<T> {

  /**
   * Retrieves the item/data at a given index position in the list as specified by the given parameter.
   * @param index The index position at which the target data will be retrieved.
   * @return The item/data at the given index position.
   */
  T get(int index);

  /**
   * An abstract add method.
   * 
   * @param data The realestateanalytics.Node data to be added.
   */
  void add(T data);

  /**
   * Adds a new node/element to the list at the specified position.
   * @param index The position where the new node will be added.
   * @param data The data contained in the new node.
   */
  void add(int index, T data);

  /**
   * Removes a node from the linked list as specified by the given index.
   * @param index The node to be removed.
   */
  void remove(int index);

  /**
   * An abstract removeIf method.
   * 
   * @param condition The Predicate condition to be evaluated for realestateanalytics.Node removal.
   */
  void removeIf(Predicate<T> condition);

  /**
   * An abstract removeAll method.
   */
  public void removeAll();

  /**
   * An abstract count method.
   * 
   * @return An integer.
   */
  int count();

  /**
   * An abstract countIf method that takes in a Predicate<T>.
   * 
   * @param condition The Predicate condition.
   * @return An integer.
   */
  public int countIf(Predicate<T> condition);

  /**
   * An abstract forEach method.
   * 
   * @param action The action to be performed on each realestateanalytics.Node.
   */
  void forEach(Consumer<T> action);

  <R> IList<R> map(Function<T, R> converter);

  IList<T> filter(Predicate<T> predicate);
}
