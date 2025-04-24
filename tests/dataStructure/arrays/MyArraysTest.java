package dataStructure.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

public class MyArraysTest {
    private MyArrays myArrays;

    @BeforeEach
    public void setUp() {
        myArrays = new MyArrays(3);
    }

    @Test
    @DisplayName("test that array is empty initially")
    void testEmpty() {
       assertTrue(myArrays.isEmpty());
    }

    @Test
    @DisplayName("test that add method works")
    void testAdd() {
        myArrays.add(2);
        myArrays.add(2);
        myArrays.add(2);
        assertEquals(2, myArrays.getSIze());
    }
    @Test
    @DisplayName("test that add method throw exception when array is full")
    void testFull() {
        myArrays.add(2);
        myArrays.add(2);
        myArrays.add(2);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArrays.add(3));
    }

    @Test
    @DisplayName("test that get element by index method works")
    void testGetElementByIndex() {
        myArrays.add(2);
        myArrays.add(26);
        myArrays.add(7);
       assertEquals(26,  myArrays.get(1));
    }

    @Test
    @DisplayName("test that get element by index throw exception for none existing index")
    void testGetElementByIndexInvalid() {
        myArrays.add(2);
        myArrays.add(2);
       assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArrays.get(10));
    }

    @Test
    @DisplayName("test that remove element method works")
    void testRemoveElement() {
        myArrays.add(10);
        myArrays.add(22);
        myArrays.add(5);
        assertEquals(22, myArrays.remove(1));
    }

    @Test
    @DisplayName("test that remove element from empty array throw exception")
    void testRemoveElementFromEmptyArray() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> myArrays.remove(2));
    }

}































































