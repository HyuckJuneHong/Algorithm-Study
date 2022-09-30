package java_algorithm_study.greedy_priority_queue_프림;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

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
public class 원더랜드_최소스패닝트리_프림_Pq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<Edge>> list = new ArrayList<>();

        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        int[] check = new int[n+1];
        for(int i=0; i<m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            //무방향
            list.get(a).add(new Edge(b, c));
            list.get(b).add(new Edge(a, c));
        }

        int answer=0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        while(!pq.isEmpty()){
            Edge temp = pq.poll();
            int endVex = temp.vex;

            if(check[endVex]==0){
                check[endVex] = 1;
                answer += temp.cost;

                for(Edge edge : list.get(endVex)){
                    if(check[edge.vex]==0) //왔던 길 다시 돌아가지 않기 위해,
                        pq.offer(new Edge(edge.vex, edge.cost));
                }
            }
        }

        System.out.println(answer);
    }
}
