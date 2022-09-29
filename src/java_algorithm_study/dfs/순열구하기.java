package java_algorithm_study.dfs;

import java.util.Scanner;

public class 순열구하기 {
    static int n, m;
    static int[] pm, check, arr;

    public void dfs(int level){
        if(level == m){
            for(int x : pm){
                System.out.print(x + " ");
            }
            System.out.println();
        }else{
            for(int i=0; i<n; i++){
                if(check[i] == 0){
                    check[i] = 1;
                    pm[level] = arr[i];
                    dfs(level+1);
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        순열구하기 T = new 순열구하기();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        m=kb.nextInt();
        arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        check = new int[n];
        pm = new int[m];
        T.dfs(0);
    }
}
