package Q8;

public class MergeSort {
    public MergeSort(){

    }

    public void mergeSort(int[] array, int left, int right){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
        
        if(left < right){
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    public void merge(int[] array, int left, int middle, int right){
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
