package java_algorithm_study.dfs_조합수_메모이제이션;

import java.util.Scanner;

public class 조합수_수열추측하기 {
    static int n, finalNum;
    static int[] b, p, check;

    boolean flag = false;
    int[][] dy = new int[35][35];

    public static void main(String[] args) {
        조합수_수열추측하기 T = new 조합수_수열추측하기();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        finalNum=kb.nextInt();

        b=new int[n];
        p=new int[n];
        check=new int[n+1];

        for(int i=0; i<n; i++){
            b[i] = T.combination(n-1, i);
        }
        T.dfs(0, 0);
    }

    private void dfs(int level, int sum) {
        if(flag) return;
        if(level==n){
            if(sum == finalNum){
                for(int x : p) System.out.print(x + " ");
                flag = true;
            }
        }else{
            for(int i=1; i<=n; i++){
                if(check[i] == 0){
                    check[i] = 1;
                    p[level] = i;
                    dfs(level+1, sum + (p[level]*b[level]));
                    check[i] = 0;
                }
            }
        }
    }

    private int combination(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }
}
