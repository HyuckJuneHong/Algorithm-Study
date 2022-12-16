package java_algorithm_study.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최대점수구하기 {
    static int n, t;
    static int[] time;
    static int[] score;
    static int max = Integer.MIN_VALUE;

    private static void DFS(int v, int sumS, int sumT, int[] score, int[] time) {
        if(t < sumT){
            return;
        }else{
            if(v==n){
                max = Math.max(max, sumS);
            }else{
                DFS(v+1, sumS+score[v], sumT+time[v], score, time);
                DFS(v+1, sumS, sumT, score, time);
            }
        }
    }

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String s = bufferedReader.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        t = Integer.parseInt(s.split(" ")[1]);

        time = new int[n];
        score = new int[n];

        for(int i=0; i<n; i++){
            s = bufferedReader.readLine();
            score[i] = Integer.parseInt(s.split(" ")[0]);
            time[i] = Integer.parseInt(s.split(" ")[1]);
        }

        DFS(0, 0, 0, score, time);

        stringBuilder.append(max);
        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}
