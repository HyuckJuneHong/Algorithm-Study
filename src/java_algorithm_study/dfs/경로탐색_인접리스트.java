package java_algorithm_study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 경로탐색_인접리스트 {
    static int[] check;
    static ArrayList<ArrayList<Integer>> graph;
    static int n, m, answer=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        m = Integer.parseInt(s.split(" ")[1]);

        check = new int[n+1];
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            s = bufferedReader.readLine();
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            graph.get(a).add(b);    //그래프 생성
        }
        check[1] = 1;               //체크
        DFS(1);
        System.out.println(answer);
    }

    private static void DFS(int v) {
        if(v == n) answer++;
        else{
            for(int nv : graph.get(v)){
                if(check[nv] != 1){
                    check[nv] = 1;
                    DFS(nv);
                    check[nv] = 0;
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
