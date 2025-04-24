package dataStructure.set;

public class MySet {
    private int[] setElements;
    private int size;
    private int capacity;

    public MySet(int capacity) {
        this.capacity = capacity;
        setElements = new int[capacity];
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int element) {
        if(!contains(element)){
            if(size == capacity) {
                throw new ArrayIndexOutOfBoundsException("Set is full");
            }
            setElements[size++] = element;
        }

    }

    public boolean contains(int element) {
        for(int count = 0; count < size; count++) {
            if(element == setElements[count]) {
                return true;
            }
        }
        return false;
    }

    public void remove(int element) {
        if(isEmpty()){ throw new ArrayIndexOutOfBoundsException("Array is empty"); }
        if (!contains(element)) {
            throw new ArrayIndexOutOfBoundsException("Element not found");
        }
        for(int count = 0; count < size; count++) {
            if(element == setElements[count]) {
                for(int index = count; index < size - 1; index++) {
                    setElements[index] = setElements[index + 1];
                }
                size--;
                return;
            }
        }
    }

    public int[] toArray() {
        int[] result = new int[size];
        for(int count = 0; count < size; count++) {
            result[count] = setElements[count];
        }
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MySet otherSet = (MySet) o;

        if (this.size != otherSet.size) return false;

        for (int i = 0; i < this.size; i++) {
            if (!otherSet.contains(this.setElements[i])) {
                return false;
            }
        }

        return true;
    }

}
