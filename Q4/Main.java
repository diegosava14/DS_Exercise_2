package Q4;

public class Main {

    static int arraySize = 60;
    static int NumThreads = 15; 
    static int toSearch = 17;

    public static void main(String[] args) {
        int[] Array = new int[arraySize];
        

        for (int i = 0; i < arraySize; i++) {
            Array[i] = i;
        }

        Search search = new Search();
        search.ParallelSearch(toSearch, Array, NumThreads);
    }
}
