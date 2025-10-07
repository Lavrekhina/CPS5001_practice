package week_3_stacks_and_queues.NewStack;

public class NewStack {
    private int capacity;
    private int[] data;
    private int size;
    private int top;

    // Constructor
    public NewStack(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        size = 0;
        top = -1;
    }

    // Push method (with dynamic resizing)
    public void push(int element) {
        if (size == capacity) {
            resize(); // Automatically increase stack size
        }
        data[++top] = element;
        size++;
    }

    // Pop method (your version, corrected)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        size--;
        return data[top--];
    }

    // Peek method
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return data[top];
    }

    // Check if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Resize method
    private void resize() {
        System.out.println("Resizing stack...");
        int[] newData = new int[capacity * 2];
        for (int i = 0; i <= top; i++) {
            newData[i] = data[i];
        }
        data = newData;
        capacity *= 2;
    }

    // Display method
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    // Test the stack
    public static void main(String[] args) {
        NewStack stack = new NewStack(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        stack.push(40); // triggers resizing
        stack.display();

        System.out.println("Peek: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        stack.display();
    }
}
