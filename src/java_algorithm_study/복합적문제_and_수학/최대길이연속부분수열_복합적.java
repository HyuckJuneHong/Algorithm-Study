package java_algorithm_study.복합적문제_and_수학;

import java.util.Scanner;

public class 최대길이연속부분수열_복합적 {

    private int solution(int n, int k, int[] a) {
        int answer = 0;
        int lt=0, count=0;

        for(int rt=0; rt<n; rt++){
            if(a[rt] == 0){
                count++;
            }
            while(count > k){
                if(a[lt]==0)
                    count--;
                lt++;
            }

            answer = Math.max(answer, rt-lt+1);
        }

        return answer;
    }

    public static void main(String[] args) {
        최대길이연속부분수열_복합적 T = new 최대길이연속부분수열_복합적();
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
