package stack;

import static org.junit.jupiter.api.Assertions.*;

import dataStructure.stack.MyStack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class MyStackTest {

        private MyStack stack;

        @BeforeEach
        public void setUp() {
            stack = new MyStack(10);
        }


        @Test
        public void checkThatStackIsEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        public void checkThatStackIsNotEmptyAfterPush() {
            stack.push(5);
            assertFalse(stack.isEmpty());
        }

        @Test
        public void checkThatStackThrowExceptionOnPopIfStackIsEmpty() {
            assertThrows(StackOverflowError.class, () -> stack.pop());
        }

        @Test
        public void checkThatStackThrowExceptionOnPeekIfStackIsNotEmpty() {
            assertThrows(IllegalStateException.class, () -> stack.peek());

        }

        @Test
        public void checkForPushAndPopFunctionality() {
            stack.push(5);
            stack.push(6);
            assertEquals(6, stack.pop());
            assertEquals(5, stack.pop());
        }

        @Test
        public void checkForStackSizePushAndPop() {
            stack.push(5);
            stack.push(6);
            assertEquals(2, stack.size());
            stack.pop();
            assertEquals(1, stack.size());
            stack.pop();
            assertEquals(0, stack.size());
        }

        @Test
        public void checkForClearMethod() {
            stack.push(5);
            stack.push(6);
            stack.clear();
            assertTrue(stack.isEmpty());
        }

        @Test
        public void checkForSearchMethod() {
            stack.push(5);
            stack.push(6);
            stack.push(7);
            assertEquals(3, stack.search(5));
            assertEquals(1, stack.search(7));
            assertEquals(2, stack.search(6));
        }

        @Test
        public void checkForContainsMethod() {
            stack.push(5);
            stack.push(6);
            assertTrue(stack.contains(5));
            assertTrue(stack.contains(6));
        }

}