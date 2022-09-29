package java_algorithm_study.dfs;

import java.util.Scanner;

public class 조합구하기 {
    static int n, m;
    static int[] combination;

    public static void main(String[] args) {
        조합구하기 T = new 조합구하기();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        m=kb.nextInt();
        combination=new int[m];

        T.dfs(0, 1);
    }

    private void dfs(int level, int start) {
        if(level == m){
            for(int x : combination) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=start; i<=n; i++){
                combination[level] = i;
                dfs(level+1, i+1);
            }
        }
    }
}
