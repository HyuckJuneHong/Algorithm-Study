package java_algorithm_study.dfs;

public class 부분집합구하기 {
    static int n;
    static int[] check;

    public static void main(String[] args) {
        n=3;
        check = new int[n+1];
        DFS(1);
    }

    private static void DFS(int L) {
        if(L == n+1){
            String temp = "";
            for(int i=1; i<=n; i++){
                if(check[i]==1) temp += (i+ " ");
            }
            if(temp.length() > 0) System.out.println(temp);
        }else{
            check[L] = 1;
            DFS(L+1);
            check[L] = 0;
            DFS(L+1);
        }
    }
}
