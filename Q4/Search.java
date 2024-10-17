package Q4;

import java.util.ArrayList;

public class Search {
    public Search(){

    }

    static class Searcher implements Runnable {
        
        private int[] Array;
        private int toSearch;
        private int threadNum;


        public Searcher(int toSearch, int[] Array, int threadNum) {
            this.Array = Array;
            this.toSearch = toSearch;
            this.threadNum = threadNum;
        }

        @Override 
        public void run() {

            boolean found = false;
            for (int i = 0; i < Array.length; i++) {
                if (Array[i] == toSearch) {
                    System.out.println("Thread " + threadNum + " has found the value");
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.print("[");
                for (int i = 0; i <  Array.length - 1; i++) {
                    System.out.print(Array[i] + ", ");
                }
                System.out.println(Array[Array.length - 1] + "]");
            } else {
                System.out.println("The number was not found");
            }

        }
    }

    public void ParallelSearch(int toSearch, int[] Array, int numThreads){
        ArrayList<int[]> chunks = new ArrayList<int[]>();
        int chunkSize = Array.length / numThreads;
        Thread[] threads = new Thread[numThreads];
        
        for (int i = 0; i < numThreads; i++) {
            int[] aux = new int[chunkSize];
            int start = i * chunkSize;
            int end = (i + 1) * chunkSize;
            if (i == numThreads - 1) {
                end = Array.length;
            }
            int k = 0;
            for (int j = start; j < end; j++) {
                aux[k] = Array[j];
                k++;
            }
            chunks.add(aux);
        }

        long startTime = System.nanoTime()/1000000;
       
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new Searcher(toSearch, chunks.get(i), i));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime()/1000000;
        System.out.println("Time taken: " +  (endTime - startTime) + " ms");
    }
}
