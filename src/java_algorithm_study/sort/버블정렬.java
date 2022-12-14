package java_algorithm_study.sort;

/**
 *
 */
public class 버블정렬 {
    static int size;                        //Array Size
    static int[] arr = new int[size];       //Array
    public static void main(String[] args) {
        for(int i=0; i<size; i++){
            for(int j=0; j<size-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
