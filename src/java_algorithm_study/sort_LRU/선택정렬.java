package java_algorithm_study.sort_LRU;

/**
 *
 */
public class 선택정렬 {
    static int size;                        //Array Size
    static int[] arr = new int[size];       //Array
    public static void main(String[] args) {
        for(int i=0; i<size-1; i++){
            int idx = i;
            for(int j=i+1; j<size; j++){
                if(arr[j]<arr[idx])
                    idx = j;
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }
}
