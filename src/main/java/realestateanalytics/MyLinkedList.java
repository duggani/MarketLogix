package realestateanalytics;
/*
 Name: Ian Duggan
 Assignment: Final Project
 Date: 4-6-24
 File: myLinkedList.java
 */

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The LinkedList<T> class that implements the IList<T> interface.
 * 
 * @param <T> A generic type T.
 */
public class MyLinkedList<T> implements IList<T> {

  private Node<T> head;

  /**
   * A LinkedList constructor that takes no parameters.
   */
  public MyLinkedList() {
    head = new EmptyNode<T>();
  }

  /**
   * A private
   * LinkedList constructor that takes one parameter.
   * 
   * @param head The head node.
   *             Note: This is a private constructor that will be used later for
   *             map.
   */
  private MyLinkedList(Node<T> head) {
    this.head = head;
  }

  /**
   * Checks to see if the LinkedList is empty.
   * @return true if the LinkedList is empty.
   */
  public boolean isEmpty(){
    return head == null;
  }

  /**
   * Returns the head node.
   * @return The head node in a LinkedList.
   */
  public Node<T> getHead(){
    return head;
  }

  /**
   * Retrieves the item/data at a given index position in the list as specified by the given parameter.
   * @param index The index position at which the target data will be retrieved.
   * @return The item/data at the given index position.
   */
  public T get(int index){
    if (index < 0 || index >= this.count()) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for list size " + this.count());
    }
    Node<T> current = head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current.getData();
  }

  /**
   * An add method that adds a new Node to the LinkedList. Recursively traverses
   * the list to find the correct point for Node insertion.
   * 
   * @param data The data to be added, encapsulated in the Node.
   */
  @Override
  public void add(T data) {
    head = head.add(data);
  }

  public void add(int index, T data) {
    if (index < 0 || index > this.count()) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + this.count());
    }
    head = head.add(index, data);
  }

  /**
   * A forEach method that performs a given action on each Node utilizing the
   * Consumer functional interface.
   * Recursively traverses the list to perform action on each node.
   * 
   * @param action The action to be performed on each Node.
   */
  @Override
  public void forEach(Consumer<T> action) {
    head.forEach(action);
  }

  /**
   * Removes a node from the list as specified by the given index.
   * @param index The node to be removed.
   */
  public void remove(int index){
    if (index < 0 ||index>= this.count()) {
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + this.count());
    }
    head = head.remove(index);
  }

  /**
   * A removeIf method that removes Nodes from the list when they meet the given
   * Predicate condition. Recursively traverses the list removing all Nodes
   * meeting the condition.
   * 
   * @param condition The Predicate condition to be evaluated for Node removal.
   */
  @Override
  public void removeIf(Predicate<T> condition) {
    head = head.removeIf(condition);
  }

  /**
   * A countIf method that counts Nodes in the list when they meet a given
   * Predicate condition. Recursively traverses the list counting all Nodes
   * meeting the condition.
   * 
   * @param condition The Predicate condition to be evaluated for Node counting.
   * @return The count of all Nodes meeting the condition.
   */
  @Override
  public int countIf(Predicate<T> condition) {
    return head.countIf(condition);
  }

  /**
   * A count method that recursively traverses the list counting all Nodes.
   * 
   * @return the count of all Nodes in the list.
   */
  @Override
  public int count() {
    return head.count();
  }

  /**
   * A method to remove all tasks in the list and resets with an Empty Node.
   */
  @Override
  public void removeAll() {
    head = new EmptyNode<T>();
  }

  @Override
  public <R> MyLinkedList<R> map(Function<T, R> converter) {
    return new MyLinkedList<R>(head.map(converter));
  }

  @Override
  public IList<T> filter(Predicate<T> predicate) {
    return new MyLinkedList<T>(head.filter(predicate));
  }

}
