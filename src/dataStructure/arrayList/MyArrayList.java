package dataStructure.arrayList;

public class MyArrayList {
    private int[] arrayList;
    private int size;
    private int capacity;
    public MyArrayList(int capacity) {
        this.arrayList = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int element) {
        arrayList[size++] = element;

    }

    public void remove(int index) {
        if(isEmpty()){ throw new ArrayIndexOutOfBoundsException("Array is empty"); }
        for(int countt = index; countt < size - 1; countt++) {
            arrayList[countt] = arrayList[countt + 1];
            }
        size--;
        }

    public boolean contains(int element) {
        for(int count = 0; count < size; count++) {
            if(arrayList[count] == element) {
                return true;
            }
        }
        return false;
    }

    public void clear() {

        size = 0;
        for(int count = 0; count <= size; count++) {
            arrayList[count] = 0;
        }

    }

    public int set(int index, int element) {
        if(isEmpty()){ throw new ArrayIndexOutOfBoundsException("Array is empty"); }
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        arrayList[index] = element;
        return element;
    }

    public int get(int index) {
        if(isEmpty()){ throw new ArrayIndexOutOfBoundsException("Array is empty"); }
        return arrayList[index];
    }

    public void sort() {
        if(isEmpty()){ throw new ArrayIndexOutOfBoundsException("Array is empty"); }
        for(int count = 0; count < size - 1; count++) {
            for(int index = 0; index < size - count - 1; index++) {
                if(arrayList[index] > arrayList[index + 1]) {
                    int temp = arrayList[index];
                    arrayList[index] = arrayList[index + 1];
                    arrayList[index + 1] = temp;
                }
            }
        }
    }
}

