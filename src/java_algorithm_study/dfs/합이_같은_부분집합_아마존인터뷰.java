package java_algorithm_study.dfs;

import java.util.Scanner;

public class 합이_같은_부분집합_아마존인터뷰 {
    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;

    public void dfs(int level, int sum, int[] arr){
        if(flag) return;
        if(sum>total/2) return;

        if(level == n){
            if(total == sum*2) {
                answer = "YES";
                flag = true;
            }
        }else{
            dfs(level+1, sum+arr[level], arr);
            dfs(level+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        합이_같은_부분집합_아마존인터뷰 T = new 합이_같은_부분집합_아마존인터뷰();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
            total += arr[i];
        }
        T.dfs(0, 0, arr);
        System.out.println(answer);

    }
}
