package java_algorithm_study.bfs;

import java_algorithm_study.Point;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;
    static int n, m;
    static Queue<Point> queue = new LinkedList<>();

    public void bfs(){
        while (!queue.isEmpty()){
            Point temp = queue.poll();
            for(int i=0; i<4; i++){
                int nextX = temp.x + dx[i];
                int nextY = temp.y + dy[i];
                if(nextX>=0 && nextX<n && nextY>=0 && nextY<m && board[nextX][nextY]==0){
                    board[nextX][nextY] = 1;
                    queue.offer(new Point(nextX, nextY));
                    dis[nextX][nextY] = dis[temp.x][temp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        토마토 T = new 토마토();
        Scanner kb = new Scanner(System.in);
        m = kb.nextInt();
        n = kb.nextInt();

        board = new int[n][m];
        dis = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] = kb.nextInt();
                if(board[i][j] == 1) queue.offer(new Point(i, j));
            }
        }

        T.bfs();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 0) flag = false;
            }
        }

        if(flag){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }
        else{
            System.out.println(-1);
        }
    }
}
