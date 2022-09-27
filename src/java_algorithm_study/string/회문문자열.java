package java_algorithm_study.string;

import java.util.Scanner;

public class 회문문자열 {
    public String solution(String str){
        String answer = "YES";
        str = str.toUpperCase();
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return "NO";
            }
        }


        return answer;
    }

    public String solution2(String str){
        String answer = "YES";

        String temp = new StringBuilder(str).reverse().toString();

        if(str.equalsIgnoreCase(temp)){
            return answer;
        }
        return "NO";
    }
    public static void main(String[] args) {
        회문문자열 test = new 회문문자열();
        Scanner kb=new Scanner(System.in);
        String str = kb.next();
        System.out.println(test.solution(str));
    }
}
