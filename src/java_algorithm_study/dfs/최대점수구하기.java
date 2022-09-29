package java_algorithm_study.dfs;

import java.util.Scanner;

public class 최대점수구하기 {

    static int n, t, answer = Integer.MIN_VALUE;

    private void dfs(int level, int sum, int time, int[] pPoint, int[] pTime) {
        if(time > t) return;
        if(level == n){
            answer = Math.max(answer, sum);
        }else{
            dfs(level+1, sum+pPoint[level], time + pTime[level], pPoint, pTime);
            dfs(level+1, sum, time, pPoint, pTime);
        }
    }

    public static void main(String[] args) {
        최대점수구하기 T = new 최대점수구하기();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        t=kb.nextInt();
        int[] pPoint=new int[n];
        int[] pTime=new int[n];

        for(int i=0; i<n; i++){
            pPoint[i]=kb.nextInt();
            pTime[i]=kb.nextInt();
        }
        T.dfs(0, 0, 0, pPoint, pTime);
        System.out.println(answer);

    }
}
