package java_algorithm_study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬나라아일랜드 {

    static int[][] board;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer = 0, n;

    private static void DFS(int x, int y) {
        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1){
                board[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        board = new int[n][n];
        String[] s = new String[n];
        for(int i=0; i<n; i++){
            s[i] = bufferedReader.readLine();
        }

        for(int i=0; i<n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(s[i]);
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    board[i][j] = 0;
                    answer++;
                    DFS(i, j);
                }
            }
        }

        System.out.println(answer);
        bufferedReader.close();
    }
}
