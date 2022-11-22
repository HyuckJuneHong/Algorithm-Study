package 백준.단계별로풀기;

import java.io.*;

public class BufferedReader_BufferedWriter {

    public void solution(String[] str, int n) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)); //sout
        int sum;
        String answer = "";

        for(int i=0; i<n; i++){
            int n1 = Integer.parseInt(str[i].split(" ")[0]);
            int n2 = Integer.parseInt(str[i].split(" ")[1]);
            bufferedWriter.write(n1+n2+"\n"); //저장
        }
        bufferedWriter.flush(); //남이있는 Data 모두 출력
        bufferedWriter.close(); //Stream close
    }
    public static void main(String[] args) throws IOException {
        BufferedReader_BufferedWriter T = new BufferedReader_BufferedWriter();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); //=Scanner
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] str = new String[n];

        for(int i=0; i<n; i++){
            str[i] = bufferedReader.readLine();
        }
        T.solution(str, n);
    }
}
