package java_algorithm_study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중복순열 {
    static int n, m;
    static int[] arr;

    private static void DFS(int v) {
        if(v==m){
            System.out.println(arr[0] + " " + arr[1]);
        }else{
            for(int i=1; i<=n; i++){
                arr[v] = i;
                DFS(v+1);
            }
        }
    }

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String s = bufferedReader.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        m = Integer.parseInt(s.split(" ")[1]);
        arr = new int[m];

        DFS(0);

        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}
