package java_algorithm_study.경로탐색_dfs_bfs_ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 인접행렬보다 효율적
 */
public class 경로탐색_dfs_인접리스트_ArrayList {

    static int n, m, answer=0;
    static List<List<Integer>> graph;
    static int[] check;

    public void dfs(int v){
        if(v == n) answer++;
        else{
            for(int nv : graph.get(v)){
                if(check[nv] == 0){
                    check[nv] = 1;
                    dfs(nv);
                    check[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        경로탐색_dfs_인접리스트_ArrayList T = new 경로탐색_dfs_인접리스트_ArrayList();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        m=kb.nextInt();
        graph = new ArrayList<>();
        check = new int[n+1];

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }

        check[1] = 1;
        T.dfs(1);
        System.out.println(answer);
    }

}
