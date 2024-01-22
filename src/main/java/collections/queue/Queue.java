package collections.queue;

import collections.exception.OverflowException;
import collections.exception.UnderflowException;

/**
 * Simple FIFO Queue implementation backed by a circular Array
 */
public class Queue {

    private static final int CAPACITY = 10;

    private final int[] elements = new int[CAPACITY];
    private int size = 0;
    private int headIdx = 0;
    private int tailIdx = -1;

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == elements.length;
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new OverflowException();
        }

        tailIdx = (tailIdx + 1) % elements.length;
        elements[tailIdx] = element;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        final int element = elements[headIdx];
        headIdx = (headIdx + 1) % elements.length;
        size--;
        return element;
    }

}
