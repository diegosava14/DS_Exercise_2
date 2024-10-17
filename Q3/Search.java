package Q3;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Search {
    public Search(){

    }

    public void ParallelSearch(int toSearch, LinkedList<Integer> list){
        AtomicBoolean foundStart = new AtomicBoolean(false);
        AtomicBoolean foundEnd = new AtomicBoolean(false);
        long[] timeResults = new long[2];

        Thread searchFromStart = new Thread(() -> {
            long startTime = System.nanoTime();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == toSearch) {
                    long endTime = System.nanoTime();
                    timeResults[0] = endTime - startTime;
                    foundStart.set(true);
                    break;
                }
            }
        });


        Thread searchFromEnd = new Thread(() -> {
            long startTime = System.nanoTime();
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) == toSearch) {
                    long endTime = System.nanoTime();
                    timeResults[1] = endTime - startTime;
                    foundEnd.set(true);
                    break;
                }
            }
        });

        searchFromStart.start();
        searchFromEnd.start();

        try {
            searchFromStart.join();
            searchFromEnd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(foundStart.get()) {
            if(timeResults[0] < timeResults[1]){
                System.out.println("Q3.Search from Start was faster: " + timeResults[0] + "ns");
            }else{
                System.out.println("Q3.Search from End was faster: " + timeResults[0] + "ns");
            }
        }else{
            System.out.println("The number "+toSearch+" wasn't found.");
        }
    }
}
