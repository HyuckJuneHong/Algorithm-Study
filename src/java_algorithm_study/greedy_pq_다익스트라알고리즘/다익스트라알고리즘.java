package java_algorithm_study.greedy_pq_다익스트라알고리즘;

import java.util.*;

class Edge implements Comparable<Edge>{

    public int vex;
    public int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

/**
 * 전제 조건
 * -가중치가 음수이면 안된다.
 */
public class 다익스트라알고리즘 {
    static int n, m;
    static List<List<Edge>> graph;
    static int[] dis;

    public void solution(int v){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dis[v] = 0;

        while(!pq.isEmpty()){
            Edge temp = pq.poll();
            int nowVex = temp.vex;
            int nowCost = temp.cost;

            if(nowCost > dis[nowVex]) continue;

            for(Edge edge : graph.get(nowVex)){
                if(dis[edge.vex] > nowCost + edge.cost){
                    dis[edge.vex] = nowCost + edge.cost;
                    pq.offer(new Edge(edge.vex, nowCost+edge.cost));
                }
            }

        }
    }

    public static void main(String[] args) {
        다익스트라알고리즘 T = new 다익스트라알고리즘();
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<>();

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        T.solution(1);
        for(int i=2; i<=n; i++){
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i + ": " + dis[i]);
            else System.out.println(i + ": impossible");
        }
    }
}
