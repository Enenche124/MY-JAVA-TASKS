package dataStructure.queue;

import java.util.Queue;

public class MyQueue {
    private int[] queue;
    private int size;
    private int head;
    private int tail;
    private int capacity;
    public MyQueue(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        queue = new int[capacity];
        size = 0;
        head = 0;
        tail = - 1;

    }

    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }
    public int getSize() {
        return size;
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Queue is full");
        }
        tail++;
        queue[tail] = element;
        size++;

    }


    public int dequeue() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        int removed = queue[head];
        size--;
        head++;
        return removed;

    }

    public int peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        return queue[head];
    }

    public void clear() {
        size = 0;
        head = 0;
        tail = - 1;

        for (int count = 0; count < queue.length; count++) {
            queue[count] = 0;
        }
    }

    public boolean contains(int element) {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }

        for(int count = head; count <= tail; count++) {
            if (queue[count] == element) {
                return true;
            }
        }
        return false;
    }
}
