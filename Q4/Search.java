package Q4;

import java.util.ArrayList;

public class Search {
    public Search(){

    }

    static class Searcher implements Runnable {
        
        private int[] Array;
        private int start;
        private int end;
        private int toSearch;
        private int threadNum;


        public Searcher(int toSearch, int[] Array, int start, int end, int threadNum) {
            this.Array = Array;
            this.start = start;
            this.end = end;
            this.toSearch = toSearch;
            this.threadNum = threadNum;
        }

        @Override 
        public void run() {
            boolean found = false;
            for (int i = start; i < end; i++) {
                if (Array[i] == toSearch) {
                    System.out.println("Thread " + threadNum + " has found the value");
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.print("[");
                for (int i = start; i < end - 1; i++) {
                    System.out.print(Array[i] + ", ");
                }
                System.out.println(Array[end - 1] + "]");
            }

        }
    }

    public void ParallelSearch(int toSearch, int[] Array, int numThreads){
        ArrayList<Integer[]> range = new ArrayList<Integer[]>();
        int chunkSize = Array.length / numThreads;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i + 1) * chunkSize;
            if (i == numThreads - 1) {
                end = Array.length;
            }
            range.add(new Integer[]{start, end});
        }

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new Searcher(toSearch, Array, range.get(i)[0], range.get(i)[1], i));
            threads[i].run();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
