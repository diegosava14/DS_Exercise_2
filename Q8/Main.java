package Q8;

import java.util.Random;

public class Main {

    static int arraySize = 48;

    public static void main(String[] args) {
        Random rand = new Random();
        int[] Array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            Array[i] = rand.nextInt(arraySize);
        }

        System.out.print("Initial Array: ");
        System.out.print("[ ");
        for (int i = 0; i < arraySize-1; i++) {
            System.out.print(Array[i] + ", ");
        }
        System.out.println(Array[arraySize-1] + " ]");

        long startTime = System.nanoTime()/1000000;

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(Array, 0, arraySize - 1);

        long endTime = System.nanoTime()/1000000;

        System.out.print("Sorted Array: ");
        System.out.print("[ ");
        for (int i = 0; i < arraySize-1; i++) {
            System.out.print(Array[i] + ", ");
        }
        System.out.println(Array[arraySize-1] + " ]");

        System.out.println("Time taken: " +  (endTime - startTime) + " ms");
    }
}
