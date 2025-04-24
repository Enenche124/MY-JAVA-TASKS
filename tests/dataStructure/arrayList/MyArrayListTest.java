package dataStructure.arrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

    private MyArrayList myArrayList;

    @BeforeEach
    void setUp() {
        myArrayList = new MyArrayList(10);
    }

    @Test
    @DisplayName("test that isEmpty method works")
    void testIsEmpty() {
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    @DisplayName("test that add method works")
    void testAdd() {
        myArrayList.add(3);
        myArrayList.add(6);
        assertEquals(2, myArrayList.getSize());
    }

    @Test
    @DisplayName("test that remove method works")
    void testRemove() {
        myArrayList.add(3);
        myArrayList.add(6);
        myArrayList.remove(1);
        assertEquals(1, myArrayList.getSize());
    }

    @Test
    @DisplayName("test that contains method works")
    void testContains() {
        myArrayList.add(3);
        myArrayList.add(6);
        assertTrue(myArrayList.contains(6));
    }

    @Test
    @DisplayName("test that clear method works")
    void testClear() {
        myArrayList.add(3);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.clear();
        assertEquals(0, myArrayList.getSize());
    }

    @Test
    @DisplayName("test that set method works")
    void testSet() {
        myArrayList.add(3);
        myArrayList.add(6);
        myArrayList.add(7);
      assertEquals(88,   myArrayList.set(0, 88));
    }


    @Test
    @DisplayName("test that get method")
    void testGet() {
        myArrayList.add(3);
        myArrayList.add(6);
        myArrayList.add(7);
        assertEquals(6, myArrayList.get(1));
    }

    @Test
    @DisplayName("test that sort method works")
    void testSort() {
        myArrayList.add(3);
        myArrayList.add(6);
        myArrayList.add(1);
        myArrayList.sort();
        assertEquals(1, myArrayList.get(0));
        assertEquals(3, myArrayList.get(1));
    }
}






















