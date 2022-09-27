package java_algorithm_study.sliding_window;

import java.util.Scanner;

public class 최대매출 {
    public int solution(int n, int k, int[] a){
        int answer=0;
        int sum=0;

        for(int i=0; i<k; i++){
            sum += a[i];
        }
        answer=sum;

        for(int i=k; i<n; i++){
            sum += (a[i]-a[i-k]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        최대매출 T = new 최대매출();
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
