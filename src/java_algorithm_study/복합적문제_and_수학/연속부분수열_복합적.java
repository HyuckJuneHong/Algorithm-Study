package java_algorithm_study.복합적문제_and_수학;

import java.util.Scanner;

public class 연속부분수열_복합적 {

    public int solution(int n, int k, int[] a){
        int answer=0;
        int lt = 0;
        int sum = 0;

        for(int rt=0; rt<n; rt++){
            sum += a[rt];
            if(sum == k) {
                answer++;
            }
            while(sum >= k){
                sum -= a[lt++];
                if(sum==k){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        연속부분수열_복합적 T = new 연속부분수열_복합적();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();

        int[] a=new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }
        System.out.println(T.solution(n, k, a));
    }
}
