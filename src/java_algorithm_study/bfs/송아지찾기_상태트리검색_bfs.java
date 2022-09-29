package java_algorithm_study.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기_상태트리검색_bfs {
    int[] dis = {1, -1, 5};
    int[] check = new int[10001];
    Queue<Integer> queue = new LinkedList<>();

    public int bfs(int n, int m) {
        check[n] = 1;

        queue.offer(n);
        int level = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int x = queue.poll();

                if (x == m) return level;

                for (int j = 0; j < dis.length; j++) {
                    int nx = x + dis[j];
                    if (nx >= 1 && nx <= 10000 && check[nx] == 0) {
                        check[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        송아지찾기_상태트리검색_bfs T = new 송아지찾기_상태트리검색_bfs();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();

        System.out.println(T.bfs(n, m));
    }
}
