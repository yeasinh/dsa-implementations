public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity + 1]; 
        // Index 0 is not used for simplicity
    }

    private int parent(int i) {
        return i / 2;
    }

    private int leftChild(int i) {
        return 2 * i;
    }

    private int rightChild(int i) {
        return 2 * i + 1;
    }

    private boolean isLeaf(int pos) {
        return pos > size / 2 && pos <= size;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert " + value);
            return;
        }

        size++;
        heap[size] = value;

        // Perform heapify up
        int current = size;
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMin() {
        if (size <= 0) {
            System.out.println("Heap is empty.");
            return -1;
        }

        // Swap the last item with the top (min) item
        // Extract the min item from the last position
        // Perform heapify down
        int min = heap[1];
        heap[1] = heap[size];
        size--;
        minHeapify(1);

        return min;
    }

    private void minHeapify(int current) {
        int min = current;
        int left = leftChild(current);
        int right = rightChild(current);

        if (left <= size && heap[left] < heap[min]) {
            min = left;
        }

        if (right <= size && heap[right] < heap[min]) {
            min = right;
        }

        if (current != min) {
            swap(current, min);
            minHeapify(min);
        }
    }

    public void display() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(4);
        minHeap.insert(8);
        minHeap.insert(2);
        minHeap.insert(6);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(3);

        System.out.print("Min heap: ");
        minHeap.display();

        System.out.println("Extracted min: " + minHeap.extractMin());

        System.out.print("Min heap after extraction: ");
        minHeap.display();
    }
}
