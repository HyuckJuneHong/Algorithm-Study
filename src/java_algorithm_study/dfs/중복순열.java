package java_algorithm_study.dfs;

import java.util.Scanner;

public class 중복순열 {
    static int[] pm;
    static int n, m;

    private void dfs(int level) {

        if(level == m){
            for(int x : pm){
                System.out.print(x + " ");
            }
            System.out.println();
        }else{
            for(int i=1; i<=n; i++){
                pm[level] = i;
                dfs(level+1);
            }
        }
    }

    public static void main(String[] args) {
        중복순열 T = new 중복순열();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        m=kb.nextInt();
        pm = new int[m];

        T.dfs(0);
    }
}
