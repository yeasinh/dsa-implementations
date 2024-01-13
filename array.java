import java.util.Arrays;

public class ArrayOperations {
    private int[] array;
    private int size;

    // Constructor to initialize the array
    public ArrayOperations(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    // Count the number of elements in the array
    public int countElements() {
        return size;
    }

    // Add an element to the end of the array
    public void addElement(int element) {
        if (size < array.length) {
            array[size] = element;
            size++;
        } 
        else {
            // Handle array resizing if needed
            // int[] newArray = new int[array.length * 2];
            // System.arraycopy(array, 0, newArray, 0, array.length);
            int newSize = array.length * 2;
            int[] newArray = Arrays.copyOf(array, newSize);
            array = newArray;
            array[size] = element;
            size++;
        }
    }

    // Remove an element by its index
    public void removeElement(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }

    // Find the smallest element in the array
    public int findSmallestElement() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        int smallest = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    // Sort the array in ascending order using bubble sort
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Reverse the elements in the array
    public void reverse() {
        int left = 0;
        int right = size - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ArrayOperations arrayOps = new ArrayOperations(4);

        arrayOps.addElement(5);
        arrayOps.addElement(2);
        arrayOps.addElement(8);
        arrayOps.addElement(9);
        arrayOps.addElement(0);
        arrayOps.addElement(5);

        System.out.println("Number of elements: " + arrayOps.countElements());

        arrayOps.removeElement(1);
        System.out.println("Number of elements after removal: " + arrayOps.countElements());

        System.out.println("Smallest element: " + arrayOps.findSmallestElement());

        arrayOps.sort();
        System.out.println("Sorted array: " + Arrays.toString(arrayOps.array));

        arrayOps.reverse();
        System.out.println("Reversed array: " + Arrays.toString(arrayOps.array));
    }
}
