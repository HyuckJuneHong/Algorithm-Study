package java_algorithm_study.string;

import java.util.Scanner;

public class 문장속단어 {
    public String solution(String str){
        String answer="";
        int min = -1;

        String[] s = str.split(" ");
        for(String x : s){
            int len = x.length();

            if(min < len){
                min = len;
                answer = x;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        문장속단어 test = new 문장속단어();

        Scanner in=new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(test.solution(str));
    }
}
