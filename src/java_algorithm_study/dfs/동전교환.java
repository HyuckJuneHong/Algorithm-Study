package java_algorithm_study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 동전교환 {
    static int n, m;
    static Integer[] arr;
    static int min = Integer.MAX_VALUE;

    private static void DFS(int v, int sum, Integer[] arr) {
        if(sum > m) return;
        if(v >= min) return;

        if(sum==m){
            min = Math.min(min, v);
        }else{
            for(int i=0; i<n; i++){
                DFS(v+1, sum+arr[i], arr);
            }
        }
    }

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        String s = bufferedReader.readLine();
        m = Integer.parseInt(bufferedReader.readLine());

        arr = new Integer[n];
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        DFS(0, 0, arr);

        System.out.println(min + "");
        bufferedReader.close();
    }
}
