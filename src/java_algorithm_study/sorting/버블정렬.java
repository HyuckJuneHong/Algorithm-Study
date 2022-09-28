package java_algorithm_study.sorting;

import java.util.Scanner;

public class 버블정렬 {
    private int[] solution(int n, int[] arr) {
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        버블정렬 T = new 버블정렬();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        for(int i : T.solution(n, arr)){
            System.out.print(i+ " ");
        }
    }
}
