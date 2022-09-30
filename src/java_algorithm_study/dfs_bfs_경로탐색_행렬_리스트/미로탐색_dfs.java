package java_algorithm_study.dfs_bfs_경로탐색_행렬_리스트;

import java.util.Scanner;

public class 미로탐색_dfs {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int answer=0;

    public void dfs(int x, int y){
        if(x==7 && y==7){
            answer++;
        }else{
            for(int i=0; i<4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX>=1 && nextX<=7 && nextY>=1 && nextY<=7 && board[nextX][nextY]==0){
                    board[nextX][nextY] = 1;
                    dfs(nextX, nextY);
                    board[nextX][nextY] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        미로탐색_dfs T = new 미로탐색_dfs();
        Scanner kb = new Scanner(System.in);

        board = new int[8][8];
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                board[i][j] = kb.nextInt();
            }
        }

        board[1][1] = 1;
        T.dfs(1, 1);
        System.out.println(answer);
    }
}
