package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer stringTokenizer;

    public void solution(int t) throws IOException {

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        int t = Integer.parseInt(bufferedReader.readLine());

        T.solution(t);
    }
}
