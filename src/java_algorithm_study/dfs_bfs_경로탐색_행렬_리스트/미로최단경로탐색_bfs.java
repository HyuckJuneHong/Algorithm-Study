package java_algorithm_study.dfs_bfs_경로탐색_행렬_리스트;


import java_algorithm_study.Point;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로최단경로탐색_bfs {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;

    public int bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        board[x][y] = 1;

        while (!queue.isEmpty()){
            Point temp = queue.poll();
            for(int i=0; i<4; i++){
                int nextX = temp.x + dx[i];
                int nextY = temp.y + dy[i];
                if(nextX>=1 && nextX<=7 && nextY>=1 && nextY<=7 && board[nextX][nextY]==0){
                    board[nextX][nextY] = 1;
                    queue.offer(new Point(nextX, nextY));
                    dis[nextX][nextY] = dis[temp.x][temp.y] + 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        미로최단경로탐색_bfs T = new 미로최단경로탐색_bfs();
        Scanner kb = new Scanner(System.in);

        board = new int[8][8];
        dis = new int[8][8];
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                board[i][j] = kb.nextInt();
            }
        }

        board[1][1] = 1;
        T.bfs(1, 1);
        if(dis[7][7] == 0 ) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}
