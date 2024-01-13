public class QueueWithArray {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int size;

    public QueueWithArray(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue an element into the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }

        rear = (rear + 1) % maxSize;
        queueArray[rear] = data;
        size++;
    }

    // Dequeue and return the front element from the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int data = queueArray[front];
        front = (front + 1) % maxSize;
        size--;
        return data;
    }

    // Return the front element from the queue without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return queueArray[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == maxSize;
    }

    // Display the elements of the queue
    public void display() {
        int count = 0;
        int index = front;

        while (count < size) {
            System.out.print(queueArray[index] + " ");
            index = (index + 1) % maxSize;
            count++;
        }

        System.out.println();
    }

    // Merge another queue into the current queue
    public void merge(QueueWithArray queue2) {
        if (queue2 == null || queue2.isEmpty()) {
            return;
        }
        while (!queue2.isEmpty()) {
            int element = queue2.dequeue();
            this.enqueue(element);
        }
    }

    public static void main(String[] args) {
        QueueWithArray queue1 = new QueueWithArray(10);
        QueueWithArray queue2 = new QueueWithArray(10);

        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);

        queue2.enqueue(4);
        queue2.enqueue(5);
        queue2.enqueue(6);

        System.out.print("Queue 1: ");
        queue1.display();

        System.out.print("Queue 2: ");
        queue2.display();

        queue1.merge(queue2);
        System.out.print("Queue 1 after merging with Queue 2: ");
        queue1.display();

        System.out.println("Dequeued element from Queue 1: " + queue1.dequeue());

        System.out.println("Front element of Queue 1: " + queue1.peek());

        System.out.println("Is Queue 1 empty? " + queue1.isEmpty());
        System.out.println("Is Queue 1 full? " + queue1.isFull());
    }
}
