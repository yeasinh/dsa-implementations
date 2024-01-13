public class StackWithArray {
    private int capacity;
    private int[] stackArray;
    private int top;

    public StackWithArray(int size) {
        capacity = size;
        stackArray = new int[capacity];
        top = -1;
    }

    // Push an element onto the stack
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + data);
            return;
        }
        stackArray[++top] = data;
    }

    // Pop and return the top element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray[top--];
    }

    // Return the top element from the stack without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Display the elements of the stack
    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    // Merge another stack into the current stack
    public void merge(StackWithArray stack2) {
        if (stack2 == null || stack2.isEmpty()) {
            return;
        }

        while (!stack2.isEmpty()) {
            int element = stack2.pop();
            this.push(element);
        }
    }

    public static void main(String[] args) {
        StackWithArray stack1 = new StackWithArray(10);
        StackWithArray stack2 = new StackWithArray(10);

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);

        stack2.push(6);
        stack2.push(7);
        stack2.push(8);
        stack2.push(9);

        System.out.print("Stack 1: ");
        stack1.display();

        System.out.print("Stack 2: ");
        stack2.display();

        stack1.merge(stack2);
        System.out.print("Stack 1 after merging with Stack 2: ");
        stack1.display();

        System.out.println("Popped element from Stack 1: " + stack1.pop());

        System.out.println("Top element of Stack 1: " + stack1.peek());

        System.out.println("Is Stack 1 empty? " + stack1.isEmpty());
        System.out.println("Is Stack 1 full? " + stack1.isFull());
    }
}
