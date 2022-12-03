import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/*
[0][0] [0][1] [0][2] [0][3] [0][4]
[1][0] [1][1] [1][2] [1][3] [1][4]
[2][0] [2][1] [2][2] [2][3] [2][4]
[3][0] [3][1] [3][2] [3][3] [3][4]
[4][0] [4][1] [4][2] [4][3] [4][4]

        [i-1][j]
[i][j-1]  [i][j][i][j+1]
        [i+1][j]
 */
public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] s = new String[n];

        int[][] arr = new int[n+2][n+2];
        int max = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++){
            s[i-1] = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(s[i-1], " ");
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int cnt = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                int num = arr[i][j];
                if(num > arr[i-1][j] && num > arr[i+1][j]
                    && num > arr[i][j-1] && num > arr[i][j+1]){
                    cnt++;
                }
            }
        }
        stringBuilder.append(cnt);
        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}