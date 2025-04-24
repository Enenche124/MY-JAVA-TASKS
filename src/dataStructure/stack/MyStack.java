package dataStructure.stack;

public class MyStack {

        private final int[] stackElements;
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


