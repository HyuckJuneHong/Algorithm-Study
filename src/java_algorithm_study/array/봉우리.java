package java_algorithm_study.array;

import java.util.Scanner;

/*
     0  1  2  3  4
  0  0  01 02 03 0
  1  10 11 12 13 14
  2  20 21 22 23 24
  3  30 31 32 33 34
  4  0  41 42 43 0

  자기 기준
  좌 [][-1]
  상 [-1][]
  하 [+1][]
  우 [][+1]
 */
public class 봉우리 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int n, int[][] arr){
        int answer=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                boolean flag = true;
                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        봉우리 T = new 봉우리();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
