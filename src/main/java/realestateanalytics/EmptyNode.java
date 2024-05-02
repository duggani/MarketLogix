package realestateanalytics;
/*
 Name: Ian Duggan
 Assignment: Final Project
 Date: 4-6-24
 File: EmptyNode.java
 */

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The realestateanalytics.EmptyNode<T> class that implements the realestateanalytics.Node<T> interface.
 * 
 * @param <T> A generic type <T>.
 */
public class EmptyNode<T> implements Node<T> {

  /**
   * A method to add a new realestateanalytics.ContentNode in place of an realestateanalytics.EmptyNode.
   * 
   * @param data The data that will be encapsulated in the realestateanalytics.Node.
   * @return A new realestateanalytics.ContentNode along with the encapsulated data.
   */
  @Override
  public Node<T> add(T data) {
    return new ContentNode<>(data, this);
  }

  /**
   * Adds a node at the specified index. If called on an empty node, a new content node is created.
   * @param index The position where the node will be added.
   * @param data The data/element contained in the node.
   * @return a new content node.
   */
  public Node<T> add(int index, T data){
    if (index == 0) {
      return new ContentNode<>(data, new EmptyNode<>());
    } else {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
    }
  }

  /**
   * Removes a node based on the specified index. If this method is called on an empty node,
   * throws IndexOutOfBoundsException.
   * @param index The node to be removed.
   * @throws IndexOutOfBoundsException if method is called on an empty node.
   */
  @Override
  public Node<T> remove(int index){
    throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
  }

  /**
   * A method to remove the current realestateanalytics.Node if a Predicate condition is met.
   * Represents the base case in a recursive traversal while removing Nodes,
   * therefore,
   * no actual node removal will occur because this is called on an realestateanalytics.EmptyNode.
   * 
   * @param condition The condition that will be evaluated.
   * @return The current node unchanged, because this is called on an realestateanalytics.EmptyNode.
   */
  @Override
  public Node<T> removeIf(Predicate<T> condition) {
    return this;
  }

  /**
   * A getter method to return the data in the current realestateanalytics.Node. Returns null in an
   * realestateanalytics.EmptyNode.
   * 
   * @return Returns null in an realestateanalytics.EmptyNode.
   */
  @Override
  public T getData() {
    return null;
  }

  /**
   * A getNext method to get the next realestateanalytics.Node in the list. Will return null
   * in this case when it is called on an realestateanalytics.EmptyNode.
   * 
   * @return null
   */
  @Override
  public Node<T> getNext() {
    return null;
  }

  /**
   * A forEach method that takes in a Consumer<T> action. Because this is called
   * on an realestateanalytics.EmptyNode,
   * no action will occur.
   * 
   * @param action The action to be performed.
   */
  @Override
  public void forEach(Consumer<T> action) {
    // Since there is no task in an realestateanalytics.EmptyNode - this method does nothing
  }

  /**
   * A count method to count Nodes in the list. Because this is called on an
   * realestateanalytics.EmptyNode
   * this method will return 0.
   * 
   * @return 0
   */
  @Override
  public int count() {
    // this represents the base case - no count for an empty node.
    return 0;
  }

  @Override
  public int countHelp(int accumulator) {
    return accumulator;
  }

  /**
   * A countIf method that counts realestateanalytics.Node when a given Predicate condition is met.
   * Because
   * this is called on an realestateanalytics.EmptyNode, the node will not be counted.
   * 
   * @param condition The Predicate condition to be evaluated.
   * @return 0
   */
  @Override
  public int countIf(Predicate<T> condition) {
    // this represents the base case - no count for an empty node.
    return 0;
  }

  /**
   * A method that uses a converter Function to converts the data in each realestateanalytics.Node
   * from
   * type T into a new realestateanalytics.Node containing data of type R.
   * 
   * @param converter A function that takes an element of type T and converts it
   *                  into type R.
   * @return Returns a new realestateanalytics.EmptyNode when
   * @param <R> The type of data in the returned list. realestateanalytics.EmptyNode is returned when
   *            performed on
   *            an realestateanalytics.EmptyNode.
   */
  @Override
  public <R> Node<R> map(Function<T, R> converter) {
    return new EmptyNode<R>();
  }

  @Override
  public Node<T> filter(Predicate<T> predicate) {
    return new EmptyNode<T>();
  }
}
