package java_algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * graph에서 최단 거리 또는 최소 거리
 *
 * (크루스칼은 최소 비용 트리)
 *
 */
public class 다익스트라알고리즘 {
    static int n, m;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static int[] dis;

    private static void solution(int v) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue();
        priorityQueue.offer(new Edge(v, 0));
        dis[v] = 0;

        while(!priorityQueue.isEmpty()){
            Edge temp = priorityQueue.poll();
            int now = temp.vex;
            int nowCost = temp.cost;

            if(nowCost > dis[now]) continue;
            for(Edge edge : graph.get(now)){
                if(dis[edge.vex] > nowCost + edge.cost){
                    dis[edge.vex] = nowCost + edge.cost;
                    priorityQueue.offer(new Edge(edge.vex, nowCost+edge.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        m = Integer.parseInt(s.split(" ")[1]);

        for(int i=0; i<=n; i++){
           graph = new ArrayList<>();
        }

        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i=0; i<m; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(a).add(new Edge(b, c));
        }

        solution(1);

        for(int i=2; i<=n; i++){
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }
}
