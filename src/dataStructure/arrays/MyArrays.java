package dataStructure.arrays;

public class MyArrays {
    private int[] arrayElements;
    private int size;


    public MyArrays(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        arrayElements = new int[capacity];

        size = -1;

    }
    public boolean isEmpty() {
        return size == -1;
    }

    public int getSIze() {
        return size;
    }

    public void add(int element) {
        if (size == arrayElements.length) {
            throw new ArrayIndexOutOfBoundsException("Array is full");
        }
        arrayElements[++size] = element;

    }

    public int get(int index) {
        if (index < 0 || index >= getSIze()) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        return arrayElements[index];
    }

    public int remove(int index) {
        if (index < 0 || index >= getSIze()) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        int removedElement = arrayElements[index];
        for (int count = index; count < size - 1; count++) {
            arrayElements[count] = arrayElements[count + 1];
        }

        size--;
        return removedElement;

    }

}

















































