package java_algorithm_study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int[][] board = new int[7][7];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = 0;

    private static void DFS(int x, int y) {
        if(x==6 && y==6){
            answer++;
            return;
        }else{
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx >= 0 && nx <= 6 && ny >= 0 && ny <=6 && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] s = new String[7];
        for(int i=0; i<7; i++){
            s[i] = bufferedReader.readLine();
        }

        for(int i=0; i<7; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(s[i]);
            for(int j=0; j<7; j++){
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        board[0][0] = 1;
        DFS(0, 0);

        System.out.println(answer);
        bufferedReader.close();
    }


}
