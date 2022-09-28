package java_algorithm_study.sorting;


import java.util.Scanner;

public class 선택정렬 {
    private int[] solution(int n, int[] arr) {
        for(int i=0; i<n-1; i++){
            int index = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[index]){
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        선택정렬 T = new 선택정렬();
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
