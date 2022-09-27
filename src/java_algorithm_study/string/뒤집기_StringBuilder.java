package java_algorithm_study.string;

import java.util.ArrayList;
import java.util.Scanner;

public class 뒤집기_StringBuilder {
    public ArrayList<String> solution2(int n, String[] str){

        ArrayList<String> answer = new ArrayList<>();

        for(String x : str){
            char[] c = x.toCharArray();
            int lt=0;
            int rt=x.length()-1;

            while(lt<rt){
                char temp = c[lt];
                c[lt] = c[rt];
                c[rt] = temp;
                lt++;
                rt--;
            }

            String a = String.valueOf(c);
            answer.add(a);
        }
        return answer;
    }

    public ArrayList<String> solution(int n, String[] str){

        ArrayList<String> answer = new ArrayList<>();

        for(String x : str){
            String temp = new StringBuilder(x).reverse().toString();
            answer.add(temp);
        }
        return answer;
    }

    public static void main(String[] args) {
        뒤집기_StringBuilder test = new 뒤집기_StringBuilder();
        Scanner in=new Scanner(System.in);

        int n = in.nextInt();
        String[] str = new String[n];
        for(int i=0; i<n; i++){
            str[i] = in.next();
        }

        for(String x : test.solution(n, str)){
            System.out.println(x);
        }
    }
}
