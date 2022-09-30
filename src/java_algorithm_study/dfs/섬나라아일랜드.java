package java_algorithm_study.dfs;

import java.util.Scanner;

public class 섬나라아일랜드 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n, answer = 0;

    public void dfs(int x, int y, int[][] board){
        for(int i=0; i<8; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX >= 0 && nextX < n && nextY>=0 && nextY<n && board[nextX][nextY]==1){
                board[nextX][nextY] = 0;
                dfs(nextX, nextY, board);
            }
        }
    }
    public void solution(int[][] board){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (board[i][j] == 1){
                    answer++;
                    board[i][j] = 0;
                    dfs(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        섬나라아일랜드 T = new 섬나라아일랜드();
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        T.solution(arr);
        System.out.println(answer);
    }
}
