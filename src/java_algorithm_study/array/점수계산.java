package java_algorithm_study.array;

import java.util.Scanner;

public class 점수계산 {
    public int solution(int n, int[] arr){
        int answer = 0;
        int count = 0;

        for(int i=0; i<n; i++){
            if(arr[i] == 1){
                count++;
                answer += count;
            }else{
                count=0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        점수계산 T = new 점수계산();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
