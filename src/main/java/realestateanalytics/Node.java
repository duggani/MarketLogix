package realestateanalytics;
/*
 Name: Ian Duggan
 Assignment: Final Project
 Date: 4-6-24
 File: Node.java
 */

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The realestateanalytics.Node<T> interface with abstract methods.
 * 
 * @param <T> A generic T
 */
public interface Node<T> {

  /**
   * An add method that adds new Nodes with encapsulated data.
   * 
   * @param data The data encapsulated in the realestateanalytics.Node.
   */
  Node<T> add(T data);

  /**
   * Adds a new node and encapsulated data as specified by the given index position.
   * @param index The position where the node will be added.
   * @param data The data/element contained in the node.
   * @return The added node.
   */
  Node<T> add(int index, T data);

  /**
   * A method to remove a node as specified by the given index position.
   * @param index The node to be removed.
   * @return The node that followed the node that was removed.
   */
  Node<T> remove(int index);

  /**
   * A remove method that will remove nodes meeting a given Predicate condition.
   * 
   * @param condition The condition that must be met for node removal.
   */
  Node<T> removeIf(Predicate<T> condition);

  /**
   * A getter method that will return the data in the current node.
   *
   */
  T getData();

  /**
   * A method that will get the next node in the list.
   */
  Node<T> getNext();

  /**
   * A forEach method that performs a given action on
   * each node that is traversed utilizing the Consumer functional interface.
   * 
   * @param action The action to be performed on each node.
   */
  void forEach(Consumer<T> action);

  /**
   * A count method that counts each node traversed.
   */
  int count();

  int countHelp(int accumulator);

  /**
   * A count method that counts nodes meeting a given Predicate condition.
   * 
   * @param condition The Predicate condition that must be met.
   */
  int countIf(Predicate<T> condition);

  /**
   * A method that uses a converter Function to converts the data in each realestateanalytics.Node
   * from
   * type T into a new realestateanalytics.Node containing data of type R.
   * 
   * @param converter A function that takes an element of type T and converts it
   *                  into type R.
   * @return a new realestateanalytics.Node containing the converted data in the form of type R.
   * @param <R> The resulting data type that will be returned after the converter
   *            function is used.
   */
  <R> Node<R> map(Function<T, R> converter);

  /**
   * A filter method that will produce a new list, containing elements that pass
   * the predicate test.
   * 
   * @param predicate The predicate test to facilitate element filtering.
   * @return A list containing only element nodes that pass the filter/predicate
   *         test.
   */
  Node<T> filter(Predicate<T> predicate);
}
