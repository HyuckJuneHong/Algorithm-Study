package 백준.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex3003 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();

        StringTokenizer stringTokenizer = new StringTokenizer(s);
        int[] num = new int[6];
        int[] answer = new int[]{1, 1, 2, 2, 2, 8};
        int[] result = new int[6];

        for(int i=0; i<6; i++){
           num[i] = Integer.parseInt(stringTokenizer.nextToken());
           result[i] = answer[i] - num[i];
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3] + " " + result[4] + " " + result[5]);
    }
}
