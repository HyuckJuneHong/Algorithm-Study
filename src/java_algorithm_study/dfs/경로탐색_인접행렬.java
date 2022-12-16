package java_algorithm_study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 경로탐색_인접행렬 {
    static int[] check;
    static int[][] graph;
    static int n, m, answer=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        m = Integer.parseInt(s.split(" ")[1]);

        graph = new int[n+1][n+1];
        check = new int[n+1];

        for(int i=0; i<m; i++){
            s = bufferedReader.readLine();
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            graph[a][b] = 1;        //방향 그래프 생성
        }
        check[1] = 1;               //체크
        DFS(1);
        System.out.println(answer);
    }

    private static void DFS(int v) {
        if(v == n) answer++;
        else{
            for(int i=1; i<=n; i++){
                if(graph[v][i] == 1 && check[i] != 1){
                    check[i] = 1;
                    DFS(i);
                    check[i] = 0;
                }
            }
        }
    }
}
/**
 * test case
 5 9
 1 2
 1 3
 1 4
 2 1
 2 3
 2 5
 3 4
 4 2
 4 5
 output : 6
 */