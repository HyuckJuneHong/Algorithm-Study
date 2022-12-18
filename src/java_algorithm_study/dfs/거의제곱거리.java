package java_algorithm_study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시간초과남 원순열 중복 제거 해야할듯..
 */
public class 거의제곱거리 {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();
    static long[][] check, temp;
    static long[][] arr;
    static int n, m;
    static long[] max;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bufferedReader.readLine());
        max = new long[n];
        arr = new long[n][];
        check = new long[n][];
        temp = new long[n][];

        Arrays.fill(max, Integer.MIN_VALUE);

        for(int i=0; i<n; i++){
            m = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            arr[i] = new long[m];
            check[i] = new long[m];
            temp[i] = new long[m];
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            DFS(i, 0);
        }

        for(int i=0; i<n; i++){
            stringBuilder.append("#" + (i+1) + " " + max[i] + "\n");
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    private static void DFS(int L, int idx) {
        if(max[L] == temp[L].length){
            return;
        }
        if (idx == arr[L].length) {
            count(L, temp);
            return;
        }

        for (int i=0; i<arr[L].length; i++) {
            if (check[L][i] == 0) {
                check[L][i] = 1;
                temp[L][idx] = arr[L][i];
                DFS(L, idx+1);
                check[L][i] = 0;
            }
        }
    }

    private static void count(int L, long[][] temp){
        int count = 0;
        for(int i=0; i<temp[L].length-1; i++){
            if(max[L] >= (temp[L].length - i + count)){
                return;
            }
            Double d = Math.sqrt(temp[L][i]+temp[L][i+1]);
            if(d == d.intValue()){
                count++;
            }
        }

        Double d = Math.sqrt(temp[L][temp[L].length-1] + temp[L][0]);
        if(d == d.intValue()){
            count++;
        }

        max[L] = Math.max(max[L], count);
    }
}

