package Q3;

import java.util.LinkedList;

public class Main {
    
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        Search search = new Search();
        search.ParallelSearch(1001, list);
    }
}
