package java_algorithm_study.sort;

public class 삽입정렬  {
    static int size;                        //Array Size
    static int[] arr = new int[size];       //Array
    public static void main(String[] args) {
        for(int i=1; i<size; i++){
            int index=i-1, temp = arr[i];
            while(index>=0){
                if(arr[index] > temp){
                    arr[index+1] = arr[index];
                }else{
                    break;
                }
                index--;
            }
            arr[index+1] = temp;
        }
    }
}
