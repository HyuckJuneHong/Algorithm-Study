package java_algorithm_study.dfs;

import java.util.Scanner;

/**
 * nCr = n-1Cr-1 + n-1Cr
 * Ex) 5C3 = 4C2 + 4C3
 */
public class 조합수구하기_메모이제이션 {
    int[][] answer = new int[50][50];

    public static void main(String[] args) {
        조합수구하기_메모이제이션 T = new 조합수구하기_메모이제이션();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int r=kb.nextInt();

        System.out.println(T.dfs(n, r));
    }

    private int dfs(int n, int r) {
        if(answer[n][r] > 0) return answer[n][r];
        if(n==r || r==0) return 1;
        else return answer[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
    }
}

class 조합수구하기 {

    public static void main(String[] args) {
        조합수구하기 T = new 조합수구하기();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int r=kb.nextInt();

        System.out.println(T.dfs(n, r));
    }

    private int dfs(int n, int r) {
        if(n==r || r==0) return 1;
        else return dfs(n-1, r-1) + dfs(n-1, r);
    }
}



