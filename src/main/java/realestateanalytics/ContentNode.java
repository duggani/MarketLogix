/*
 Name: Ian Duggan
 Assignment: Final Project
 Date: 4-6-24
 File: ContentNode.java
 */

package realestateanalytics;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The ContentNode<T> class that implements the Node interface. The
 * ContentNode<T> class
 * includes a T data and Node<T> next attributes.
 * 
 * @param <T> A generic type T
 */
public class ContentNode<T> implements Node<T> {

  private T data;

  private Node<T> next;

  /**
   * A ContentNode constructor that takes 2 parameters.
   *
   * @param data The data that is contained in the node.
   * @param next Reference to the next node in the list.
   */
  public ContentNode(T data, Node<T> next) {
    this.data = data;
    this.next = next;
  }

  /**
   * An add method to add a new node to the list. Recursively traverses the list
   * to find the correct
   * point for insertion.
   *
   * @param newData The data that will be added to the list, encapsulated within a
   *                Node element.
   * @return The current Node after insertion.
   */
  @Override
  public Node<T> add(T newData) {
    this.next = this.next.add(newData);
    return this;
  }

  /**
   * Adds a new node and encapsulated data as specified by the given index position.
   * @param index The position where the node will be added.
   * @param data The data/element contained in the node.
   * @return The added node.
   */
  @Override
  public Node<T> add(int index, T data){
    if (index == 0) {
      return new ContentNode<>(data, this);
    } else {
      this.next = this.next.add(index - 1, data);
      return this;
    }
  }

  /**
   * Removes the node as specified by the given index.
   * @param index The node to be removed.
   * @return The node that followed the node that was removed.
   */
  @Override
  public Node<T> remove(int index){
    if (index == 0) {
      return next;
    } else {
      next = next.remove(index - 1);
      return this;
    }
  }

  /**
   * A remove method to remove a node from the list if a certain condition is met.
   * Recursively
   * traverses the list to locate appropriate Nodes for removal.
   *
   * @param condition The Predicate condition that will be evaluated before Node
   *                  removal.
   * @return The current Node, if no Nodes are removed, or will return the next
   *         Node after a Node is
   *         removed.
   */
  @Override
  public Node<T> removeIf(Predicate<T> condition) {
    if (condition.test(this.data)) {
      return next.removeIf(condition);
    } else {
      this.next = this.next.removeIf(condition);
      return this;
    }
  }

  /**
   * A getter method to return the data in the current node.
   *
   * @return The data in the current node.
   */
  @Override
  public T getData() {
    return data;
  }

  /**
   * A getter method to retrieve the next Node in the list.
   *
   * @return The next Node in the list
   */
  @Override
  public Node<T> getNext() {
    return next;
  }

  /**
   * A forEach method that takes a Consumer "action" parameter and performs the
   * same action on each
   * Content Node it is called on.
   *
   * @param action The action to be performed on each Node. Note: Citations for
   *               use of this method
   *               and Consumer class at bottom of this file.
   */
  @Override
  public void forEach(Consumer<T> action) {
    action.accept(this.data);
    this.next.forEach(action);
  }

  /**
   * A count method used for counting all Nodes in the list, without conditions.
   *
   * @return 1 (representing the count for the current Node) plus a recursive call
   *         to the next Node.
   */
  @Override
  public int count() {
    return countHelp(0);
  }

  @Override
  public int countHelp(int accumulator) {
    return next.countHelp(accumulator + 1);
  }

  /**
   * A countIf method that counts Nodes if they meet a specified Predicate
   * condition.
   *
   * @param condition The condition that must be satisfied for the Node to be
   *                  counted.
   * @return Count variable plus a recursive call to the next Node.
   */
  @Override
  public int countIf(Predicate<T> condition) {
    int count;
    if (condition.test(this.data)) {
      count = 1;
    } else {
      count = 0;
    }
    return count + this.next.countIf(condition);
  }

  /**
   * A method that uses a converter Function to converts the data in each Node
   * from
   * type T into a new Node containing data of type R.
   * 
   * @param converter A function that takes an element of type T and converts it
   *                  into type R.
   * @return a new ContentNode containing the converted data in the form of type
   *         R.
   * @param <R> The resulting data type that will be returned after the converter
   *            function is used.
   */
  @Override
  public <R> Node<R> map(Function<T, R> converter) {
    return new ContentNode<R>(
        converter.apply(this.data),
        this.next.map(converter));

  }

  @Override
  public Node<T> filter(Predicate<T> predicate) {
    if (predicate.test(data))
      return new ContentNode<T>(data, next.filter(predicate));
    return next.filter(predicate);
  }
}

/*
 * Consumer class Citations
 * 1. Head First Java, "12 Lambdas and Streams:
 * What Not How: Lambdas and Streams", subsection
 * "How can I tell if a method takes a lambda."
 * & subsection "Hello Lambda, my (not so) old friend -
 * Passing behavior around"
 *
 * 2.Oracle, “Consumer (Java Platform SE 8 ),”
 * docs.oracle.com. https://docs.oracle.com/javase/8
 * /docs/api/java/util/function/Consumer.html
 *
 * 3. Java Cookbook, 4th Edition. "7.6 How Shall I iterate
 * Thee? Let Enumerate The Ways." Subsection "Iterable.forEach -
 * method (Java 8)".
 *
 * 4. @CoderGrammer, “Java :: Function vs Supplier vs Consumer ::
 * Functional Programming,” www.youtube.com, Jul. 11, 2022. https:
 * //www.youtube.com/watch?v=lv8LaC_6UM0&ab_channel=CoderGrammer
 * (accessed Mar. 20, 2024).
 *
 * 5. Oracle, “Using Lambdas Expressions in Your Application - Dev.java,”
 * Dev.java: The Destination for Java Developers, Oct. 26, 2021.
 * https://dev.java/learn/lambdas/functional-interfaces/ (accessed Mar. 20,
 * 2024).
 ******/
