package Q7;

public class MergeSort {
    public MergeSort(){

    }

    static class Sorter implements Runnable {
        
        private int[] Array;
        private int left;
        private int right;

        public Sorter(int[] Array, int left, int right) {
            this.Array = Array;
            this.left = left;
            this.right = right;
        }

        @Override 
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
            
            if (left >= right) {
                return;
            }

            int middle = (left + right) / 2;
            
            Thread threadLeft = new Thread(new Sorter(Array, left, middle));
            Thread threadRight = new Thread(new Sorter(Array, middle + 1, right));

            threadLeft.start();
            threadRight.start();
            
            try {
                threadLeft.join();
                threadRight.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            merge(Array, left, middle, right);
            
        }

        private void merge(int[] array, int left, int middle, int right) {
            int n1 = middle - left + 1;
            int n2 = right - middle;

            int[] L = new int[n1];
            int[] R = new int[n2];

            for(int i = 0; i < n1; i++){
                L[i] = array[left + i];
            }

            for(int j = 0; j < n2; j++){
                R[j] = array[middle + 1 + j];
            }

            int i = 0, j = 0;
            int k = left;

            while(i < n1 && j < n2){
                if(L[i] <= R[j]){
                    array[k] = L[i];
                    i++;
                }else{
                    array[k] = R[j];
                    j++;
                }
                k++;
            }

            while(i < n1){
                array[k] = L[i];
                i++;
                k++;
            }

            while(j < n2){
                array[k] = R[j];
                j++;
                k++;
            }
        }
    }

    public void ParallelMergeSort(int[] Array){
        Thread thread = new Thread(new Sorter(Array, 0, Array.length - 1));
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
