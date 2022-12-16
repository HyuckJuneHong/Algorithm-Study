package java_algorithm_study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합수_메모이제이션 {
    static int n, r;
    static int[][] answer = new int[35][35];

    private static int DFS(int n, int r) {
        if(answer[n][r] > 0) return answer[n][r];
        if(n==r || r==0) return answer[n][r] = 1;
        else{
            return answer[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }
    }

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = bufferedReader.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        r = Integer.parseInt(s.split(" ")[1]);

        System.out.println(DFS(n, r));
        bufferedReader.close();
    }
}
