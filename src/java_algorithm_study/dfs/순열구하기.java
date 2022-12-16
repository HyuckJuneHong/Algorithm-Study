package java_algorithm_study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열구하기 {
    static int n, m;
    static int[] arr, check;
    static int[] answer;
    static int min = Integer.MAX_VALUE;

    private static void DFS(int v) {
        if(v == m){
            for(int i=0; i<m; i++){
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        }else{
            for(int i=0; i<n; i++){
                if(check[i] == 0){
                    check[i] = 1;
                    answer[v] = arr[i];
                    DFS(v+1);
                    check[i] = 0;
                }
            }
        }
    }

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String s = bufferedReader.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        m = Integer.parseInt(s.split(" ")[1]);

        answer = new int[m];
        check = new int[n];
        arr = new int[n];

        s = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        DFS(0);

        stringBuilder.append(min);
        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}
