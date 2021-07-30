package datastructure;

/**
 * A class that implements a doubly linked list
 *
 * @param <T> The type of the elements stored in the list
 * @author Ima Miri <ima.miri11@gmail.com>
 */
public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public int size() {
        return this.size;
    }

    /**
     * Get the node data at the position index
     *
     * @return The node data
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) {
        if (index > (size() - 1) || index < 0) {
            throw new IndexOutOfBoundsException("The index is out of bounds.");
        }

        Node<T> curr = head;
        for (int i = 0; i < size(); i++) {
            if (i != index)
                curr = curr.getNext();
            else
                return curr.getData();
        }
        return null;
    }

    /**
     * Add a new node data to the end of the linkedList
     *
     * @param data The new node data to add
     * @return true when add a new node successfully
     */
    public boolean add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else if (tail == null) {
            tail = newNode;
            head.setNext(tail);
            tail.setPrev(head);
        } else {
            Node<T> temp = tail;
            temp.setNext(newNode);
            temp.getPrev().setNext(temp);
            newNode.setPrev(temp);
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Add a new node data to the linkedList at the specified index
     *
     * @param index Where the node should be added
     * @param data  The node data to add
     */
    public void add(int index, T data) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("The index is out of bounds.");
        }

        if ((index == 0 && head == null) || index == size()) {
            add(data);
        } else {
            Node<T> curr = head;
            for (int i = 0; i <= size(); i++) {
                if (i != index)
                    curr = curr.getNext();
                else {
                    Node<T> newElement = new Node<T>(data);
                    newElement.setNext(curr);
                    newElement.setPrev(curr.getPrev());
                    curr.getPrev().setNext(newElement);
                    curr.setPrev(newElement);
                    size++;
                    return;
                }
            }
        }
    }

    /**
     * Set a new data at index position in the linkedList
     *
     * @param index The index of the data to change
     * @param data  The new data
     * @return The Node data that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T set(int index, T data) {
        if (index > (size() - 1) || index < 0) {
            throw new IndexOutOfBoundsException("The index is out of bounds.");
        }

        Node<T> curr = head;
        for (int i = 0; i < size(); i++) {
            if (i != index)
                curr = curr.getNext();
            else
                curr.setData(data);
        }

        return null;
    }

    /**
     * Remove a node at the specified index and return its data .
     *
     * @param index The index of the node to remove
     * @return The data of node removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the list
     */
    public T remove(int index) {
        if (index > (size() - 1) || index < 0) {
            throw new IndexOutOfBoundsException("The index is out of bounds.");
        }

        Node<T> curr = head;
        for (int i = 0; i < size(); i++) {
            if (i != index)
                curr = curr.getNext();
            else {
                T temp = curr.getData();
                if (curr.getPrev() == null && curr.equals(head)) {
                    if (curr.getNext() != null)
                        curr.getNext().setPrev(null);
                    head = curr.getNext();
                } else if (curr.getNext() == null && curr.equals(tail)) {
                    curr.getPrev().setNext(null);
                    if (!curr.equals(tail))
                        tail = curr.getPrev();
                    else
                        tail = curr.getNext();
                } else {
                    curr.getNext().setPrev(curr.getPrev());
                    curr.setData(curr.getNext().getData());
                    curr.setNext(curr.getNext().getNext());
                }
                size--;
                return temp;
            }
        }
        return null;
    }
}

class Node<T> {

    Node<T> prev;
    Node<T> next;
    T data;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
