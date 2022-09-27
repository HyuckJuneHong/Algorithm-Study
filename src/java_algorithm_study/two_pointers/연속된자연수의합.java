package java_algorithm_study.two_pointers;

import java.util.Scanner;

public class 연속된자연수의합 {

    public int solution(int n){
        int answer=0;
        int lt=0, size = n/2+1;
        int sum=0;

        int[] a = new int[size];
        for(int i=1; i<=size; i++){
            a[i-1] = i;
        }

        for(int rt=0; rt<size; rt++){
            sum += a[rt];
            if(sum==n){
                answer++;
            }
            while(sum >= n){
                sum -= a[lt];
                lt++;
                if(sum == n){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        연속된자연수의합 T = new 연속된자연수의합();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();

        System.out.println(T.solution(n));
    }
}
