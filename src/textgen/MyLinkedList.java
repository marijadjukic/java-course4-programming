package textgen;

import java.util.AbstractList;


/**
 * A class that implements a doubly linked list
 *
 * @param <E> The type of the elements stored in the list
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class MyLinkedList<E> extends AbstractList<E> {
    LLNode<E> head;
    LLNode<E> tail;
    int size;

    /**
     * Create a new empty LinkedList
     */
    public MyLinkedList() {
        // TODO: Implement this method
        size = 0;
        head = new LLNode<E>(null);
        tail = new LLNode<E>(null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Appends an element to the end of the list
     *
     * @param element The element to add
     */
    public boolean add(E element) throws NullPointerException {
        // TODO: Implement this method
        LLNode<E> node = new LLNode<E>(element);
        if (element == null) throw new NullPointerException();
        if (size == 0) {
            head.next = node;
            node.prev = head;
            node.next = tail;
            tail.prev = node;
            size++;
        } else {
            node.prev = tail.prev;
            node.next = node.prev.next;
            node.prev.next = node;
            tail.prev = node;
            size++;
        }
        return true;

    }

    /**
     * Get the element at position index
     *
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        int count = 0;
        LLNode<E> node = head.next;
        while (count < index) {
            node = node.next;
            count++;

        }
        return node.data;
    }

    /**
     * Add an element to the list at the specified index
     *
     * @param The     index where the element should be added
     * @param element The element to add
     */
    public void add(int index, E element) {
        // TODO: Implement this method
        LLNode<E> newNode = new LLNode<E>(element);
        LLNode<E> node = head.next;
        int count = 0;
        if (element == null) throw new NullPointerException();
        if(size !=0 && (index >= size || index < 0)){
            throw new IndexOutOfBoundsException();
        }
        while (count<index){
            node = node.next;
            count++;
        }
        newNode.prev = node.prev;
        newNode.next = newNode.prev.next;
        newNode.prev.next = newNode;
        node.prev = newNode;
        size++;
    }


    /**
     * Return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Remove a node at the specified index and return its data element.
     *
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the list
     */
    public E remove(int index) {
        // TODO: Implement this method
        LLNode<E> node = head.next;
        int count = 0;
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        while (count<index){
            node = node.next;
            count++;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size --;
        return node.data;
    }

    /**
     * Set an index position in the list to a new element
     *
     * @param index   The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element) {
        // TODO: Implement this method
        LLNode<E> node = head.next;
        int count = 0;
        if (element == null) throw new NullPointerException();
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        while (count<index){
            node = node.next;
            count++;
        }
        E replacedElement = node.data;
        node.data = element;
        return replacedElement;
    }
}

class LLNode<E> {
    LLNode<E> prev;
    LLNode<E> next;
    E data;

    // TODO: Add any other methods you think are useful here
    // E.g. you might want to add another constructor

    public LLNode(E e) {
        this.data = e;
    }

}
