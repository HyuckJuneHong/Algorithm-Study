package java_algorithm_study.greedy_union_find_크루스칼;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Edge implements Comparable<Edge>{

    public int v1;
    public int v2;
    public int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class 원더랜드_크루스칼_최소스패닝트리_Union {
    static int[] unionFind;
    static int answer = 0;

    //파라미터 학생의 집합 번호를 반환
    public static int find(int v){
        if(v == unionFind[v]) return v;
        else return unionFind[v] = find(unionFind[v]);
    }

    //한 집합으로 만드는 메소드
    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unionFind[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        unionFind = new int[n+1];

        List<Edge> list = new ArrayList<>();
        for(int i=1; i<=n; i++) unionFind[i] = i;

        for(int i=0; i<m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            list.add(new Edge(a, b, c));
        }

        Collections.sort(list);
        for(Edge edge : list){
            int fv1 = find(edge.v1);
            int fv2 = find(edge.v2);

            if(fv1 != fv2){
                answer += edge.cost;
                union(edge.v1, edge.v2);
            }
        }

        System.out.println(answer);
    }
}
