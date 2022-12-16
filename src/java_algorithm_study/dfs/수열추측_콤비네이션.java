package java_algorithm_study.dfs;

public class 수열추측_콤비네이션 {
    static int[] b, p, check;
    static int n, f;
    static boolean flag = false;
    static int[][] dy = new int[35][35];

    private static int combi(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r];
        if(n==r || r==0) return dy[n][r] = 1;
        else return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

    private static void dfs(int L, int sum) {
        if(flag) return;
        if(L==n){
            if(sum == f){
                for(int x : p)
                    System.out.print(x + " ");
                flag = true;
            }
        }else{
            for(int i=1; i<=n; i++){
                if(check[i] == 0){
                    check[i] = 1;
                    p[L] = i;
                    dfs(L+1, sum + (p[L] * b[L]));
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        n = 4;
        f = 16;
        b = new int[n];
        p = new int[n];
        check = new int[n+1];

        for(int i=0; i<n; i++){
            b[i] = combi(n-1, i);
        }

        dfs(0, 0);
    }
}
