package java_algorithm_study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바둑이승차 {
    static int n, k;
    static int[] arr;
    static int max = Integer.MIN_VALUE;

    private static void DFS(int v, int sum, int[] arr) {
        if(n < sum){
            return;
        }else{
            if(v==k){
                max = Math.max(max, sum);
            }else{
                DFS(v+1, sum+arr[v], arr);
                DFS(v+1, sum, arr);
            }
        }
    }

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String s = bufferedReader.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        k = Integer.parseInt(s.split(" ")[1]);
        arr = new int[k];

        for(int i=0; i<k; i++){
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        DFS(0, 0, arr);

        stringBuilder.append(max);
        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}
