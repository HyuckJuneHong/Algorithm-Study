package java_algorithm_study.dfs;

import java.util.Scanner;

public class 바둑이승차 {
    static int answer = Integer.MIN_VALUE, x, n;
    boolean flag = false;

    private void dfs(int level, int sum, int[] arr) {
        if(sum > x) return;
        if(level == n){
            answer = Math.max(answer, sum);
        }else{
            dfs(level+1, sum+arr[level], arr);
            dfs(level+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        바둑이승차 T = new 바둑이승차();
        Scanner kb = new Scanner(System.in);

        x=kb.nextInt();
        n=kb.nextInt();
        int[] arr=new int[n];

        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        T.dfs(0, 0, arr);
        System.out.println(answer);

    }

}
