package Q4;

import java.util.ArrayList;

public class Search {
    public Search(){

    }

    public void ParallelSearch(int toSearch, int[] Array, int numThreads){
        ArrayList<Integer[]> range = new ArrayList<Integer[]>();
        int chunkSize = Array.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i + 1) * chunkSize;
            if (i == numThreads - 1) {
                end = Array.length;
            }
            range.add(new Integer[]{start, end});
        }

        for (int i=0; i<range.size(); i++){
            System.out.println(range.get(i)[0] + " " + range.get(i)[1]);
        }
    }
}
