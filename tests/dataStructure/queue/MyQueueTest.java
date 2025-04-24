package dataStructure.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest {

    private MyQueue queue;
    @BeforeEach
    void setUp() {
        queue = new MyQueue(3);
    }

    @Test
    @DisplayName("test that queue is empty initially")
    void testEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("test that get size method works")
    void testSize() {
        assertEquals(0, queue.getSize());
    }
@Test
@DisplayName("test that is full method works")
void testFull() {
        assertFalse(queue.isFull());
}
    @Test
    @DisplayName("test that enqueue method works")
    void testEnqueue() {
        queue.enqueue(23);
        queue.enqueue(23);
        assertEquals(2, queue.getSize());
    }

    @Test
    @DisplayName("test that enqueue method throws exception when queue is full")
    void testEnqueueThrowsExceptionWhenQueueIsFull() {
        queue.enqueue(23);
        queue.enqueue(23);
        queue.enqueue(23);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.enqueue(23));
    }

    @Test
    @DisplayName("test that dequeue method works")
    void testDequeue() {
        queue.enqueue(23);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(23, queue.dequeue());
    }
    @Test
    @DisplayName("test that dequeue method throws exception when queue is empty")
    void testDequeueThrowsExceptionWhenQueueIsEmpty() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Test
    @DisplayName("test that peek method works")
    void testPeek() {
        queue.enqueue(23);
        queue.enqueue(20);
        assertEquals(23, queue.peek());
    }

    @Test
    @DisplayName("test that clear method works")
    void testClear() {
        queue.enqueue(23);
        queue.enqueue(20);
        queue.enqueue(5);
        queue.clear();
        assertEquals(0, queue.getSize());
    }

    @Test
    @DisplayName("test that contains method works")
    void testContains() {
        queue.enqueue(23);
        queue.enqueue(20);
        queue.enqueue(5);
        queue.dequeue();
        assertEquals(2, queue.getSize());
        assertTrue(queue.contains(20));
    }


}