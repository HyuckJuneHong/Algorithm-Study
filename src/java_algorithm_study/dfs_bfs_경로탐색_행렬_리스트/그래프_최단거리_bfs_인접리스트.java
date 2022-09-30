package java_algorithm_study.dfs_bfs_경로탐색_행렬_리스트;

import java.util.*;

public class 그래프_최단거리_bfs_인접리스트 {
    static int n, m, answer=0;
    static List<List<Integer>> graph;
    static int[] check;
    static int[] dis;

    public void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        check[v] = 1;
        dis[v] = 0;
        queue.offer(v);

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int nv : graph.get(current)){
                if(check[nv] == 0){
                    check[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[current]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        그래프_최단거리_bfs_인접리스트 T = new 그래프_최단거리_bfs_인접리스트();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        m=kb.nextInt();
        graph = new ArrayList<>();
        check = new int[n+1];
        dis = new int[n+1];

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }

        T.bfs(1);
        for(int i=2; i<=n; i++){
            System.out.println(i + ": " + dis[i]);
        }
    }

}
