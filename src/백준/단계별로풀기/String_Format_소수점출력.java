package 백준.단계별로풀기;

import java.io.*;
import java.util.*;

public class String_Format_소수점출력 {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer[] stringTokenizer;

    public void solution(int n, String[] s) throws IOException {
        stringTokenizer = new StringTokenizer[n];
        for(int i=0; i<n; i++){
            stringTokenizer[i] = new StringTokenizer(s[i], " ");
        }


        for(int i=0; i<stringTokenizer.length; i++){
            int size = Integer.parseInt(stringTokenizer[i].nextToken());
            int[] score = new int[size];

            int sum = 0;
            double avg = 0;

            for(int j=0; j<size; j++){
                score[j] = Integer.parseInt(stringTokenizer[i].nextToken());
                sum += score[j];
            }
            avg = (double) sum/(double) size;

            int count = 0;
            for(int z=0; z<size; z++){
                if(score[z] > avg){
                    count++;
                }
            }
            double answer = (double)count/(double) size * 100.0;

            bufferedWriter.write(String.format("%.3f%%\n", answer));
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
    public static void main(String[] args) throws IOException {
        String_Format_소수점출력 T = new String_Format_소수점출력();
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] s = new String[n];

        for(int i=0; i<n; i++){
            s[i] = bufferedReader.readLine();
        }

        T.solution(n, s);
    }
}
