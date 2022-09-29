package java_algorithm_study.경로탐색_dfs_bfs_ArrayList;

import java.util.Scanner;

/**
 * 매우 비효율트
 */
public class 경로탐색_인접행렬_dfs {

    static int n, m, answer=0;
    static int[][] graph;
    static int[] check;

    public void dfs(int v){
        if(v==n) answer++;
        else{
            for(int i=1; i<=n; i++){
                if(graph[v][i]==1 && check[i] == 0){
                    check[i] = 1; //방문
                    dfs(i);
                    check[i] = 0; //백
                }
            }
        }
    }

    public static void main(String[] args) {
        경로탐색_인접행렬_dfs T = new 경로탐색_인접행렬_dfs();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        m=kb.nextInt();
        graph = new int[n+1][n+1];
        check = new int[n+1];

        for(int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;    //방향그래프이기 떄문에 하나만.
        }

        check[1] = 1;
        T.dfs(1);
        System.out.println(answer);
    }
}
