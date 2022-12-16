package java_algorithm_study.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 송아지찾기 {
    static int answer = 0;
    static int[] dis = {1, -1, 5};
    static int[] check;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(BFS(5, 14));
    }

    private static int BFS(int n, int k) {
        check = new int[10001];
        check[n] = 1;
        queue.offer(n);

        int L = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0; i<len; i++){
                int q = queue.poll();
                if(q==k)
                    return L;
                for(int j=0; j<3; j++){
                    int nx = q + dis[j];
                    if(nx >= 1 && nx <= 10000 && check[nx] == 0){
                        check[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }

        return 0;
    }
}
