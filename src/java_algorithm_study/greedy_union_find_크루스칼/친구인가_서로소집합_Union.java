package java_algorithm_study.greedy_union_find_크루스칼;

import java.util.Scanner;

public class 친구인가_서로소집합_Union {
    static int[] unionFind; // 집합

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

        //초기화
        for(int i=1; i<=n; i++){
            unionFind[i] = i;
        }

        for(int i=1; i<=m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            union(a, b); //친구 관계 : 한 집합으로 만듬.
        }

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int fa = find(a);
        int fb = find(b);

        if(fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
