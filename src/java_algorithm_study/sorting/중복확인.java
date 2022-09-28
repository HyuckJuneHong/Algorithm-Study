package java_algorithm_study.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class 중복확인 {

    public static void main(String[] args) {
        중복확인 T = new 중복확인();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, arr));
    }

    private String solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);

        for(int i=0; i<n-1; i++){
            if(arr[i] == arr[i+1])
                return "D";
        }

        return answer;
    }
}
