package Q4;

public class Main {
    public static void main(String[] args) {
        int[] Array = new int[6];
        int NumThreads = 2; 

        for (int i = 0; i < 6; i++) {
            Array[i] = i;
        }

        Search search = new Search();
        search.ParallelSearch(1001, Array, NumThreads);
    }
}
