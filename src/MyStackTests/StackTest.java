import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
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

    public static class MyStack {

        private int[] stackElements;
        private int top;
        private final int size;

        public MyStack(int size) {
            this.size = size;
            stackElements = new int[size];
            top = -1;
        }

        public boolean isEmpty() {
            return top == -1;

        }

        public void push(int elements) {
            if (top == size - 1) {
                throw new StackOverflowError("Stack is full");
            }
            stackElements[++top] = elements;
        }

        public int pop() {
            if (isEmpty()) {
                throw new StackOverflowError("Stack is empty");
            }
            return stackElements[top--];
        }

        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return stackElements[top];

        }

        public int size() {
            return top + 1;
        }

        public void clear() {
             top = - 1;
        }

        public int search(int value) {
            for (int count = top; count >= 0; count--) {
                if (stackElements[count] == value) {
                    return top - count + 1;

                }

            }
            return -1;
        }

        public boolean contains(int value) {
            for (int count = 0; count <= top; count++) {
                if (stackElements[count] == value) {
                    return true;
                }
            }
            return false;
        }

        public static void main(String[] args) {
            MyStack myStack = new MyStack(10);
            myStack.push(1);
            myStack.push(2);
            System.out.println("Peek "+ myStack.peek());
            System.out.println("pop "+ myStack.pop());
            System.out.println("con "+ myStack.contains(1));
            System.out.println("search "+ myStack.search(1));
            System.out.println("size "+ myStack.size());
            myStack.clear();


        }
    }
}
