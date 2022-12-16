package java_algorithm_study.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 그래프최단거리 {
    static int[] check, dis;
    static ArrayList<ArrayList<Integer>> graph;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        m = Integer.parseInt(s.split(" ")[1]);

        check = new int[n+1];
        dis = new int[n+1];
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
        BFS(1);

        for(int i=2; i<=n; i++){
            System.out.println(i + ": " + dis[i]);
        }
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();

        check[v] = 1;
        dis[v] = 0;
        queue.offer(v);

        while(!queue.isEmpty()){
            int cv = queue.poll();

            for(int nv : graph.get(cv)){
                if(check[nv] == 0){
                    check[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }
}
/**
 * test case
input
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
output
 2: 3
 3: 1
 4: 1
 5: 2
 6: 2
 */