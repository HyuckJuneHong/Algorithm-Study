import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();
    static StringTokenizer stringTokenizer;
    static int[][] arr;
    static int t, n, m, k;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(bufferedReader.readLine());
        String s = bufferedReader.readLine();
        stringTokenizer = new StringTokenizer(s);

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[n][m];

        for(int i=0; i<n; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        System.out.println(stringBuilder);
    }

    public static void DFS(){

    }

    public static void combi(){

    }
}

