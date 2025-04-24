package dataStructure.set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MySetTest {

    private MySet mySet;
    @BeforeEach
    public void setUp() {
         mySet = new MySet(10);
    }

    @Test
    @DisplayName("test that is empty method works")
    public void testEmpty() {
        assertTrue(mySet.isEmpty());
    }

    @Test
    @DisplayName("test that add method works")
    public void testAdd() {
        mySet.add(23);
        mySet.add(23);
        mySet.add(2);
        assertEquals(2, mySet.getSize());
    }
    @Test
    @DisplayName("test that contains method works")
    public void testContains() {
        mySet.add(23);
        mySet.add(3);
        mySet.add(2);
        assertTrue(mySet.contains(3));
    }
    @Test
    @DisplayName("test that remove method works")
    public void testRemove() {
        mySet.add(23);
        mySet.add(3);
        mySet.add(2);
        mySet.remove(2);
        assertEquals(2, mySet.getSize());
    }
    @Test
    @DisplayName("test that remove method throws exception when element is not found")
    public void testRemoveException() {
        mySet.add(23);
        mySet.add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> mySet.remove(2));
    }

    @Test
    @DisplayName("test that toArray method works")
    public void testToArray() {
        mySet.add(23);
        mySet.add(3);
        mySet.add(2);

        int[] result = mySet.toArray();
        assertArrayEquals(new int[]{23, 3, 2}, result);
    }

    @Test
    @DisplayName("test that equals method works")
    public void testEquals() {
        MySet mySet2 = new MySet(10);
        MySet mySet3 = new MySet(10);
        mySet3.add(10);
        mySet3.add(20);
        mySet3.add(30);

        mySet2.add(30);
        mySet2.add(20);
        mySet2.add(10);
        assertTrue(mySet3.equals(mySet2));
    }
}