package java_algorithm_study.array;

import java.util.Scanner;

public class 소수_에라토스테네스체 {

    public int solution(int n) {
        int answer=0;

        int[] c = new int[n+1];
        for(int i=2; i<=n; i++){
            if(c[i]==0){
                answer++;
                for(int j=i; j<=n; j += i){
                    c[j]=1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        소수_에라토스테네스체 T = new 소수_에라토스테네스체();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();

        System.out.print(T.solution(n));
    }
}
