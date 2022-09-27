package java_algorithm_study.array;

import java.util.ArrayList;
import java.util.Scanner;

public class 보이는학생 {
    public int solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        int max = arr[0];
        answer.add(arr[0]);

        for(int i=1; i<n; i++){
            if(max < arr[i]){
                max = arr[i];
                answer.add(arr[i]);
            }
        }

        return answer.size();
    }

    public static void main(String[] args) {
        보이는학생 T = new 보이는학생();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
