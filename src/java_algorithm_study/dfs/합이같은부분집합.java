package java_algorithm_study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합이같은부분집합 {
    static int n;
    static int[] arr;
    static int total=0;
    static boolean flag = false;
    static String answer = "NO";

    private static void DFS(int v, int sum, int[] arr) {
        if(flag) return;
        else{
            if(v==n){
                if(total-sum == sum){
                    answer = "YES";
                    flag = true;
                }
            }else{
                DFS(v+1, sum+arr[v], arr);
                DFS(v+1, sum, arr);
            }
        }
    }

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        String s = bufferedReader.readLine();
        arr = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(s);
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            total += arr[i];
        }

        DFS(0, 0, arr);
        stringBuilder.append(answer);
        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}
