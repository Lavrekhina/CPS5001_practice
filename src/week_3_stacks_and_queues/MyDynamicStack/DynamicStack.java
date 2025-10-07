package week_3_stacks_and_queues.MyDynamicStack;

public class DynamicStack {
    private int[] stack;
    private int top;

    // Constructor
    public DynamicStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Stack size must be greater than zero.");
        }
        stack = new int[initialCapacity];
        top = -1;
    }

    // Push operation (with automatic resizing)
    public void push(int value) {
        if (top == stack.length - 1) {
            resize();
        }
        stack[++top] = value;
        System.out.println(value + " pushed to the stack.");
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow! Cannot pop from an empty stack.");
            return -1;
        }
        int value = stack[top--];
        System.out.println(value + " popped from the stack.");
        return value;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek.");
            return -1;
        }
        return stack[top];
    }

    // Check if empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Get current size
    public int size() {
        return top + 1;
    }

    // Resize stack (double the capacity)
    private void resize() {
        int newCapacity = stack.length * 2;
        int[] newStack = new int[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
        System.out.println("Stack resized to capacity: " + newCapacity);
    }

    // ===== Main method for testing =====
    public static void main(String[] args) {
        DynamicStack stack = new DynamicStack(3);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40); // triggers resize

        System.out.println("Top element: " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop(); // popping all
        stack.pop(); // underflow

        stack.push(50);
        stack.push(60);
        System.out.println("Top element now: " + stack.peek());
    }
}
